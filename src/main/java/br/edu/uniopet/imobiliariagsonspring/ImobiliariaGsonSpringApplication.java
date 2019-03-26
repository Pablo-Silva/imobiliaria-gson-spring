package br.edu.uniopet.imobiliariagsonspring;

import br.edu.uniopet.imobiliariagsonspring.domain.Imobiliaria;
import br.edu.uniopet.imobiliariagsonspring.util.ImobiliariaUtil;
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

    @Override
    public void run(String... args) throws Exception {

        List<Imobiliaria> imobiliarias = new ArrayList<>();
        imobiliarias = ImobiliariaUtil.convertGson();

        System.out.println(imobiliarias);
    }
}
