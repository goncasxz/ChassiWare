package dev.projeto.integrador.ChassiWare.Usuarios.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.projeto.integrador.ChassiWare.Chassis.Model.ChassisModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String senha;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<ChassisModel> chassisList;
}
