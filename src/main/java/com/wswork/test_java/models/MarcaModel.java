package com.wswork.test_java.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_MARCA")
public class MarcaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome_marca;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    private Set<ModeloModel> modelos = new HashSet<>();

    public String getNome_marca() {
      return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<ModeloModel> getModelos() {
        return modelos;
    }

    public void setModelos(Set<ModeloModel> modelos) {
        this.modelos = modelos;
    }
}
