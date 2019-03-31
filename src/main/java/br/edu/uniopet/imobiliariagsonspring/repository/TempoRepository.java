package br.edu.uniopet.imobiliariagsonspring.repository;

import br.edu.uniopet.imobiliariagsonspring.domain.Tempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempoRepository extends JpaRepository<Tempo, Integer> {

}
