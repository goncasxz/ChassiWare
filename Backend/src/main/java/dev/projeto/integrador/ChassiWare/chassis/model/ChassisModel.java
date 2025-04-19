package dev.projeto.integrador.ChassiWare.chassis.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chassis")
@NoArgsConstructor
@AllArgsConstructor
public class ChassisModel {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo", unique = true)
    private String codigo;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "estoque")
    private Integer estoque;

    @Override
    public String toString() {
        return "ChassisModel{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ano=" + ano +
                ", fabricante='" + fabricante + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
