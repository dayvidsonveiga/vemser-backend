package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> retornaEndereco(){
        return enderecoService.listar();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> retornaEnderecoPorId(@PathVariable("idEndereco") Integer idEndereco){
        return enderecoService.listarPorEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> retornaEnderecoPorPessoa(@PathVariable("idPessoa") Integer idPessoa){
        return enderecoService.listPorPessoa(idPessoa);
    }

    @PostMapping("/pessoa/{idPessoa}")
    public Endereco adicionarPessoa(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Endereco endereco){
        return enderecoService.adicionar(idPessoa,endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco editaEndereco(@PathVariable("idEndereco") Integer idEndereco, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.editar(idEndereco,endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void deletaEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        enderecoService.deletar(idEndereco);
    }
}