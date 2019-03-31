package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
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

}
