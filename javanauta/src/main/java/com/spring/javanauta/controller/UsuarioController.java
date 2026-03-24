package com.spring.javanauta.controller;

import com.spring.javanauta.business.UsuarioService;
import com.spring.javanauta.controller.dtos.UsuarioDto;
import com.spring.javanauta.infrastructure.entitys.Usuario;
import com.spring.javanauta.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.salvarUsuario(usuario));
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDto usuarioDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(), usuarioDto.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return ResponseEntity.ok(service.buscarUsuarios());
    }

    @GetMapping(params = "email")
    public ResponseEntity<Usuario> buscarPorEmail(@RequestParam String email){
        return ResponseEntity.ok().body(service.buscarPorEmail(email));
    }

    @PutMapping(params = "id")
    public ResponseEntity<Void> atualizarUsuario(@RequestParam Long id, @RequestBody Usuario usuario){
        service.atualizarUsuario(id, usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String email){
        service.deletarUsuario(email);
        return ResponseEntity.ok().build();
    }


}
