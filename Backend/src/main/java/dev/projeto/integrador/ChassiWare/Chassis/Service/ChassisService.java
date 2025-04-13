package dev.projeto.integrador.ChassiWare.Chassis.Service;

import dev.projeto.integrador.ChassiWare.Chassis.Model.ChassisModel;
import dev.projeto.integrador.ChassiWare.Chassis.Repository.ChassisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChassisService {

    private ChassisRepository chassisRepository;

    public ChassisService(ChassisRepository chassisRepository) {
        this.chassisRepository = chassisRepository;
    }


    //TODO: Listar todos os chassis - Apenas teste macacos
    public List<ChassisModel> listarChassis() {
        return chassisRepository.findAll();
    }
}
