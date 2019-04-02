package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.domain.Localizacao;
import br.edu.uniopet.imobiliariagsonspring.dto.LocalizacaoDTO;
import br.edu.uniopet.imobiliariagsonspring.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    //Get entity fato to by id
    public Localizacao find(Integer id) {
        Localizacao obj = localizacaoRepository.findById(id).orElse(null);
        return obj;

    }

}
