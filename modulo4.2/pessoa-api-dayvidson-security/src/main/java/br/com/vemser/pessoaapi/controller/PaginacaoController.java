package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entities.ContatoEntity;
import br.com.vemser.pessoaapi.entities.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {

    private final ContatoRepository contatoRepository;

    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contato-por-descricao-ordenado")
    public Page<ContatoEntity> getContatoPorDescricao(Integer pagina, Integer quantidadeRegistros, @RequestParam(required = false) String descricao){
        Sort ordenacao = Sort.by("descricao").ascending();

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);

        return contatoRepository.listContatosOrdenadosDescricao(pageable);
    }

    @GetMapping("/endereco-por-cep-ordenado")
    public Page<EnderecoEntity> getEnderecoPorCepOrdenado(Integer pagina, Integer quantidadeRegistros, @RequestParam(required = false) String cep){
        Sort ordenacao = Sort.by("cep").ascending();

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);

        return enderecoRepository.listEnderecoOrdenadoPorCep(pageable);
    }

    @GetMapping("/endereco-por-pais")
    public Page<EnderecoEntity> getEnderecoPorPais(Integer pagina, Integer quantidadeRegistros, @RequestParam(required = false) String pais){

        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros);

        return enderecoRepository.listEnderecoFiltradoPorPais(pageable, pais);
    }



}
