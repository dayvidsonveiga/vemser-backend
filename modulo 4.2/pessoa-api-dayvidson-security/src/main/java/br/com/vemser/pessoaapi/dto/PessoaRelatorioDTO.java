package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaRelatorioDTO {

    @Schema(description = "ID da Pessoa")
    private Integer idPessoa;

    @Schema(description = "Nome da Pessoa")
    private String nome;

    @Schema(description = "E-mail da Pessoa")
    private String email;

    @Schema(description = "Número de telefone da Pessoa")
    private String numero;

    @Schema(description = "CEP do endereõ da Pessoa")
    private String cep;

    @Schema(description = "Cidade da Pessoa")
    private String cidade;

    @Schema(description = "Estado da Pessoa")
    private String estado;

    @Schema(description = "Pais da Pessoa")
    private String pais;

    @Schema(description = "Nome do Pet")
    private String nomePet;
}
