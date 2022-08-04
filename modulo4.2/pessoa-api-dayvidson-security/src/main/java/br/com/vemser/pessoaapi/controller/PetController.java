package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.Response;
import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;


    @Operation(summary = "Listar pets", description = "Lista todos os pessoas do banco de dados")
    @Response
    @GetMapping
    public ResponseEntity<List<PetDTO>> list() {
        return new ResponseEntity<>(petService.list(), HttpStatus.OK);
    }

    @Operation(summary = "Adicionar pet", description = "Insere pet no banco de dados")
    @Response
    @PostMapping
    public ResponseEntity<PetDTO> post(@RequestBody PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity(petService.post(petCreateDTO), HttpStatus.OK);
    }

    @Operation(summary = "Atualizar pet",
            description = "Atualiza pet existente no banco de dados, localizando-o pelo ID")
    @Response
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> put(
            @PathVariable("idPet") Integer id, @RequestBody PetCreateDTO petCreateDTO)
            throws RegraDeNegocioException {
        return new ResponseEntity(petService.put(id, petCreateDTO), HttpStatus.OK);
    }

    @Operation(summary = "Deletar pet",
            description = "Deleta pet existente no banco de dados, localizando-o pelo ID")
    @Response
    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer id) throws RegraDeNegocioException {
        petService.delete(id);
    }
}
