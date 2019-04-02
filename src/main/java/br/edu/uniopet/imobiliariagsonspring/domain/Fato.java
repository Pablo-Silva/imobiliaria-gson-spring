package br.edu.uniopet.imobiliariagsonspring.domain;

import br.edu.uniopet.imobiliariagsonspring.dto.ImovelDTO;
import br.edu.uniopet.imobiliariagsonspring.dto.LocalizacaoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Fato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idJson;
    @Column(columnDefinition = "TEXT")
    private String imagem;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private String mostrarMapa;
    private Integer quantidade;
    private String precoMedio;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tempo_id")
    private Tempo tempo;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Transient
    private LocalizacaoDTO localizacaoDTO;
    @Transient
    private ImovelDTO imovelDTO;

    public Fato() {
    }

    public Fato(Integer idJson, String imagem, String descricao, String mostrarMapa, Integer quantidade, String precoMedio, Localizacao localizacao, Imovel imovel, Tempo tempo, Cliente cliente) {
        this.idJson = idJson;
        this.imagem = imagem;
        this.descricao = descricao;
        this.mostrarMapa = mostrarMapa;
        this.quantidade = quantidade;
        this.precoMedio = precoMedio;
        this.localizacao = localizacao;
        this.imovel = imovel;
        this.tempo = tempo;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdJson() {
        return idJson;
    }

    public void setIdJson(Integer idJson) {
        this.idJson = idJson;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMostrarMapa() {
        return mostrarMapa;
    }

    public void setMostrarMapa(String mostrarMapa) {
        this.mostrarMapa = mostrarMapa;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(String precoMedio) {
        this.precoMedio = precoMedio;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalizacaoDTO getLocalizacaoDTO() {
        return localizacaoDTO;
    }

    public void setLocalizacaoDTO(LocalizacaoDTO localizacaoDTO) {
        this.localizacaoDTO = localizacaoDTO;
    }

    public ImovelDTO getImovelDTO() {
        return imovelDTO;
    }

    public void setImovelDTO(ImovelDTO imovelDTO) {
        this.imovelDTO = imovelDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fato fato = (Fato) o;
        return id.equals(fato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Fato{" +
                "id=" + id +
                ", idJson=" + idJson +
                ", imagem='" + imagem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", mostrarMapa='" + mostrarMapa + '\'' +
                ", quantidade=" + quantidade +
                ", precoMedio='" + precoMedio + '\'' +
                ", localizacao=" + localizacao +
                ", imovel=" + imovel +
                ", tempo=" + tempo +
                ", cliente=" + cliente +
                '}';
    }
}
