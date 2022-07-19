package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
}
