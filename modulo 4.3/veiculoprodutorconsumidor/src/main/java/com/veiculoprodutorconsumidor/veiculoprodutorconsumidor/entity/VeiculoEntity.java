package com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "veiculos")
@Getter
@Setter
public class VeiculoEntity {

    private LocalDateTime dataLeitura;

    private Double velocidade;

    private Integer rotacao;

    private Boolean sensorFrenagem;
}
