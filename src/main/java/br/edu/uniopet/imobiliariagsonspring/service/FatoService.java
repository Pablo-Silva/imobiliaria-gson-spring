package br.edu.uniopet.imobiliariagsonspring.service;

import br.edu.uniopet.imobiliariagsonspring.constants.ConstantsImobiliaria;
import br.edu.uniopet.imobiliariagsonspring.domain.*;
import br.edu.uniopet.imobiliariagsonspring.repository.*;
import br.edu.uniopet.imobiliariagsonspring.util.ImobiliariaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FatoService {

    @Autowired
    private FatoRepository fatoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    //Get entity fato to by id
    public Fato find(Integer id) {
        Fato obj = fatoRepository.findById(id).orElse(null);
        return obj;

    }

    /**
     * Lista todos os fatos
     *
     * @return
     */
    public List<Fato> findAll() {
        return fatoRepository.findAll();
    }

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
     * Method  transforming JSON to Entity.
     */
    public void fatoJsonToEntity() {
        List<Imobiliaria> imobiliarias = new ArrayList<>();
        imobiliarias = ImobiliariaUtil.convertGson();

        Fato fato = new Fato();
        Estado estado = new Estado();
        Cidade cidade = new Cidade();
        Localizacao localizacao = new Localizacao();
        Imovel imovel = new Imovel();

        System.out.println(imobiliarias);

        for (Imobiliaria i : imobiliarias) {

            if (i.getUf() != null) {
                estado.setNome(i.getUf());
                Estado estadoAux = new Estado();
                estadoAux = estadoRepository.findByNome(estado.getNome());
                if (estadoAux == null) {
                    estadoRepository.save(estado);
                }
            }

            if (i.getCidade() != null) {
                cidade.setCidade(i.getCidade());
                Cidade cidadeAux = new Cidade();
                Estado estadoAux = new Estado();
                cidadeAux = cidadeRepository.findByCidade(cidade.getCidade());
                if (cidadeAux == null) {
                    estadoAux = estadoRepository.findByNome(estado.getNome());
                    if (estadoAux != null) {
                        cidade.setEstado(estadoAux);
                    }
                    cidadeRepository.save(cidade);
                }
            }

            if (i.getCep() != null || i.getBairro() != null || i.getComplemento() != null || i.getLatitude() != null ||
                    i.getLongitude() != null || i.getEndereco() != null || i.getNumero() != null) {
                localizacao.setCep(i.getCep());
                localizacao.setBairro(i.getBairro());
                localizacao.setComplemento(i.getComplemento());
                localizacao.setLatitude(i.getLatitude());
                localizacao.setLongitude(i.getLongitude());
                localizacao.setEndereco(i.getEndereco());
                localizacao.setNumero(i.getNumero());

                Localizacao localizacaoAux = new Localizacao();
                localizacaoAux = localizacaoRepository.findByLatitudeAndLongitude(localizacao.getLatitude(), localizacao.getLongitude());

                if (localizacaoAux == null) {
                    Cidade cidadeAux = new Cidade();
                    cidadeAux = cidadeRepository.findByCidade(cidade.getCidade());
                    if (cidadeAux != null) {
                        localizacao.setCidade(cidadeAux);
                    }
                    localizacaoRepository.save(localizacao);
                }
            }

            if (i.getCategoria() != null || i.getStatus() != null || i.getArea_total() != null || i.getArea_privativa() != null ||
                    i.getIptu() != null || i.getCondominio() != null || i.getPlanta() != null || i.getDependencia() != null ||
                    i.getSacada() != null || i.getPortaria() != null || i.getElevador() != null || i.getChurrasqueira() != null ||
                    i.getSuites() != null || i.getVagas() != null) {
                imovel.setCategoria(i.getCategoria());
                imovel.setStatus(i.getStatus());
                //Get faixa area total
                imovel.setArea_total(faixaAreaTotal(i.getArea_total()));
                //Get faixa area prvativa
                imovel.setArea_privativa(faixaAreaPrivativa(i.getArea_privativa()));
                //Get faixa IPTU
                imovel.setIptu(faixaIPTU(i.getIptu()));
                //Get faixa condominio
                imovel.setCondominio(faixaCondominio(i.getCondominio()));
                imovel.setPlanta(i.getPlanta());
                imovel.setDependencia(i.getDependencia());
                imovel.setSacada(i.getSacada());
                imovel.setPortaria(i.getPortaria());
                imovel.setElevador(i.getElevador());
                imovel.setChurrasqueira(i.getChurrasqueira());
                imovel.setSuites(i.getSuites());
                imovel.setVagas(i.getVagas());
                imovel.setPreco(i.getValor_venda());

                Imovel imovelAux = new Imovel();
                imovelAux = imovelRepository.findByCategoriaAndStatus(imovel.getCategoria(), imovel.getStatus());
                if (imovelAux == null) {
                    imovelRepository.save(imovel);
                }
            }

            if (i.getId() != null) {
                fato.setIdJson(i.getId());
                fato.setImagem(i.getImagem_principal());
                fato.setDescricao(i.getDescricao());
                fato.setMostrarMapa(i.getMostrar_mapa());
                fato.setPrecoMedio(precoMedio(i.getValor_venda()));
                Localizacao localizacaoAux = new Localizacao();
                Imovel imovelAux = new Imovel();
                localizacaoAux = localizacaoRepository.findByLatitudeAndLongitude(localizacao.getLatitude(), localizacao.getLongitude());
                imovelAux = imovelRepository.findByCategoriaAndStatus(imovel.getCategoria(), imovel.getStatus());
                if (localizacaoAux != null) {
                    fato.setLocalizacao(localizacaoAux);
                }
                if (imovelAux != null) {
                    fato.setImovel(imovelAux);
                }
                fatoRepository.save(fato);
            }

            fato = new Fato();
            estado = new Estado();
            cidade = new Cidade();
            localizacao = new Localizacao();
            imovel = new Imovel();
        }
    }

    //Defines the range of the total area
    public static String faixaAreaTotal(String areaTotal) {
        String faixa = null;

        if (areaTotal != null && areaTotal.length() > 0) {
            areaTotal = areaTotal.replace(",", ".");
            double areaTotalDouble = Double.parseDouble(areaTotal);
            if (areaTotalDouble > 0) {
                if (areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_1) {
                    faixa = ConstantsImobiliaria.FAIXA_AREA_TOTAL_1;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_1 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_2) {
                    faixa = ConstantsImobiliaria.FAIXA_AREA_TOTAL_2;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_2 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_3) {
                    faixa = ConstantsImobiliaria.FAIXA_AREA_TOTAL_3;
                } else {
                    faixa = ConstantsImobiliaria.FAIXA_INDEFINIDA;
                }
            }
        } else {
            faixa = ConstantsImobiliaria.FAIXA_INDEFINIDA;
        }

        return faixa;
    }

    //Defines the range of the privative area
    public static String faixaAreaPrivativa(String areaPrivativa) {
        String faixa = null;

        if (areaPrivativa != null && areaPrivativa.length() > 0) {
            areaPrivativa = areaPrivativa.replace(",", ".");
            double areaTotalDouble = Double.parseDouble(areaPrivativa);
            if (areaTotalDouble > 0) {
                if (areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_1) {
                    faixa = ConstantsImobiliaria.FAIXA_AREA_PRIVATIVA_1;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_1 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_2) {
                    faixa = ConstantsImobiliaria.FAIXA_AREA_PRIVATIVA_2;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_2 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_3) {
                    faixa = ConstantsImobiliaria.FAIXA_AREA_PRIVATIVA_3;
                } else {
                    faixa = ConstantsImobiliaria.FAIXA_INDEFINIDA;
                }
            }
        } else {
            faixa = ConstantsImobiliaria.FAIXA_INDEFINIDA;
        }

        return faixa;
    }

    //Defines the range of the IPTU
    public static String faixaIPTU(String iPTU) {
        String faixa = null;

        if (iPTU != null && iPTU.length() > 0) {
            iPTU = iPTU.replace(",", ".");
            double areaTotalDouble = Double.parseDouble(iPTU);
            if (areaTotalDouble > 0) {
                if (areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_1) {
                    faixa = ConstantsImobiliaria.FAIXA_IPTU_1;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_1 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_2) {
                    faixa = ConstantsImobiliaria.FAIXA_IPTU_2;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_2 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_3) {
                    faixa = ConstantsImobiliaria.FAIXA_IPTU_3;
                } else {
                    faixa = ConstantsImobiliaria.FAIXA_IPTU_INDEFINIDA;
                }
            }
        } else {
            faixa = ConstantsImobiliaria.FAIXA_IPTU_INDEFINIDA;
        }

        return faixa;
    }

    //Defines the range of the condominio
    public static String faixaCondominio(String condominio) {
        String faixa = null;

        if (condominio != null && condominio.length() > 0) {
            condominio = condominio.replace(",", ".");
            double areaTotalDouble = Double.parseDouble(condominio);
            if (areaTotalDouble > 0) {
                if (areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_1) {
                    faixa = ConstantsImobiliaria.FAIXA_CONDOMINIO_1;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_1 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_2) {
                    faixa = ConstantsImobiliaria.FAIXA_CONDOMINIO_2;
                } else if (areaTotalDouble >= ConstantsImobiliaria.AREA_MEDIDA_2 &&
                        areaTotalDouble <= ConstantsImobiliaria.AREA_MEDIDA_3) {
                    faixa = ConstantsImobiliaria.FAIXA_CONDOMINIO_3;
                } else {
                    faixa = ConstantsImobiliaria.FAIXA_CONDOMINIO_INDEFINIDA;
                }
            }
        } else {
            faixa = ConstantsImobiliaria.FAIXA_CONDOMINIO_INDEFINIDA;
        }

        return faixa;
    }

    public static String precoMedio(String precoMedio) {
        String precoFaixa = null;

        if (precoMedio != null && precoMedio.length() > 0) {
            if (precoMedio.contains(",")) {
                precoMedio = precoMedio.replace(",", ".");
                double preco = Double.parseDouble(precoMedio);

                if (preco <= ConstantsImobiliaria.PRECO_MEDIO_1) {
                    precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_1;
                } else if (preco >= ConstantsImobiliaria.PRECO_MEDIO_1 && preco <= ConstantsImobiliaria.PRECO_MEDIO_2) {
                    precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_2;
                } else if (preco >= ConstantsImobiliaria.PRECO_MEDIO_2 && preco <= ConstantsImobiliaria.PRECO_MEDIO_3) {
                    precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_3;
                } else if (preco >= ConstantsImobiliaria.PRECO_MEDIO_3 && preco <= ConstantsImobiliaria.PRECO_MEDIO_4) {
                    precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_4;
                } else if (preco >= ConstantsImobiliaria.PRECO_MEDIO_4 && preco <= ConstantsImobiliaria.PRECO_MEDIO_5) {
                    precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_5;
                } else {
                    precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_INDEFINIDA;
                }

            }
        } else {
            precoFaixa = ConstantsImobiliaria.FAIXA_PRECO_MEDIO_INDEFINIDA;
        }

        return precoFaixa;
    }
}
