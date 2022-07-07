package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoService(){
    }

    public Endereco adicionar(Integer id, Endereco endereco){
        endereco.setIdPessoa(id);
        return enderecoRepository.create(endereco);
    }

    public Endereco editar(int id, Endereco endereco) throws Exception {
        Endereco enderecoRecuperado = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não econtrada"));
        return enderecoRepository.update(enderecoRecuperado);
    }

    public void deletar(int id) throws Exception {
        Endereco enderecoRecuperado = EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> listar(){
        return enderecoRepository.list();
    }

    public List<Endereco> listarPorEndereco(int id){
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listPorPessoa(Integer id) {
        return EnderecoRepository.getListaEndereco().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}