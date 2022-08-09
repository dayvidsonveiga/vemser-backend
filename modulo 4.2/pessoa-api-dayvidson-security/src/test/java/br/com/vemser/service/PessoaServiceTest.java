package br.com.vemser.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.PessoaService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks // Injetar a classe na qual é o foco do caso de uso...
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void init() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(Se)
        ReflectionTestUtils.setField(pessoaService, "objectMapper", objectMapper);
    }

    @Test
    public void deveTestarCreateComSucesso() {
        // setup preparamos o que vamos usar no teste
        PessoaCreateDTO pessoaCreateDTO = new PessoaCreateDTO();
        pessoaCreateDTO.setDataNascimento(LocalDate.of(1996,9,8));
        pessoaCreateDTO.setCpf("15644444444");
        pessoaCreateDTO.setEmail("dayvidosn@gmail.com");
        pessoaCreateDTO.setNome("Dayvidson");

        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setDataNascimento(LocalDate.of(1996,9,8));
        pessoaEntity.setCpf("15644444444");
        pessoaEntity.setEmail("dayvidosn@gmail.com");
        pessoaEntity.setNome("Dayvidson");

        pessoaEntity.setIdPessoa(10);
        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaEntity);

        // act ação do teste
        PessoaDTO pessoaDTO = pessoaService.create(pessoaCreateDTO);

        // assert garantir o retorno do teste


    }
}
