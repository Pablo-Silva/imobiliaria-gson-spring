package br.edu.uniopet.imobiliariagsonspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bairro;
    private String cep;
    private String latitude;
    private String longitude;
    private String endereco;
    private String numero;
    private String complemento;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @OneToMany(mappedBy = "localizacao")
    private List<Fato> fatos = new ArrayList<>();

}
