package dev.projeto.integrador.ChassiWare.chassis.service;

import dev.projeto.integrador.ChassiWare.chassis.model.ChassisModel;
import dev.projeto.integrador.ChassiWare.chassis.repository.ChassisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> movimentarEstoque(String codigoChassi, Integer quantidade, String tipoMovimentacao) {
        Optional<ChassisModel> optionalChassi = chassisRepository.findByCodigo(codigoChassi);

        if (optionalChassi.isPresent()) {
            ChassisModel chassi = optionalChassi.get();
            if (tipoMovimentacao.equals("entrada")) {
                chassi.setEstoque(chassi.getEstoque() + quantidade);
                return ResponseEntity.status(HttpStatus.OK).body("Estoque atualizado com sucesso");
            } else if (tipoMovimentacao.equals("saida")) {
                Integer estoqueAtual = chassi.getEstoque();
                if (estoqueAtual < quantidade) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estoque menor que quantia de saida");
                } else {
                    chassi.setEstoque(estoqueAtual - quantidade);
                    return ResponseEntity.status(HttpStatus.OK).body("Estoque atualizado com sucesso");
                }
            }
            chassisRepository.save(chassi);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chassi não encontrado");
        }
        return null;
    }

    public void deletarChassi(Long id) {
        chassisRepository.deleteById(id);
    }
}
