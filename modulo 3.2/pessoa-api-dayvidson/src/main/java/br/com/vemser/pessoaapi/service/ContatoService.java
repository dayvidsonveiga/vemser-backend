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

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("Criando contato...");
        PessoaEntity pessoaEntity = pessoaService.findByIdPessoa(idPessoa);
        log.info("Adicionando contato para " + pessoaEntity.getNome());

        contatoCreateDTO.setIdPessoa(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoEntity = contatoRepository.create(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        emailService.sendEmailAdicionarContato(pessoaEntity);
        log.info("ContatoEntity adicionado!");
        return contatoDTO;
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoCreateDTOAtualizar) throws RegraDeNegocioException{
        log.info("Atualizando contato...");
        ContatoEntity contatoEntityEntityAtualizado = findByIdContato(idContato);
        PessoaEntity pessoaEntity = pessoaService.findByIdPessoa(contatoEntityEntityAtualizado.getIdPessoa());

        contatoEntityEntityAtualizado.setTipoContato(contatoCreateDTOAtualizar.getTipoContato());
        contatoEntityEntityAtualizado.setNumero(contatoCreateDTOAtualizar.getNumero());
        contatoEntityEntityAtualizado.setDescricao(contatoCreateDTOAtualizar.getDescricao());

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntityEntityAtualizado, ContatoDTO.class);
        emailService.sendEmailAtualizarContato(pessoaEntity);
        log.info("ContatoEntity atualizado!");
        return contatoDTO;
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        log.info("Deletando contato...");
        ContatoEntity contatoEntityRecuperado = findByIdContato(idContato);
        PessoaEntity pessoaEntity = pessoaService.findByIdPessoa(contatoEntityRecuperado.getIdPessoa());
        contatoRepository.deleteContato(contatoEntityRecuperado);
        emailService.sendEmailRemoverContato(pessoaEntity);
        log.info("ContatoEntity deletado!");
    }

    public List<ContatoDTO> list (){
        log.info("Listar todos os contatos");
        return contatoRepository.list().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        log.info("Listar contato por idPessoa");
        pessoaService.findByIdPessoa(idPessoa);
        return contatoRepository.list().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(idPessoa))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    //Utilização Interna
    public ContatoEntity findByIdContato(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity contatoEntityById = contatoRepository.list().stream()
                .filter(endereco -> endereco.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("ContatoEntity não encontrado"));
        return contatoEntityById;
    }
}

