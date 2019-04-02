package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String faixaEtaria;
    private String faixaRenda;
    private String genero;
    private String grauEscolaridade;
    @OneToMany(mappedBy = "cliente")
    private List<Fato> fatos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String faixaEtaria, String faixaRenda, String genero, String grauEscolaridade) {
        this.faixaEtaria = faixaEtaria;
        this.faixaRenda = faixaRenda;
        this.genero = genero;
        this.grauEscolaridade = grauEscolaridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getFaixaRenda() {
        return faixaRenda;
    }

    public void setFaixaRenda(String faixaRenda) {
        this.faixaRenda = faixaRenda;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public List<Fato> getFatos() {
        return fatos;
    }

    public void setFatos(List<Fato> fatos) {
        this.fatos = fatos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", faixaEtaria='" + faixaEtaria + '\'' +
                ", faixaRenda='" + faixaRenda + '\'' +
                ", genero='" + genero + '\'' +
                ", grauEscolaridade='" + grauEscolaridade + '\'' +
                ", fatos=" + fatos +
                '}';
    }
}
