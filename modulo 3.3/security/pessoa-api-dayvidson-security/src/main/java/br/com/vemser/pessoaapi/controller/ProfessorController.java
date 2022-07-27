package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.ProfessorEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@Validated
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<ProfessorEntity> create(@RequestBody ProfessorEntity professor) throws RegraDeNegocioException {
        professorRepository.save(professor);
        return new ResponseEntity<>(professor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> list() {
        return new ResponseEntity<>(professorRepository.findAll(), HttpStatus.OK);
    }
}
