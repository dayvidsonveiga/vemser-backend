package com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.entity.VeiculoEntity;
import com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;
    private final VeiculoRepository veiculoRepository;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void consumir(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset){
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
    }

    @KafkaListener(
            topics = "${kafka.topic-veiculo}", // meu-segundo-topico
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "banco")
    public void consumirBanco(@Payload String mensagem,
                              @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                              @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        VeiculoDTO veiculoDTO = objectMapper.readValue(mensagem, VeiculoDTO.class);
        VeiculoEntity veiculoEntity = objectMapper.convertValue(veiculoDTO, VeiculoEntity.class);
        veiculoRepository.save(veiculoEntity);
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, veiculoDTO);
    }
}
