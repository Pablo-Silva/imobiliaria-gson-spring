package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.domain.Cidade;
import br.edu.uniopet.imobiliariagsonspring.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

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
     *
     * @param id
     * @return
     */
    public boolean findCidade(Integer id) {
        Cidade obj = new Cidade();
        Boolean existe = false;
        try {
            if (id != null && id > 0) {
                obj = cidadeRepository.findById(id).orElse(null);
                if (obj != null) {
                    existe = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;

    }

    //Get entity fato to by id
    public Cidade find(Integer id) {
        Cidade obj = cidadeRepository.findById(id).orElse(null);
        return obj;

    }
}
