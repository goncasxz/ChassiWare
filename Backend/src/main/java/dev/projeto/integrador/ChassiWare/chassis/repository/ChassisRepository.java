package dev.projeto.integrador.ChassiWare.chassis.repository;

import dev.projeto.integrador.ChassiWare.chassis.model.ChassisModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChassisRepository extends JpaRepository<ChassisModel, Long> {
    Optional<ChassisModel> findByCodigo(String codigo);
}
