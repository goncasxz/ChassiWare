package dev.projeto.integrador.ChassiWare.usuarios.service;

import dev.projeto.integrador.ChassiWare.usuarios.model.UsuarioModel;
import dev.projeto.integrador.ChassiWare.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private final HashingService hashingService;

    public UsuarioService(UsuarioRepository usuarioRepository, HashingService hashingService) {
        this.usuarioRepository = usuarioRepository;
        this.hashingService = hashingService;
    }

    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> listarUsuarioId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel adicionarUsuario(UsuarioModel usuario) {
        String senhaHash = hashingService.hashPassword(usuario.getSenha());
        usuario.setSenha(senhaHash);
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuarioId(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean autenticarUsuario(String email, String senha) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            return hashingService.checkPassword(senha, usuario.get().getSenha());
        }
        return false;
    }
}
