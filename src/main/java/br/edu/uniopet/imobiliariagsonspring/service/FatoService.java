package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.domain.Cidade;
import br.edu.uniopet.imobiliariagsonspring.domain.Fato;
import br.edu.uniopet.imobiliariagsonspring.repository.CidadeRepository;
import br.edu.uniopet.imobiliariagsonspring.repository.FatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FatoService {

    @Autowired
    private FatoRepository fatoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    /**
     * Insert into table Fato
     *
     * @param obj
     * @return
     */
    public Fato insertFato(Fato obj) {
        obj.setId(null);
        obj = fatoRepository.save(obj);
        return obj;
    }

    /**
     * Insert into table Cidade
     *
     * @param obj
     * @return
     */
    public Cidade insertCidade(Cidade obj) {
        obj.setId(null);
        obj = cidadeRepository.save(obj);
        return obj;
    }

    /**
     * Find a Cidade to by id
     * @param id
     * @return
     */
     public boolean findCidade(Integer id) {
        Cidade obj = new Cidade();
        Boolean existe = false;
        try {
            if (id != null && id > 0) {
                obj = cidadeRepository.findById(id).orElse(null);
                if (obj != null){
                    existe = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;

    }
}
