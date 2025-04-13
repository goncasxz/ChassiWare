package dev.projeto.integrador.ChassiWare.chassis.controller;

import dev.projeto.integrador.ChassiWare.chassis.model.ChassisModel;
import dev.projeto.integrador.ChassiWare.chassis.service.ChassisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chassis")
public class ChassisController {

    private ChassisService chassisService;

    public ChassisController(ChassisService chassisService) {
        this.chassisService = chassisService;
    }

    @GetMapping("/listar")
    public List<ChassisModel> listarChassis() {
        return chassisService.listarChassis();
    }

    @GetMapping("/listar/{codigo}")
    public Optional<ChassisModel> listarChassisId(@PathVariable String codigo){
        return chassisService.listarChassisId(codigo);
    }

    @PostMapping("/adicionar")
    public ChassisModel adicionarChassis(@RequestBody ChassisModel chassi) {
        return chassisService.adicionarChassis(chassi);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarChassis(@PathVariable Long id) {
        chassisService.deletarChassi(id);
    }
}
