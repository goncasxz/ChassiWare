package dev.projeto.integrador.ChassiWare.Chassis.Controller;

import dev.projeto.integrador.ChassiWare.Chassis.Model.ChassisModel;
import dev.projeto.integrador.ChassiWare.Chassis.Service.ChassisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chassis")
public class ChassisController {

    private ChassisService chassisService;

    public ChassisController(ChassisService chassisService) {
        this.chassisService = chassisService;
    }

    @GetMapping
    public String teste() {
        return "Teste de rota chassis";
    }

    @GetMapping("/listar")
    public List<ChassisModel> listarChassis() {
        return chassisService.listarChassis();
    }
}
