package br.com.vemser.pessoaapi.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotBlank(message = "Insira um nome!" )
    private String nome;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotEmpty
    @Size(min = 11, max = 11, message = "CPF deve conter 11 números")
    private String cpf;
}
