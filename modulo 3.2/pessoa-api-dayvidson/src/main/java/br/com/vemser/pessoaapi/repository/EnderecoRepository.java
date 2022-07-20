package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(" select e" +
            " from ENDERECO_PESSOA e" +
            " where e.pais = :pais")
    List<EnderecoEntity> listEnderecoByPais(@Param("pais") String pais);
}
