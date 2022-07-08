package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }

    public Contato create(Integer idPessoa, Contato contato) throws RegraDeNegocioException {
        pessoaService.findByIdPessoa(idPessoa);
        contato.setIdPessoa(idPessoa);
        return contatoRepository.create(idPessoa, contato);
    }

    public List<Contato> list (){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws RegraDeNegocioException{
        Contato contatoAtualizado = findByIdContato(id);
        pessoaService.findByIdPessoa(id);
        contatoAtualizado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoAtualizado.setNumero(contatoAtualizar.getNumero());
        contatoAtualizado.setDescricao(contatoAtualizar.getDescricao());
        return contatoAtualizado;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contatoRepository.deleteContato(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Contato findByIdContato(Integer idContato) throws RegraDeNegocioException {
        Contato contatoById = contatoRepository.list().stream()
                .filter(endereco -> endereco.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoById;
    }
}

