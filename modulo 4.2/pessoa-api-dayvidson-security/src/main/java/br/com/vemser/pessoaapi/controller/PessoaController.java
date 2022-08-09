package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.PessoaRelatorioDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;


    @Operation(summary = "Adicionar pessoa", description = "Insere pessoa no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o corpo da pessoa inserida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar pessoa", description = "Atualiza pessoa existente no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o corpo da pessoa atualizada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody @Valid PessoaCreateDTO pessoaDTOAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.update(id, pessoaDTOAtualizar), HttpStatus.OK);
    }

    @Operation(summary = "Deletar pessoa", description = "Deleta pessoa existente no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Status OK"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @Operation(summary = "listar pessoas por nome", description = "Lista todas as pessoas do banco com o nome informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas pelo parâmetro nome"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byNome/{nome}")
    public ResponseEntity<List<PessoaDTO>> listByName(@PathVariable("nome") String nome) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @GetMapping("/byCpf/{cpf}")
    public ResponseEntity<PessoaDTO> listByCpf(@PathVariable("cpf") String cpf) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.listByCpf(cpf), HttpStatus.OK);
    }

    @Response
    @Operation(summary = "Listar pessoas e pets",
            description = "Lista todas as pessoas do banco de dados, com seus respectivos pets. " +
                    "Caso seja especificada uma pessoa (por Query Param), traz somente as informações referentes à ela")
    @GetMapping("/listar-com-pet")
    public ResponseEntity<List<PessoaDTO>> listPessoaWithPet(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaWithPet(idPessoa), HttpStatus.OK);
    }

    @Response
    @Operation(summary = "Listar pessoas e contatos",
            description = "Lista todas as pessoas do banco de dados, com seus respectivos contatos. " +
                    "Caso seja especificada uma pessoa (por Query Param), traz somente as informações referentes à ela")
    @GetMapping("/listar-com-contatos")
    public ResponseEntity<List<PessoaDTO>> listPessoaWithContatos(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaWithContato(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas e enderecos",
            description = "Lista todas as pessoas do banco de dados, com seus respectivos endereços. " +
                    "Caso seja especificada uma pessoa (por Query Param), traz somente as informações referentes à ela")
    @Response
    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<List<PessoaDTO>> listPessoaWithEnderecos(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaWithEndereco(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas com seu dados completos",
            description = "Lista todas as pessoas do banco de dados, com seus respectivos endereços, contatos e pet. " +
                    "Caso seja especificada uma pessoa (por Query Param), traz somente as informações referentes à ela")
    @Response
    @GetMapping("/listar-pessoa-completa")
    public ResponseEntity<List<PessoaDTO>> listPessoaCompleta(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaCompleta(idPessoa), HttpStatus.OK);
    }

    @Operation(summary = "Listar pessoas com seu dados personalizados",
            description = "Lista todas as pessoas do banco de dados, com seus respectivos id, nome, email, numero, cep, cidade, estado, pais, e nome do pet. " +
                    "Caso seja especificada uma pessoa (por Query Param), traz somente as informações referentes à ela")
    @Response
    @GetMapping("/listar-pessoa-relatorio")
    public ResponseEntity<List<PessoaRelatorioDTO>> listPessoaRelatorio(@RequestParam(required = false) Integer idPessoa) {
        return new ResponseEntity<>(pessoaService.listPessoaRelatorio(idPessoa), HttpStatus.OK);
    }
}

