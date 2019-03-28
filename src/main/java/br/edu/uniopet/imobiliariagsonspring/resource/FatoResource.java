package br.edu.uniopet.imobiliariagsonspring.resource;

import br.edu.uniopet.imobiliariagsonspring.domain.Fato;
import br.edu.uniopet.imobiliariagsonspring.service.FatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fatos")
public class FatoResource {

    @Autowired
    private FatoService fatoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fato> find(@PathVariable Integer id) {
        Fato obj = fatoService.find(id);
        return ResponseEntity.ok().body(obj);

    }
}
