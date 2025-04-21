package dev.projeto.integrador.ChassiWare.usuarios.controller;

import dev.projeto.integrador.ChassiWare.usuarios.model.UsuarioModel;
import dev.projeto.integrador.ChassiWare.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public List<UsuarioModel> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }


    @GetMapping("/listar/{id}")
    public Optional<UsuarioModel> listarUsuarioId(@PathVariable Long id) {
        return usuarioService.listarUsuarioId(id);
    }

    @PostMapping("/adicionar")
    public UsuarioModel adicionarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.adicionarUsuario(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioId(@PathVariable Long id) {
        usuarioService.deletarUsuarioId(id);
    }
}
