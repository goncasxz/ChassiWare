package dev.projeto.integrador.ChassiWare.usuarios.repository;

import dev.projeto.integrador.ChassiWare.usuarios.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
