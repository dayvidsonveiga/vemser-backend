package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public Pessoa create(Pessoa pessoa) throws Exception {
//        boolean pessoaExiste = ObjectUtils.isEmpty(pessoa.getDataNascimento());
//        boolean nomeEmBranco = StringUtils.isBlank(pessoa.getNome());
////        boolean cpfEmBranco = StringUtils.isBlank(pessoa.getCpf());
//
//        if (!nomeEmBranco && !pessoaExiste && !cpfEmBranco && pessoa.getCpf().length() == 14) {
        return pessoaRepository.create(pessoa);
//        } else {
//            throw new RegraDeNegocioException("Pessoa não foi criada");
//        }
    }

    public List<Pessoa> list (){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = findByIdPessoa(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = findByIdPessoa(id);
        pessoaRepository.list().remove(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    public Pessoa findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return pessoaRecuperada;
    }

    //Teste para verificar se consigo recuperar pessoa pelo nome
//    public Pessoa findByName(String nome) throws RegraDeNegocioException {
//        Pessoa pessoaNomeRecuperado = pessoaRepository.list().stream()
//                .filter(pessoa -> pessoa.getNome().equals(nome))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Nome da Pessoa não encontrado"));
//        return pessoaNomeRecuperado;
//    }
}