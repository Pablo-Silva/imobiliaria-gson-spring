package br.edu.uniopet.imobiliariagsonspring;

import br.edu.uniopet.imobiliariagsonspring.domain.*;
import br.edu.uniopet.imobiliariagsonspring.repository.CidadeRepository;
import br.edu.uniopet.imobiliariagsonspring.repository.EstadoRepository;
import br.edu.uniopet.imobiliariagsonspring.repository.FatoRepository;
import br.edu.uniopet.imobiliariagsonspring.repository.LocalizacaoRepository;
import br.edu.uniopet.imobiliariagsonspring.service.FatoService;
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

    private FatoService fatoService = new FatoService();

    @Override
    public void run(String... args) throws Exception {

        List<Imobiliaria> imobiliarias = new ArrayList<>();
        imobiliarias = ImobiliariaUtil.convertGson();

        Fato fato = new Fato();
        Estado estado = new Estado();
        Cidade cidade = new Cidade();
        Localizacao localizacao = new Localizacao();

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

            if(i.getCep() != null || i.getBairro() != null || i.getComplemento() != null || i.getLatitude() != null ||
            i.getLongitude() != null || i.getEndereco() != null || i.getNumero() != null){
                localizacao.setCep(i.getCep());
                localizacao.setBairro(i.getBairro());
                localizacao.setComplemento(i.getComplemento());
                localizacao.setLatitude(i.getLatitude());
                localizacao.setLongitude(i.getLongitude());
                localizacao.setEndereco(i.getEndereco());
                localizacao.setNumero(i.getNumero());

                Localizacao localizacao1 = new Localizacao();
                localizacao1 = localizacaoRepository.findByLatitudeAndLongitude(localizacao.getLatitude(),localizacao.getLongitude());

                if (localizacao1 == null) {
                    Cidade cidade1 = new Cidade();
                    cidade1 = cidadeRepository.findByCidade(cidade.getCidade());
                    localizacao.setCidade(cidade1);
                    localizacaoRepository.save(localizacao);
                }
            }

            if (i.getId() != null) {
                fato.setIdJson(i.getId());
                Localizacao localizacao1 = new Localizacao();
                localizacao1 = localizacaoRepository.findByLatitudeAndLongitude(localizacao.getLatitude(),localizacao.getLongitude());
                fato.setLocalizacao(localizacao1);
                fatoRepository.save(fato);
            }

            fato = new Fato();
            estado = new Estado();
            cidade = new Cidade();
            localizacao = new Localizacao();
        }
    }
}
