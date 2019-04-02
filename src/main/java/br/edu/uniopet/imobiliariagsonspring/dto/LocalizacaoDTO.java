package br.edu.uniopet.imobiliariagsonspring.dto;

public class LocalizacaoDTO {

    private Integer id;
    private String bairro;
    private String cep;
    private String latitude;
    private String longitude;
    private String endereco;
    private String numero;
    private String complemento;
    private CidadeDTO cidadeDTO;

    public LocalizacaoDTO() {
    }

    public LocalizacaoDTO(Integer id, String bairro, String cep, String latitude, String longitude, String endereco, String numero, String complemento, CidadeDTO cidadeDTO) {
        this.id = id;
        this.bairro = bairro;
        this.cep = cep;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.cidadeDTO = cidadeDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public CidadeDTO getCidadeDTO() {
        return cidadeDTO;
    }

    public void setCidadeDTO(CidadeDTO cidadeDTO) {
        this.cidadeDTO = cidadeDTO;
    }
}
