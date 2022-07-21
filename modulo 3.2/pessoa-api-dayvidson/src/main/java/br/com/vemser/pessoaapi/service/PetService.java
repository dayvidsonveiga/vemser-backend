package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.entities.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;


    public PetDTO post(PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        PetEntity petEntity = createDtoToEntity(petCreateDTO);
        PessoaEntity pessoaEntityRecuperada = pessoaService.listByIdPessoa(petEntity.getIdPessoa());

        log.info("Criando pet...");
        petEntity.setPessoa(pessoaEntityRecuperada);
        PetDTO petDTO = entityToPetDTO(petRepository.save(petEntity));

        log.info(petDTO.getNome() + " adicionado ao banco de dados");

        return petDTO;
    }

    public PetDTO put(Integer idPet, PetCreateDTO petAtualizarDTO) throws RegraDeNegocioException {
        PetEntity petRecuperado = petRepository.findById(idPet).orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
        PessoaEntity pessoaEntity = petRecuperado.getPessoa();
        pessoaEntity.setPet(null);

        PessoaEntity pessoaRecuperada = pessoaService.listByIdPessoa(petRecuperado.getIdPessoa());

        log.info("Atualizando pet...");
        petRecuperado.setTipoPet(petAtualizarDTO.getTipoPet());
        petRecuperado.setNome(petAtualizarDTO.getNome());
        petRecuperado.setPessoa(pessoaService.listByIdPessoa(petAtualizarDTO.getIdPessoa()));
        petRecuperado.setIdPessoa(petAtualizarDTO.getIdPessoa());
        pessoaRecuperada.setPet(petRecuperado);
        pessoaService.salvar(pessoaRecuperada);

        if (!pessoaRecuperada.getIdPessoa().equals(pessoaEntity.getIdPessoa())) {
            pessoaService.update(pessoaEntity.getIdPessoa(), objectMapper.convertValue(pessoaEntity, PessoaCreateDTO.class));
        }

        PetDTO petDTO = entityToPetDTO(petRepository.save(petRecuperado));

        log.info("Dados de " + petDTO.getNome() + " atualizados no banco de dados");
        return petDTO;
    }

    public void delete(Integer idPet) throws RegraDeNegocioException {
        PetEntity petEntityRecuperado = listByIdPet(idPet);

        log.warn("Deletando...");

        petRepository.delete(petEntityRecuperado);

        log.info(petEntityRecuperado.getNome() + " removido do banco de dados");
    }

    public List<PetDTO> list() {
        return petRepository.findAll()
                .stream()
                .map(this::entityToPetDTO).toList();
    }

    public PetEntity listByIdPet(Integer idPet) throws RegraDeNegocioException {
        return petRepository.findById(idPet)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
    public PetDTO entityToPetDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }

    public PetEntity createDtoToEntity(PetCreateDTO petCreateDTO) {
        return objectMapper.convertValue(petCreateDTO, PetEntity.class);
    }
}