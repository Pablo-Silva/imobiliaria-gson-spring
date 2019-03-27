package br.edu.uniopet.imobiliariagsonspring;

import br.edu.uniopet.imobiliariagsonspring.domain.Cidade;
import br.edu.uniopet.imobiliariagsonspring.domain.Fato;
import br.edu.uniopet.imobiliariagsonspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariagsonspring.repository.CidadeRepository;
import br.edu.uniopet.imobiliariagsonspring.repository.FatoRepository;
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
    private CidadeRepository cidadeRepository;

    private FatoService fatoService = new FatoService();

    @Override
    public void run(String... args) throws Exception {

        List<Imobiliaria> imobiliarias = new ArrayList<>();
        imobiliarias = ImobiliariaUtil.convertGson();

        Fato fato = new Fato();
        Cidade cidade = new Cidade();

        System.out.println(imobiliarias);

        for (Imobiliaria i : imobiliarias){
            if (i.getCidade() != null){
                cidade.setCidade(i.getCidade());
                Cidade cidade1 = new Cidade();
                cidade1 = cidadeRepository.findByCidade(cidade.getCidade());
                if (cidade1 == null) {
                    cidadeRepository.save(cidade);
                }
            }
            if (i.getId() != null){
                fato.setIdJson(i.getId());
                Cidade cidade1 = new Cidade();
                cidade1 = cidadeRepository.findByCidade(cidade.getCidade());
                fato.setCidade(cidade1);
                fatoRepository.save(fato);
            }

            fato = new Fato();
            cidade = new Cidade();
        }
    }
}
