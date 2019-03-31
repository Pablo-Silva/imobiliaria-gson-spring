package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.domain.Estado;
import br.edu.uniopet.imobiliariagsonspring.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    //Get entity fato to by id
    public Estado find(Integer id) {
        Estado obj = estadoRepository.findById(id).orElse(null);
        return obj;

    }
}
