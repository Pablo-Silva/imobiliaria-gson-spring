package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.domain.Localizacao;
import br.edu.uniopet.imobiliariagsonspring.domain.Pais;
import br.edu.uniopet.imobiliariagsonspring.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    @Autowired
    PaisRepository paisRepository;

    //Get entity fato to by id
    public Pais find(Integer id) {
        Pais obj = paisRepository.findById(id).orElse(null);
        return obj;

    }
}
