package br.edu.uniopet.imobiliariagsonspring.repository;

import br.edu.uniopet.imobiliariagsonspring.domain.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {

    Imovel findByCategoriaAndStatus(String s, String s2);
}
