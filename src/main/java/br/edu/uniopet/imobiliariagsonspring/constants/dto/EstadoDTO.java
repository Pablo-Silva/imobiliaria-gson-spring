package br.edu.uniopet.imobiliariagsonspring.constants.dto;

public class EstadoDTO {

    private Integer id;
    private String nome;
    private String regiao;

    public EstadoDTO() {
    }

    public EstadoDTO(Integer id, String nome, String regiao) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
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

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}
