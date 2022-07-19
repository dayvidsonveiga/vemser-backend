package br.com.vemser.pessoaapi.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "PESSOA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaEntity {

    @Id
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;
}