package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.ProfessorEntity;
import br.com.vemser.pessoaapi.entities.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {
}
