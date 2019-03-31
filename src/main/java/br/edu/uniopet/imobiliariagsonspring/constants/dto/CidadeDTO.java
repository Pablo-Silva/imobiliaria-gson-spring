package br.edu.uniopet.imobiliariagsonspring.constants.dto;

import br.edu.uniopet.imobiliariagsonspring.domain.Estado;

public class CidadeDTO {

    private Integer id;
    private String cidade;
    private Estado estado;

    public CidadeDTO() {
    }

    public CidadeDTO(Integer id, String cidade, Estado estado) {
        this.id = id;
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
}
