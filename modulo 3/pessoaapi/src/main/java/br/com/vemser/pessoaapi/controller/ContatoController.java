package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entities.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
@Validated
public class ContatoController {

    //Modelo mais novo
//    private final ContatoService contatoService;

    //Modelo mais novo
//        public ContatoController(){
//        contatoService = new ContatoService();
//    }

//    public ContatoController(ContatoService contatoService){
//        this.contatoService = contatoService;
//    }
    @Autowired
    private ContatoService contatoService;

    @PostMapping ("/{idPessoa}")//localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@PathVariable ("idPessoa") Integer idPessoa, @RequestBody @Valid ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.create(idPessoa, contatoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @RequestBody @Valid ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException{
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizarDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/{idContato}
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }

    @GetMapping //localhost:8080/contato
    public List<ContatoDTO> list (){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}") //localhost:8080/contato/2
    public List<ContatoDTO> listByIdPessoa(@PathVariable ("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }
}

