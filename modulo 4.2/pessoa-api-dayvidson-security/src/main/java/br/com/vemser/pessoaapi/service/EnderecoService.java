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
        EnderecoEntity enderecoEntity = enderecoCreateDtoToEndereco(enderecoCreateDTO);
        enderecoEntity.setPessoas(Set.of(pessoa));

        EnderecoDTO enderecoDTO = enderecoToEnderecoDTO(enderecoRepository.save(enderecoEntity));
        log.info("Endereço adicionado");

        emailService.sendEmailAdicionarEndereco(pessoa);
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizarDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = findByIdEndereco(idEndereco);

        log.info("Atualizando endereco  " + idEndereco);
        EnderecoEntity enderecoEntity = enderecoCreateDtoToEndereco(enderecoAtualizarDTO);
        enderecoEntity.setIdEndereco(idEndereco);
        enderecoEntity.setPessoas(enderecoRecuperado.getPessoas());
        EnderecoDTO enderecoDTO = enderecoToEnderecoDTO(enderecoRepository.save(enderecoEntity));
        log.info("Endereço atualizado");

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


    // Utilização interna

    public EnderecoEntity findByIdEndereco(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
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