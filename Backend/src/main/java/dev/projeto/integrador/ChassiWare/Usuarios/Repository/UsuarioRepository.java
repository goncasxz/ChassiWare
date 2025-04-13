package dev.projeto.integrador.ChassiWare.Usuarios.Repository;

import dev.projeto.integrador.ChassiWare.Usuarios.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
