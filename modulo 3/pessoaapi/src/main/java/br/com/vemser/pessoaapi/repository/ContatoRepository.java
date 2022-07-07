package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public static List<Contato> getListaContatos() {
        return listaContatos;
    }

    public static void setListaContatos(List<Contato> listaContatos) {
        ContatoRepository.listaContatos = listaContatos;
    }

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, "61994514396", "Movel"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, "61994513396", "Movel"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, "61999999999", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, "61394514396", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 5, "61794514396", "Residencial"));
    }

    public Contato createContato(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato updateContato(Integer id, Contato pessoaAtualizar) throws Exception {
        Contato contato = new Contato();
        contato.setDescricao(contato.getDescricao());
        contato.setNumero(contato.getNumero());
        contato.setDescricao(contato.getDescricao());
        contato.setIdPessoa(contato.getIdPessoa());
        return pessoaAtualizar;
    }

    public void deleteContato(Contato contato) throws Exception {

        listaContatos.remove(contato);
    }

}
