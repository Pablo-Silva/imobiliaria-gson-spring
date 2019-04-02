package br.edu.uniopet.imobiliariagsonspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private String preco;
    @OneToMany(mappedBy = "imovel")
    private List<Fato> fatos = new ArrayList<>();

    public Imovel() {
    }

    public Imovel(String categoria, String status, String area_total, String area_privativa, String iptu, String condominio, String planta, String dependencia, String sacada, String portaria, String elevador, String churrasqueira, String suites, String vagas, String preco) {
        this.categoria = categoria;
        this.status = status;
        this.area_total = area_total;
        this.area_privativa = area_privativa;
        this.iptu = iptu;
        this.condominio = condominio;
        this.planta = planta;
        this.dependencia = dependencia;
        this.sacada = sacada;
        this.portaria = portaria;
        this.elevador = elevador;
        this.churrasqueira = churrasqueira;
        this.suites = suites;
        this.vagas = vagas;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea_total() {
        return area_total;
    }

    public void setArea_total(String area_total) {
        this.area_total = area_total;
    }

    public String getArea_privativa() {
        return area_privativa;
    }

    public void setArea_privativa(String area_privativa) {
        this.area_privativa = area_privativa;
    }

    public String getIptu() {
        return iptu;
    }

    public void setIptu(String iptu) {
        this.iptu = iptu;
    }

    public String getCondominio() {
        return condominio;
    }

    public void setCondominio(String condominio) {
        this.condominio = condominio;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getSacada() {
        return sacada;
    }

    public void setSacada(String sacada) {
        this.sacada = sacada;
    }

    public String getPortaria() {
        return portaria;
    }

    public void setPortaria(String portaria) {
        this.portaria = portaria;
    }

    public String getElevador() {
        return elevador;
    }

    public void setElevador(String elevador) {
        this.elevador = elevador;
    }

    public String getChurrasqueira() {
        return churrasqueira;
    }

    public void setChurrasqueira(String churrasqueira) {
        this.churrasqueira = churrasqueira;
    }

    public String getSuites() {
        return suites;
    }

    public void setSuites(String suites) {
        this.suites = suites;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
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
        Imovel imovel = (Imovel) o;
        return id.equals(imovel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", status='" + status + '\'' +
                ", area_total='" + area_total + '\'' +
                ", area_privativa='" + area_privativa + '\'' +
                ", iptu='" + iptu + '\'' +
                ", condominio='" + condominio + '\'' +
                ", planta='" + planta + '\'' +
                ", dependencia='" + dependencia + '\'' +
                ", sacada='" + sacada + '\'' +
                ", portaria='" + portaria + '\'' +
                ", elevador='" + elevador + '\'' +
                ", churrasqueira='" + churrasqueira + '\'' +
                ", suites='" + suites + '\'' +
                ", vagas='" + vagas + '\'' +
                ", preco='" + preco + '\'' +
                ", fatos=" + fatos +
                '}';
    }
}
