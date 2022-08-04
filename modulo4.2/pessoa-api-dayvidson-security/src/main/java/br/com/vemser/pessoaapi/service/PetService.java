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
        PessoaEntity pessoaEntityRecuperada = pessoaService.listByIdPessoa(petCreateDTO.getIdPessoa());
        if (pessoaEntityRecuperada.getPet() != null) {
            throw new RegraDeNegocioException("Já existe um pet nessa pessoa");
        }

        PetEntity petEntity = createDtoToEntity(petCreateDTO);
        log.info("Criando pet...");
        petEntity.setPessoa(pessoaEntityRecuperada);
        PetDTO petDTO = entityToPetDTO(petRepository.save(petEntity));

        log.info(petDTO.getNome() + " adicionado ao banco de dados");

        return petDTO;
    }

    public PetDTO put(Integer idPet, PetCreateDTO petAtualizarDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = pessoaService.listByIdPessoa(petAtualizarDTO.getIdPessoa());
        PetEntity petEntityRecuperado = listByIdPet(idPet);

        petEntityRecuperado.setNome(petAtualizarDTO.getNome());
        petEntityRecuperado.setTipoPet(petAtualizarDTO.getTipoPet());
        petEntityRecuperado.setPessoa(pessoaRecuperada);

        pessoaRecuperada.setPet(petEntityRecuperado);

        return entityToPetDTO(petRepository.save(petEntityRecuperado));
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