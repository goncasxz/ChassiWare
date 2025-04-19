package dev.projeto.integrador.ChassiWare.usuarios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @GetMapping("/teste")
    public String teste() {
        return "Teste de rota";
    }

}
