package com.wswork.test_java.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CARRO")
public class CarsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestampCadastro;

    @PrePersist
    public void prePersist() {
        this.timestampCadastro = LocalDateTime.now();
    }
    @Column(nullable = false)
    private Integer ano;
    private String combustivel;
    private Integer num_portas;
    private String cor;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloModel modelo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ModeloModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloModel modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getTimestampCadastro() {
        return timestampCadastro;
    }

    public void setTimestampCadastro(LocalDateTime timestampCadastro) {
        this.timestampCadastro = timestampCadastro;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(Integer num_portas) {
        this.num_portas = num_portas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
