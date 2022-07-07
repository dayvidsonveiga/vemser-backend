package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.Pessoa;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    public PessoaController() {
        pessoaService = new PessoaService();
    }

    @GetMapping("/ambiente")
    public String retornaAmbiente(){
        return propertieReader.getUsuario();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @PostMapping // localhost:8080/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.adicionar(pessoa);
    }

    @GetMapping // localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.listar();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listarPorNome(nome);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.editar(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.deletar(id);
    }
}
