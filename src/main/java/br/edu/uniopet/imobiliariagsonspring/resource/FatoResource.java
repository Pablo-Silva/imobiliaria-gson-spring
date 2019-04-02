package br.edu.uniopet.imobiliariagsonspring.resource;

import br.edu.uniopet.imobiliariagsonspring.dto.CidadeDTO;
import br.edu.uniopet.imobiliariagsonspring.dto.ImovelDTO;
import br.edu.uniopet.imobiliariagsonspring.dto.LocalizacaoDTO;
import br.edu.uniopet.imobiliariagsonspring.domain.*;
import br.edu.uniopet.imobiliariagsonspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    private ImovelService imovelService;

    //Get Fato to by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fato> find(@PathVariable Integer id) {
        Fato obj = fatoService.find(id);
        Localizacao localizacao = localizacaoService.find(obj.getLocalizacao().getId());
        Cidade cidade = cidadeService.find(localizacao.getCidade().getId());
        Imovel imovel = imovelService.find(obj.getImovel().getId());

        LocalizacaoDTO localizacaoDTO = getLocalizacaoDTO(localizacao);
        CidadeDTO cidadeDTO = getCidadeDTO(cidade);
        ImovelDTO imovelDTO = getImovelDTO(imovel);

        localizacaoDTO.setCidadeDTO(cidadeDTO);

        obj.setLocalizacaoDTO(localizacaoDTO);
        obj.setImovelDTO(imovelDTO);
        return ResponseEntity.ok().body(obj);

    }

    /**
     * Lista todos os Fatos
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Fato>> findAll() {
        List<Fato> list = fatoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Get LocalizacaoDTO by setting the Localizacao.
     * @param localizacao
     * @return
     */
    public static LocalizacaoDTO getLocalizacaoDTO(Localizacao localizacao){
        LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO();

        if (localizacao != null){
            localizacaoDTO.setId(localizacao.getId());
            localizacaoDTO.setBairro(localizacao.getBairro());
            localizacaoDTO.setCep(localizacao.getCep());
            localizacaoDTO.setComplemento(localizacao.getComplemento());
            localizacaoDTO.setEndereco(localizacao.getEndereco());
            localizacaoDTO.setLatitude(localizacao.getLatitude());
            localizacaoDTO.setLongitude(localizacao.getLongitude());
            localizacaoDTO.setNumero(localizacao.getNumero());
        }

        return  localizacaoDTO;
    }

    /**
     * Get CidadeDTO by setting the Cidade.
     * @param cidade
     * @return
     */
    public static CidadeDTO getCidadeDTO(Cidade cidade){
        CidadeDTO cidadeDTO = new CidadeDTO();

        if (cidade != null){
            cidadeDTO.setId(cidade.getId());
            cidadeDTO.setCidade(cidade.getCidade());
            cidadeDTO.setEstado(cidade.getEstado());
        }

        return cidadeDTO;
    }

    public static ImovelDTO getImovelDTO(Imovel imovel){
        ImovelDTO imovelDTO = new ImovelDTO();

        if (imovel != null){
            imovelDTO.setId(imovel.getId());
            imovelDTO.setCategoria(imovel.getCategoria());
            imovelDTO.setStatus(imovel.getStatus());
            imovelDTO.setArea_total(imovel.getArea_total());
            imovelDTO.setArea_privativa(imovel.getArea_privativa());
            imovelDTO.setIptu(imovel.getIptu());
            imovelDTO.setCondominio(imovel.getCondominio());
            imovelDTO.setPlanta(imovel.getPlanta());
            imovelDTO.setDependencia(imovel.getDependencia());
            imovelDTO.setSacada(imovel.getSacada());
            imovelDTO.setPortaria(imovel.getPortaria());
            imovelDTO.setElevador(imovel.getElevador());
            imovelDTO.setChurrasqueira(imovel.getChurrasqueira());
            imovelDTO.setSuites(imovel.getSuites());
            imovelDTO.setVagas(imovel.getVagas());
            imovelDTO.setPreco(imovel.getPreco());
        }

        return imovelDTO;
    }
}
