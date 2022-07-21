package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(" select e" +
            " from ENDERECO_PESSOA e" +
            " where e.pais = :pais")
    List<EnderecoEntity> listEnderecoByPais(@Param("pais") String pais);

    @Query("select e" +
            " from ENDERECO_PESSOA e " +
            " join e.pessoas p " +
            " where p.idPessoa = :idPessoa")
    List<EnderecoEntity> enderecoByIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query("""
            select e
            from ENDERECO_PESSOA e
            """)
    Page<EnderecoEntity> listEnderecoOrdenadoPorCep(Pageable pageable);

    @Query("""
            select e
            from ENDERECO_PESSOA e
            where (e.pais is null OR e.pais = :pais)
            """)
    Page<EnderecoEntity> listEnderecoFiltradoPorPais(Pageable pageable, @Param("pais") String pais);
}
