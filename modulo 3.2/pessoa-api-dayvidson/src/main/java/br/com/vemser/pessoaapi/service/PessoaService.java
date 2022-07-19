package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("Criando a pessoa...");

        //Convertendo PessoaDTO em PessoaEntity para inserção no repository
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoaEntity = pessoaRepository.create(pessoaEntity);

        //Convertendo PessoaEntity em PessoaDTO para utilização na Service
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info("Pessoa " + pessoaDTO.getNome() + " criada!");
        emailService.sendEmailCriarPessoa(pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando a pessoa...");
        PessoaEntity pessoaEntity = findByIdPessoa(id);

        pessoaEntity.setCpf(pessoaAtualizar.getCpf());
        pessoaEntity.setNome(pessoaAtualizar.getNome());
        pessoaEntity.setDataNascimento(pessoaAtualizar.getDataNascimento());

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info(pessoaDTO.getNome() + " teve seus dados atualizados no banco");
        emailService.sendEmailAlterarPessoa(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Deletando a pessoa...");
        PessoaEntity pessoaEntityRecuperada = findByIdPessoa(id);
        pessoaRepository.list().remove(pessoaEntityRecuperada);
        log.info(pessoaEntityRecuperada.getNome() + " foi removido do banco de dados");
        emailService.sendEmailDeletarPessoa(pessoaEntityRecuperada);
    }

    public List<PessoaDTO> list() {
        log.info("Listar todas as pessoas");
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        log.info("Listar pessoa por id");
        return objectMapper.convertValue(findByIdPessoa(idPessoa), PessoaDTO.class);
    }

    public List<PessoaDTO> listByName(String nome) throws RegraDeNegocioException {
        log.info("Listar pessoa por nome");
        if(findByName(nome).isEmpty()){
            log.info("Nome não encontrado");
            throw new RegraDeNegocioException("Nome não encontrado");
        }
        else {
            log.info("Nome encontrado");
            return findByName(nome).stream()
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }
    }

    //Utilização Interna
    public PessoaEntity findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoaEntity> findByName(String nome) {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

}