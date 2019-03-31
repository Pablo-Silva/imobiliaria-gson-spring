package br.edu.uniopet.imobiliariagsonspring.constants.dto;

public class PaisDTO {

    private Integer id;
    private String nome;

    public PaisDTO() {
    }

    public PaisDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
