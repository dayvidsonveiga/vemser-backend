package br.com.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank
    private String email;
}
