package dev.projeto.integrador.ChassiWare.chassis.controller;

import dev.projeto.integrador.ChassiWare.chassis.dto.MovimentacaoRequest;
import dev.projeto.integrador.ChassiWare.chassis.model.ChassisModel;
import dev.projeto.integrador.ChassiWare.chassis.service.ChassisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chassis")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ChassisController {

    private ChassisService chassisService;
    private MovimentacaoRequest movimentacaoRequest;

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
        System.out.println("Chassi Recebido: " + chassi);
        return chassisService.adicionarChassis(chassi);
    }

    @PostMapping("/movimentacao")
    public ResponseEntity<?> movimentarEstoque(@RequestBody MovimentacaoRequest movimentacao) {
        ResponseEntity response = chassisService.movimentarEstoque(movimentacao.getCodigoChassi(), movimentacao.getQuantidade(), movimentacao.getTipoMovimentacao());
        return response;
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarChassis(@PathVariable Long id) {
        chassisService.deletarChassi(id);
    }
}
