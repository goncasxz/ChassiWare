package dev.projeto.integrador.ChassiWare.usuarios.controller;

import dev.projeto.integrador.ChassiWare.usuarios.dto.LoginDTO;
import dev.projeto.integrador.ChassiWare.usuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginController {
    private UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        boolean autenticado = usuarioService.autenticarUsuario(loginDTO.getEmail(), loginDTO.getSenha());
        if (autenticado) {
            return ResponseEntity.ok(Map.of("mensagem", "Login bem sucedido"));
        } else {
            return ResponseEntity.status(401).body(Map.of("mensagem", "Credenciais inválidas"));
        }
    }
}
