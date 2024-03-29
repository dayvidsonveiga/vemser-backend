package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entities.ContatoEntity;
import br.com.vemser.pessoaapi.entities.EnderecoEntity;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.entities.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PetRepository petRepository;


    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("Criando pessoa...");

        PessoaDTO pessoaDTO = entityToPessoaDTO(pessoaRepository.save(pessoaCreateDtoToPessoaEntity(pessoaCreateDTO)));

        log.info(pessoaDTO.getNome() + " adicionado(a) ao banco de dados");

        emailService.sendEmailCriarPessoa(pessoaDTO);

        return pessoaDTO;
    }

    public PessoaDTO update(Integer idPessoa, PessoaCreateDTO pessoaAtualizarDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listByIdPessoa(idPessoa);

        log.info("Atualizando pessoa...");

        PessoaEntity pessoaEntity = pessoaCreateDtoToPessoaEntity(pessoaAtualizarDTO);

        pessoaEntity.setIdPessoa(idPessoa);
        pessoaEntity.setContatos(pessoaRecuperada.getContatos());
        pessoaEntity.setEnderecos(pessoaRecuperada.getEnderecos());

        PessoaDTO pessoaDTO = entityToPessoaDTO(pessoaRepository.save(pessoaEntity));

        log.info("Dados de " + pessoaDTO.getNome() + " atualizados no banco de dados");

        emailService.sendEmailAlterarPessoa(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listByIdPessoa(idPessoa);

        log.warn("Deletando...");

        petRepository.delete(pessoaRecuperada.getPet());
        pessoaRepository.delete(pessoaRecuperada);

        log.info(pessoaRecuperada.getNome() + " removida do banco de dados");

        emailService.sendEmailDeletarPessoa(pessoaRecuperada);
    }

    public void salvar(PessoaEntity pessoaEntity) {
        pessoaRepository.save(pessoaEntity);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(this::entityToPessoaDTO).toList();
    }

    public PessoaEntity listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAllByNomeContainsIgnoreCase(nome).stream()
                .map(this::entityToPessoaDTO)
                .toList();
    }

    public PessoaDTO listByCpf(String cpf) {
        return entityToPessoaDTO(pessoaRepository.findByCpf(cpf));
    }

    public List<PessoaDTO> listPessoaWithEndereco(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa)
                    .map(this::mapPessoaWithEndereco)
                    .stream().toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(this::mapPessoaWithEndereco)
                    .toList();
        }
    }

    public List<PessoaDTO> listPessoaWithContato(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa)
                    .map(this::mapPessoaWithContato)
                    .stream().toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(this::mapPessoaWithContato)
                    .toList();
        }
    }

    public List<PessoaDTO> listPessoaWithPet(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa)
                    .map(this::mapPessoaWithPet)
                    .stream().toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(this::mapPessoaWithPet)
                    .toList();
        }
    }

    public List<PessoaDTO> listPessoaCompleta(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa)
                    .map(this::mapPessoaCompleta)
                    .stream().toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(this::mapPessoaCompleta)
                    .toList();
        }
    }

    public List<PessoaRelatorioDTO> listPessoaRelatorio(Integer idPessoa) {
        return pessoaRepository.listPessoaByRelatorio(idPessoa);
    }

    private PessoaDTO mapPessoaWithEndereco(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = entityToPessoaDTO(pessoaEntity);
        pessoaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                .map(this::enderecoToEnderecoDTO).toList());
        return pessoaDTO;
    }

    private PessoaDTO mapPessoaWithContato(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = entityToPessoaDTO(pessoaEntity);
        pessoaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                .map(this::contatoToContatoDto).toList());
        return pessoaDTO;
    }

    private PessoaDTO mapPessoaWithPet(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = entityToPessoaDTO(pessoaEntity);
        pessoaDTO.setPetDTO(petToPetDTO(pessoaEntity.getPet()));
        return pessoaDTO;
    }

    private PessoaDTO mapPessoaCompleta(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = entityToPessoaDTO(pessoaEntity);
        pessoaDTO.setContatoDTOS(pessoaEntity.getContatos().stream()
                .map(this::contatoToContatoDto).toList());
        pessoaDTO.setEnderecoDTOS(pessoaEntity.getEnderecos().stream()
                .map(this::enderecoToEnderecoDTO).toList());
        pessoaDTO.setPetDTO(petToPetDTO(pessoaEntity.getPet()));
        return pessoaDTO;
    }

    public PessoaEntity pessoaCreateDtoToPessoaEntity(PessoaCreateDTO pessoaCreateDTO) {
        return objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
    }

    public PessoaDTO entityToPessoaDTO(PessoaEntity pessoaEntity) {
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public EnderecoDTO enderecoToEnderecoDTO(EnderecoEntity endereco) {
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public ContatoDTO contatoToContatoDto(ContatoEntity contato) {
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public PetDTO petToPetDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }
}
