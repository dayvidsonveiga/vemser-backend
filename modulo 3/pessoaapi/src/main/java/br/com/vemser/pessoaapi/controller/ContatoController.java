package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    //Modelo mais novo
//    private final ContatoService contatoService;

    //Modelo mais novo
//        public ContatoController(){
//        contatoService = new ContatoService();
//    }

    @Autowired
    private ContatoService contatoService;

//    public ContatoController(ContatoService contatoService){
//        this.contatoService = contatoService;
//    }

    @PostMapping ("/{idPessoa}")//localhost:8080/contato
    public Contato create(@PathVariable ("idPessoa") Integer idPessoa, @RequestBody @Valid Contato contato) throws RegraDeNegocioException {
        return contatoService.create(idPessoa, contato);
    }

    @GetMapping //localhost:8080/contato
    public List<Contato> list (){
        return contatoService.list();
    }

    @GetMapping("/byIdPessoa") //localhost:8080/contato/byIdPessoa?idPessoa=1
    public List<Contato> listByIdPessoaParams (@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("/{idPessoa}") //localhost:8080/contato/2
    public List<Contato> listByIdPessoa(@PathVariable ("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public Contato update(@PathVariable("idContato") Integer id, @RequestBody @Valid Contato contatoAtualizar) throws RegraDeNegocioException{
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}

