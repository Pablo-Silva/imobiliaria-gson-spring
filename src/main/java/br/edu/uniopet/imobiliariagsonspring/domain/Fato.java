package br.edu.uniopet.imobiliariagsonspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Fato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idJson;
    @Column(columnDefinition = "TEXT")
    private String imagem;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
}
