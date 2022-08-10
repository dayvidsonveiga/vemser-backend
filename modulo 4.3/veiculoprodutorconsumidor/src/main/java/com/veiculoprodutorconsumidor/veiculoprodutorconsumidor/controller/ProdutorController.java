package com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagem(String mensagem){
        produtorService.enviarMensagemString(mensagem);
    }

    @PostMapping("/enviar-dados-veiculo")
    public void enviarMensagem(@RequestBody VeiculoDTO veiculoDTO) throws JsonProcessingException {
        produtorService.enviarMensagemVeiculo(veiculoDTO);
    }

    @GetMapping("/todos-sensores")
    public ResponseEntity<List<VeiculoDTO>> listAllVeiculosDTO() {
        return new ResponseEntity<>(produtorService.listAll(), HttpStatus.OK);
    }

}
