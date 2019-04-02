package br.edu.uniopet.imobiliariagsonspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cidade;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    @JsonIgnore
    @OneToMany(mappedBy = "cidade")
    private List<Localizacao> localizacoes = new ArrayList<>();

    public Cidade() {
    }

    public Cidade(String cidade, Estado estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", cidade='" + cidade + '\'' +
                ", estado=" + estado +
                ", localizacoes=" + localizacoes +
                '}';
    }
}
