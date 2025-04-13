package dev.projeto.integrador.ChassiWare.Chassis.Model;

import dev.projeto.integrador.ChassiWare.Usuarios.Model.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChassisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo_chassi", unique = true, nullable = false)
    private String codigo;

    private String modelo;
    private String tipo;
    private Integer ano;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;
}
