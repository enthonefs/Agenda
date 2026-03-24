package com.spring.javanauta.business;

import com.spring.javanauta.infrastructure.entitys.Usuario;
import com.spring.javanauta.infrastructure.exceptions.ConflictException;
import com.spring.javanauta.infrastructure.exceptions.ResourceNotFoundException;
import com.spring.javanauta.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvarUsuario(Usuario usuario){
        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return repository.save(usuario);

        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado." + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return repository.existsByEmail(email);
    }

    public void emailExiste(String email){
        try {
            boolean existe = verificaEmailExistente(email);
            if (existe){
                throw new ConflictException("Email já cadastrado." + email);
            }
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado." + e.getCause());
        }
    }

    public List<Usuario> buscarUsuarios(){
        return repository.findAll();
    }

    public Usuario buscarPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado. " + email));
    }


    public void atualizarUsuario(Long id, Usuario usuario){
        Usuario usuarioExistente = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuário não encontrado."));
        Usuario usuarioAtualizado = Usuario.builder()
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioExistente.getNome())
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioExistente.getEmail())
                .senha(passwordEncoder.encode(usuario.getSenha()) != null ? passwordEncoder.encode(usuario.getSenha())
                        : passwordEncoder.encode(usuarioExistente.getSenha()))
                .enderecos(usuario.getEnderecos() != null ? usuario.getEnderecos() : usuarioExistente.getEnderecos())
                .telefones(usuario.getTelefones() != null ? usuario.getTelefones() : usuarioExistente.getTelefones())
                .id(usuarioExistente.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

    }

    public void deletarUsuario(String email){
        repository.deleteByEmail(email);
    }


}
