package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.domain.Imovel;
import br.edu.uniopet.imobiliariagsonspring.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;

    //Get entity imovel to by id
    public Imovel find(Integer id) {
        Imovel obj = imovelRepository.findById(id).orElse(null);
        return obj;
    }
}
