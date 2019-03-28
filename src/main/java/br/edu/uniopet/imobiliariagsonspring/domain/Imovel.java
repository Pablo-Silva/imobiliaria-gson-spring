package br.edu.uniopet.imobiliariagsonspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoria;
    private String status;
    private String area_total;
    private String area_privativa;
    private String iptu;
    private String condominio;
    private String planta;
    private String dependencia;
    private String sacada;
    private String portaria;
    private String elevador;
    private String churrasqueira;
    private String suites;
    private String vagas;
    @OneToMany(mappedBy = "imovel")
    private List<Fato> fatos = new ArrayList<>();
}
