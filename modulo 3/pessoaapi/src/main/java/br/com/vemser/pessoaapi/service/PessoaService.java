package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("Criando a pessoa...");

        //Convertendo PessoaDTO em PessoaEntity para inserção no repository
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        pessoaEntity = pessoaRepository.create(pessoaEntity);

        //Convertendo PessoaEntity em PessoaDTO para utilização na Service
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info("Pessoa " + pessoaDTO.getNome() + " criada!");
        return pessoaDTO;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando a pessoa...");
        Pessoa pessoaEntity = findByIdPessoa(id);

        pessoaEntity.setCpf(pessoaAtualizar.getCpf());
        pessoaEntity.setNome(pessoaAtualizar.getNome());
        pessoaEntity.setDataNascimento(pessoaAtualizar.getDataNascimento());

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info(pessoaDTO.getNome() + " teve seus dados atualizados no banco");
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Deletando a pessoa...");
        Pessoa pessoaRecuperada = findByIdPessoa(id);
        pessoaRepository.list().remove(pessoaRecuperada);
        log.info(pessoaRecuperada.getNome() + " foi removido do banco de dados");
    }

    public List<PessoaDTO> list() {
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        List<Pessoa> pessoasEntity = pessoaRepository.list();
        for (Pessoa pessoa : pessoasEntity) {
            pessoasDTO.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
        }
        return pessoasDTO;
    }

    public List<PessoaDTO> listByName(String nome) {
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        List<Pessoa> pessoasEntity = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
        for (Pessoa pessoa : pessoasEntity) {
            pessoasDTO.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
        }
        return pessoasDTO;
    }

    //Utilização Interna
    public Pessoa findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

}