package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaRelatorioDTO;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findAllByNomeContainsIgnoreCase(String nome);

    PessoaEntity findByCpf(String cpf);

    @Query(" select new br.com.vemser.pessoaapi.dto.PessoaRelatorioDTO(" +
            "p.idPessoa, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "e.cep, " +
            "e.cidade, " +
            "e.estado, " +
            "e.pais, " +
            "a.nome" +
            ")" +
            " from PESSOA p" +
            " left join p.contatos c " +
            " left join p.enderecos e " +
            " left join p.pet a " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa)")
    List<PessoaRelatorioDTO> listPessoaByRelatorio(@Param("idPessoa")Integer idPessoa);
}
