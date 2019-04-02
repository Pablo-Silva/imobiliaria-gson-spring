package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Tempo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ano;
    private String semana;
    private Boolean isFeriado;
    private String semanaMes;
    private String mes;
    @OneToMany(mappedBy = "tempo")
    private List<Fato> fatos = new ArrayList<>();

    public Tempo() {
    }

    public Tempo(String ano, String semana, Boolean isFeriado, String semanaMes, String mes) {
        this.ano = ano;
        this.semana = semana;
        this.isFeriado = isFeriado;
        this.semanaMes = semanaMes;
        this.mes = mes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public Boolean getFeriado() {
        return isFeriado;
    }

    public void setFeriado(Boolean feriado) {
        isFeriado = feriado;
    }

    public String getSemanaMes() {
        return semanaMes;
    }

    public void setSemanaMes(String semanaMes) {
        this.semanaMes = semanaMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
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
        Tempo tempo = (Tempo) o;
        return id.equals(tempo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tempo{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                ", semana='" + semana + '\'' +
                ", isFeriado=" + isFeriado +
                ", semanaMes='" + semanaMes + '\'' +
                ", mes='" + mes + '\'' +
                ", fatos=" + fatos +
                '}';
    }
}
