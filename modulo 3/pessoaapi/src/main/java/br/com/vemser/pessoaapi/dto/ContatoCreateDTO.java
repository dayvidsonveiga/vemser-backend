package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private TipoContato tipoContato;

    @NotBlank
    @Size(min = 1, max = 13, message = "Número pode ter até 13 números")
    private String numero;

    @NotBlank
    private String descricao;
}
