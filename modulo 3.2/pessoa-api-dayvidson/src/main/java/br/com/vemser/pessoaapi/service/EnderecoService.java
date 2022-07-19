package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entities.EnderecoEntity;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;

    @Autowired
    ObjectMapper objectMapper;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("Criando endereço...");
        PessoaEntity pessoaEntity = pessoaService.findByIdPessoa(idPessoa);
        log.info("Criando o endereço para: " + pessoaEntity.getNome());

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoEntity.setIdPessoa(idPessoa);
        enderecoEntity = enderecoRepository.create(enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        log.info("Endereço criado!");
        emailService.sendEmailAdicionarEndereco(pessoaEntity);
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTOAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando endereço...");
        EnderecoEntity enderecoEntityEntityAtualizado = findByIdEndereco(idEndereco);
        PessoaEntity pessoaEntityRecuperada = pessoaService.findByIdPessoa(enderecoEntityEntityAtualizado.getIdPessoa());
        log.info("Atualizando o endereço de: " + pessoaEntityRecuperada.getNome());

        enderecoEntityEntityAtualizado.setTipo(enderecoCreateDTOAtualizar.getTipo());
        enderecoEntityEntityAtualizado.setLogradouro(enderecoCreateDTOAtualizar.getLogradouro());
        enderecoEntityEntityAtualizado.setNumero(enderecoCreateDTOAtualizar.getNumero());
        enderecoEntityEntityAtualizado.setComplemento(enderecoCreateDTOAtualizar.getComplemento());
        enderecoEntityEntityAtualizado.setCep(enderecoCreateDTOAtualizar.getCep());
        enderecoEntityEntityAtualizado.setCidade(enderecoCreateDTOAtualizar.getCidade());
        enderecoEntityEntityAtualizado.setEstado(enderecoCreateDTOAtualizar.getEstado());
        enderecoEntityEntityAtualizado.setPais(enderecoCreateDTOAtualizar.getPais());

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityEntityAtualizado, EnderecoDTO.class);
        log.info("Endereço atualizado!");
        emailService.sendEmailAtualizarEndereco(pessoaEntityRecuperada);
        return enderecoDTO;
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        EnderecoEntity enderecoEntityRecuperado = findByIdEndereco(idEndereco);
        PessoaEntity pessoaEntityRecuperada = pessoaService.findByIdPessoa(enderecoEntityRecuperado.getIdPessoa());
        enderecoRepository.list().remove(enderecoEntityRecuperado);
        emailService.sendEmailRemoverEndereco(pessoaEntityRecuperada);
        log.info("Endereço deletado!");
    }

    public List<EnderecoDTO> list() {
        log.info("Listar todos os endereços");
        return enderecoRepository.list().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        log.info("Listar endereco por id");
        return objectMapper.convertValue(findByIdEndereco(idEndereco), EnderecoDTO.class);
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        log.info("Listar endereco por id de Pessoa");
        pessoaService.findByIdPessoa(idPessoa);
        return enderecoRepository.list().stream()
                .filter(enderecoEntity -> enderecoEntity.getIdPessoa().equals(idPessoa))
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    //Utilização interna
    public EnderecoEntity findByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityById = enderecoRepository.list().stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoEntityById;
    }
}