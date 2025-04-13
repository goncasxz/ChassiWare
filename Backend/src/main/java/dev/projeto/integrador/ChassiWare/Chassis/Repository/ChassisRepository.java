package dev.projeto.integrador.ChassiWare.Chassis.Repository;

import dev.projeto.integrador.ChassiWare.Chassis.Model.ChassisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChassisRepository extends JpaRepository<ChassisModel, Long> {
}
