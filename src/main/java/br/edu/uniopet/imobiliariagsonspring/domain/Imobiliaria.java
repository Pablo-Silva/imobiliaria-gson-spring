package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Imobiliaria() {
    }

    public Imobiliaria(Integer id, String categoria, String cidade, String uf, String bairro, String status, String area_total, String area_privativa, String iptu, String condominio, String planta, String dependencia, String sacada, String portaria, String elevador, String churrasqueira, String dormitorios, String suites, String vagas, String banheiros, String cep, String endereco, String numero, String complemento, String descricao, String latitude, String longitude, String valor_venda, String mostrar_mapa, String imagem_principal) {
        this.id = id;
        this.categoria = categoria;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
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
        this.dormitorios = dormitorios;
        this.suites = suites;
        this.vagas = vagas;
        this.banheiros = banheiros;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.valor_venda = valor_venda;
        this.mostrar_mapa = mostrar_mapa;
        this.imagem_principal = imagem_principal;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(String dormitorios) {
        this.dormitorios = dormitorios;
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

    public String getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(String banheiros) {
        this.banheiros = banheiros;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(String valor_venda) {
        this.valor_venda = valor_venda;
    }

    public String getMostrar_mapa() {
        return mostrar_mapa;
    }

    public void setMostrar_mapa(String mostrar_mapa) {
        this.mostrar_mapa = mostrar_mapa;
    }

    public String getImagem_principal() {
        return imagem_principal;
    }

    public void setImagem_principal(String imagem_principal) {
        this.imagem_principal = imagem_principal;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imobiliaria that = (Imobiliaria) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Imobiliaria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", bairro='" + bairro + '\'' +
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
                ", dormitorios='" + dormitorios + '\'' +
                ", suites='" + suites + '\'' +
                ", vagas='" + vagas + '\'' +
                ", banheiros='" + banheiros + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", valor_venda='" + valor_venda + '\'' +
                ", mostrar_mapa='" + mostrar_mapa + '\'' +
                ", imagem_principal='" + imagem_principal + '\'' +
                ", imagens=" + imagens +
                '}';
    }
}
