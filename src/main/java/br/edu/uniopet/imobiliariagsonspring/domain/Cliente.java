package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String faixaEtaria;
    private String faixaRenda;
    private String genero;
    private String grauEscolaridade;
    @OneToMany(mappedBy = "cliente")
    private List<Fato> fatos = new ArrayList<>();

}
