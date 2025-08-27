package com.wswork.test_java.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_MODELO")
public class ModeloModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valor_fipe;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY)
    private Set<CarsModel> carros = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaModel marca;

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }

    public Set<CarsModel> getCarros() {
        return carros;
    }

    public void setCarros(Set<CarsModel> carros) {
        this.carros = carros;
    }

    public BigDecimal getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(BigDecimal valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}