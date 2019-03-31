package br.edu.uniopet.imobiliariagsonspring.repository;

import br.edu.uniopet.imobiliariagsonspring.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
