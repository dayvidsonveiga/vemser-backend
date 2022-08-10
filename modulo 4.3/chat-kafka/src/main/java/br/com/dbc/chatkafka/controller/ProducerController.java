package br.com.dbc.chatkafka.controller;

import br.com.dbc.chatkafka.dto.MensagemCreateDTO;
import br.com.dbc.chatkafka.dto.MensagemDTO;
import br.com.dbc.chatkafka.enums.OpcoesEnvio;
import br.com.dbc.chatkafka.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;


    @PostMapping("/enviar-dados-objeto")
    public void enviarMensagem(@RequestBody MensagemCreateDTO mensagemCreateDTO, @RequestParam List<OpcoesEnvio> opcoesEnvio) throws JsonProcessingException {
        producerService.enviarMensagemObjeto(mensagemCreateDTO, opcoesEnvio);
    }

}
