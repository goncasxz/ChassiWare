package dev.projeto.integrador.ChassiWare.chassis.service;

import dev.projeto.integrador.ChassiWare.chassis.model.ChassisModel;
import dev.projeto.integrador.ChassiWare.chassis.repository.ChassisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChassisService {

    private ChassisRepository chassisRepository;

    public ChassisService(ChassisRepository chassisRepository) {
        this.chassisRepository = chassisRepository;
    }

    public List<ChassisModel> listarChassis() {
        return chassisRepository.findAll();
    }

    public Optional<ChassisModel> listarChassisId(String codigo) {
        return chassisRepository.findByCodigo(codigo);
    }

    public ChassisModel adicionarChassis(ChassisModel chassisModel) {
        return chassisRepository.save(chassisModel);
    }

    public void deletarChassi(Long id) {
        chassisRepository.deleteById(id);
    }
}
