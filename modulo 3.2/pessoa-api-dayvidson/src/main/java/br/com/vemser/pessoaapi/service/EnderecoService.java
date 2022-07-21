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

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private ObjectMapper objectMapper;


    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO, Integer idPessoa) throws RegraDeNegocioException {
        log.info("Adicionando endereço...");

        PessoaEntity pessoa = pessoaService.listByIdPessoa(idPessoa);

        Set<PessoaEntity> pessoas = new HashSet<>();
        pessoas.add(pessoa);

        EnderecoEntity enderecoEntity = enderecoCreateDtoToEndereco(enderecoCreateDTO);
        enderecoEntity.setPessoas(pessoas);
        EnderecoDTO enderecoDTO = enderecoToEnderecoDTO(enderecoRepository.save(enderecoEntity));

        log.info("Endereço adicionado");

        emailService.sendEmailAdicionarEndereco(pessoa);

        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizarDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityRecuperado = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        EnderecoEntity enderecoEntity = enderecoCreateDtoToEndereco(enderecoAtualizarDTO);
        enderecoEntity.setIdEndereco(idEndereco);
        enderecoEntity.setPessoas(enderecoEntityRecuperado.getPessoas());

        EnderecoDTO enderecoDTO = enderecoToEnderecoDTO(enderecoRepository.save(enderecoEntity));

        return enderecoDTO;
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityRecuperado = enderecoDTOToEnderecoEntity(listByIdEndereco(idEndereco));

        log.warn("Removendo endereço...");

        enderecoRepository.delete(enderecoEntityRecuperado);

        log.info("Endereço removido");
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(this::enderecoToEnderecoDTO)
                .toList();
    }

    public EnderecoDTO listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoToEnderecoDTO(enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado")));

    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        return pessoaService.listPessoaWithEndereco(idPessoa).get(0).getEnderecoDTOS();
    }

    public List<EnderecoDTO> listByIdPessoa2(Integer idPessoa) {
        return enderecoRepository.enderecoByIdPessoa(idPessoa).stream()
                .map(enderecoEntity -> enderecoToEnderecoDTO(enderecoEntity)).toList();
    }

    public EnderecoEntity enderecoCreateDtoToEndereco (EnderecoCreateDTO enderecoCreateDTO){
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
    }

    public EnderecoDTO enderecoToEnderecoDTO(EnderecoEntity endereco) {
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoEntity enderecoDTOToEnderecoEntity(EnderecoDTO enderecoDTO) {
        return objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
    }
}