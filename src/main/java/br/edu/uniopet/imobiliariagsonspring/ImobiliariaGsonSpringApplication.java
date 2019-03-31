package br.edu.uniopet.imobiliariagsonspring;

import br.edu.uniopet.imobiliariagsonspring.domain.*;
import br.edu.uniopet.imobiliariagsonspring.repository.*;
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
    private FatoService fatoService;

    @Override
    public void run(String... args) throws Exception {

        //Calls method to save tables
        fatoService.fatoJsonToEntity();
    }
}
