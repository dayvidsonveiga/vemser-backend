package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entities.UsuarioEntity;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ObjectMapper objectMapper;

    private final PasswordEncoder passwordEncoder;


    public LoginDTO saveUsuario(LoginDTO loginDTO) {
        UsuarioEntity usuarioEntity = createToEntity(loginDTO);

        usuarioEntity.setSenha(passwordEncoder.encode(usuarioEntity.getPassword()));

        usuarioRepository.save(usuarioEntity);

        return loginDTO;
    }

    public UsuarioEntity createToEntity(LoginDTO loginDTO) {
        return objectMapper.convertValue(loginDTO, UsuarioEntity.class);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }




}
