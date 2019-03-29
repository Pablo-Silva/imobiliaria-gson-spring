package br.edu.uniopet.imobiliariagsonspring;

import br.edu.uniopet.imobiliariagsonspring.domain.*;
import br.edu.uniopet.imobiliariagsonspring.repository.*;
import br.edu.uniopet.imobiliariagsonspring.util.ImobiliariaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ImobiliariaGsonSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ImobiliariaGsonSpringApplication.class, args);
    }

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

    @Override
    public void run(String... args) throws Exception {

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
                Estado estado1 = new Estado();
                estado1 = estadoRepository.findByNome(estado.getNome());
                if (estado1 == null) {
                    estadoRepository.save(estado);
                }
            }

            if (i.getCidade() != null) {
                cidade.setCidade(i.getCidade());
                Cidade cidade1 = new Cidade();
                Estado estado1 = new Estado();
                cidade1 = cidadeRepository.findByCidade(cidade.getCidade());
                if (cidade1 == null) {
                    estado1 = estadoRepository.findByNome(estado.getNome());
                    cidade.setEstado(estado1);
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

                Localizacao localizacao1 = new Localizacao();
                localizacao1 = localizacaoRepository.findByLatitudeAndLongitude(localizacao.getLatitude(), localizacao.getLongitude());

                if (localizacao1 == null) {
                    Cidade cidade1 = new Cidade();
                    cidade1 = cidadeRepository.findByCidade(cidade.getCidade());
                    localizacao.setCidade(cidade1);
                    localizacaoRepository.save(localizacao);
                }
            }

            if (i.getCategoria() != null || i.getStatus() != null || i.getArea_total() != null || i.getArea_privativa() != null ||
                    i.getIptu() != null || i.getCondominio() != null || i.getPlanta() != null || i.getDependencia() != null ||
                    i.getSacada() != null || i.getPortaria() != null || i.getElevador() != null || i.getChurrasqueira() != null ||
                    i.getSuites() != null || i.getVagas() != null) {
                imovel.setCategoria(i.getCategoria());
                imovel.setStatus(i.getStatus());
                imovel.setArea_total(i.getArea_total());
                imovel.setArea_privativa(i.getArea_privativa());
                imovel.setIptu(i.getIptu());
                imovel.setCondominio(i.getCondominio());
                imovel.setPlanta(i.getPlanta());
                imovel.setDependencia(i.getDependencia());
                imovel.setSacada(i.getSacada());
                imovel.setPortaria(i.getPortaria());
                imovel.setElevador(i.getElevador());
                imovel.setChurrasqueira(i.getChurrasqueira());
                imovel.setSuites(i.getSuites());
                imovel.setVagas(i.getVagas());
                imovel.setPreco(i.getValor_venda());

                Imovel imovel1 = new Imovel();
                imovel1 = imovelRepository.findByCategoriaAndStatus(imovel.getCategoria(), imovel.getStatus());
                if (imovel1 == null) {
                    imovelRepository.save(imovel);
                }
            }

            if (i.getId() != null) {
                fato.setIdJson(i.getId());
                fato.setImagem(i.getImagem_principal());
                fato.setDescricao(i.getDescricao());
                fato.setMostrarMapa(i.getMostrar_mapa());
                Localizacao localizacao1 = new Localizacao();
                Imovel imovel1 = new Imovel();
                localizacao1 = localizacaoRepository.findByLatitudeAndLongitude(localizacao.getLatitude(), localizacao.getLongitude());
                imovel1 = imovelRepository.findByCategoriaAndStatus(imovel.getCategoria(), imovel.getStatus());
                fato.setLocalizacao(localizacao1);
                fato.setImovel(imovel1);
                fatoRepository.save(fato);
            }

            fato = new Fato();
            estado = new Estado();
            cidade = new Cidade();
            localizacao = new Localizacao();
            imovel = new Imovel();
        }
    }
}
