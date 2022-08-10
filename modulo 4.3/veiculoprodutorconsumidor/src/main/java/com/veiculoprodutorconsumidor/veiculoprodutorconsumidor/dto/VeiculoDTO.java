package com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VeiculoDTO {

    private LocalDateTime dataLeitura;

    private Double velocidade;

    private Integer rotacao;

    private Boolean sensorFrenagem;
}
