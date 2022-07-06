package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa adicionar(Pessoa pessoa){
        return pessoaRepository.create(pessoa);
    }

    public Pessoa editar(int id, Pessoa pessoa) throws Exception {
        return pessoaRepository.update(id, pessoa);
    }

    public void deletar(int id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listar(){
        return pessoaRepository.list();
    }

    public List<Pessoa> listarPorNome(String nome){
        return pessoaRepository.listByName(nome);
    }

    public Pessoa pessoaPorNome(String nome){
        return pessoaRepository.peopleByName(nome);
    }

    public Pessoa pessoaPorId(int id){
        return pessoaRepository.peopleById(id);
    }

}
