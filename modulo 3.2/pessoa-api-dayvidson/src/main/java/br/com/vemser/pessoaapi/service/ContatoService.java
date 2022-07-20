package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entities.ContatoEntity;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;


    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO, Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaService.listByIdPessoa(idPessoa);
        contatoCreateDTO.setIdPessoa(idPessoa);

        log.info("Adicionando contato à pessoa: " + pessoa.getNome());
        ContatoDTO contatoDTO = contatoToContatoDto(
                contatoRepository.save(contatoCreateDtoToContato(contatoCreateDTO)));
        log.info("Contato adicionado");

        emailService.sendEmailAdicionarContato(pessoa);

        return contatoDTO;
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaService.listByIdPessoa(contatoAtualizarDTO.getIdPessoa());

        ContatoEntity contatoEntityRecuperado = contatoByIdContato(idContato);
        contatoEntityRecuperado.setIdPessoa(contatoAtualizarDTO.getIdPessoa());
        contatoEntityRecuperado.setTipoContato(contatoAtualizarDTO.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizarDTO.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizarDTO.getDescricao());

        log.info("Atualizando contato de " + pessoa.getNome());
        ContatoDTO contatoDTO = contatoToContatoDto(
                contatoRepository.save(contatoEntityRecuperado));
        log.info("Contato atualizado");

        emailService.sendEmailAtualizarContato(pessoa);

        return contatoDTO;
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaService.listByIdPessoa(contatoByIdContato(idContato).getIdPessoa());

        log.warn("Deletando contato...");
        contatoRepository.delete(contatoByIdContato(idContato));
        log.info("Contato deletado");

        emailService.sendEmailRemoverContato(pessoa);
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(this::contatoToContatoDto)
                .toList();
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .map(this::contatoToContatoDto)
                .toList();
    }

    public ContatoEntity contatoByIdContato(Integer idContato) throws RegraDeNegocioException {
        return contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("O contato informado não existe"));
    }

    public ContatoEntity contatoCreateDtoToContato(ContatoCreateDTO contatoCreateDTO) {
        return objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
    }

    public ContatoDTO contatoToContatoDto(ContatoEntity contato) {
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }
}
