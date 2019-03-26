package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Imobiliaria{
    private Integer id;
    private String categoria;
    private String cidade;
    private String uf;
    private String bairro;
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
    private String dormitorios;
    private String suites;
    private String vagas;
    private String banheiros;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String descricao;
    private String latitude;
    private String longitude;
    private String valor_venda;
    private String mostrar_mapa;
    private String imagem_principal;
    private List<String> imagens = new ArrayList<>();

}
