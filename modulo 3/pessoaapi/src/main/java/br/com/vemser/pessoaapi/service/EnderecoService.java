package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    ObjectMapper objectMapper;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("Criando endereço...");
        Pessoa pessoa = pessoaService.findByIdPessoa(idPessoa);
        log.info("Criando o endereço para: " + pessoa.getNome());

        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        enderecoEntity.setIdPessoa(idPessoa);
        enderecoEntity = enderecoRepository.create(enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        log.info("Endereço criado!");
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTOAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando endereço...");
        Endereco enderecoEntityAtualizado = findByIdEndereco(id);
        Pessoa pessoaRecuperada = pessoaService.findByIdPessoa(enderecoEntityAtualizado.getIdPessoa());
        log.info("Atualizando o endereço de: " + pessoaRecuperada.getNome());

        enderecoEntityAtualizado.setTipo(enderecoCreateDTOAtualizar.getTipo());
        enderecoEntityAtualizado.setLogradouro(enderecoCreateDTOAtualizar.getLogradouro());
        enderecoEntityAtualizado.setNumero(enderecoCreateDTOAtualizar.getNumero());
        enderecoEntityAtualizado.setComplemento(enderecoCreateDTOAtualizar.getComplemento());
        enderecoEntityAtualizado.setCep(enderecoCreateDTOAtualizar.getCep());
        enderecoEntityAtualizado.setCidade(enderecoCreateDTOAtualizar.getCidade());
        enderecoEntityAtualizado.setEstado(enderecoCreateDTOAtualizar.getEstado());
        enderecoEntityAtualizado.setPais(enderecoCreateDTOAtualizar.getPais());

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntityAtualizado, EnderecoDTO.class);
        log.info("Endereço atualizado!");
        return enderecoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        Endereco enderecoRecuperado = findByIdEndereco(id);
        enderecoRepository.list().remove(enderecoRecuperado);
        log.info("Endereço deletado!");
    }

    public List<EnderecoDTO> list() {
        List<Endereco> listEnderecoEntity = enderecoRepository.list();
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();
        for (Endereco endereco : listEnderecoEntity) {
            listEnderecoDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return listEnderecoDTO;
    }

    public List<EnderecoDTO> listByIdEndereco(Integer idEndereco) {
        List<Endereco> listEnderecoEntity = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();
        for (Endereco endereco : listEnderecoEntity) {
            listEnderecoDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return listEnderecoDTO;
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        List<Endereco> listEnderecoEntity = enderecoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();
        for (Endereco endereco : listEnderecoEntity) {
            listEnderecoDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return listEnderecoDTO;
    }

    //Utilização interna
    public Endereco findByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoById = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoById;
    }
}