package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public EnderecoService() {
    }

    public Endereco adicionar(Integer id, Endereco endereco) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        endereco.setIdPessoa(pessoaRecuperada.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco editar(int id, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não econtrada"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

    public void deletar(int id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        enderecoRepository.list().remove(enderecoRecuperado);
    }

    public List<Endereco> listar() {
        return enderecoRepository.list();
    }

    public Endereco listarPorEndereco(int id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        return enderecoRecuperado;

    }

    public List<Endereco> listPorPessoa(Integer id) {
        return enderecoRepository.list().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}