package br.edu.uniopet.imobiliariagsonspring.resource;

import br.edu.uniopet.imobiliariagsonspring.constants.dto.CidadeDTO;
import br.edu.uniopet.imobiliariagsonspring.constants.dto.EstadoDTO;
import br.edu.uniopet.imobiliariagsonspring.constants.dto.LocalizacaoDTO;
import br.edu.uniopet.imobiliariagsonspring.constants.dto.PaisDTO;
import br.edu.uniopet.imobiliariagsonspring.domain.*;
import br.edu.uniopet.imobiliariagsonspring.repository.*;
import br.edu.uniopet.imobiliariagsonspring.service.*;
import br.edu.uniopet.imobiliariagsonspring.util.ImobiliariaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/fatos")
public class FatoResource {

    @Autowired
    private FatoService fatoService;

    @Autowired
    private LocalizacaoService localizacaoService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private PaisService paisService;

    //Get Fato to by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fato> find(@PathVariable Integer id) {
        Fato obj = fatoService.find(id);
        Localizacao obj2 = localizacaoService.find(obj.getLocalizacao().getId());
        Cidade cidade = cidadeService.find(obj2.getCidade().getId());
        LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO();
        localizacaoDTO.setId(obj2.getId());
        localizacaoDTO.setBairro(obj2.getBairro());
        localizacaoDTO.setCep(obj2.getCep());
        localizacaoDTO.setComplemento(obj2.getComplemento());
        localizacaoDTO.setEndereco(obj2.getEndereco());
        localizacaoDTO.setLatitude(obj2.getLatitude());
        localizacaoDTO.setLongitude(obj2.getLongitude());
        localizacaoDTO.setNumero(obj2.getNumero());
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setCidade(cidade.getCidade());
        cidadeDTO.setEstado(cidade.getEstado());
        localizacaoDTO.setCidadeDTO(cidadeDTO);

        obj.setLocalizacaoDTO(localizacaoDTO);
        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Fato>> findAll() {
        List<Fato> list = fatoService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
