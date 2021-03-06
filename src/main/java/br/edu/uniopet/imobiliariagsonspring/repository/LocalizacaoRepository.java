package br.edu.uniopet.imobiliariagsonspring.repository;

import br.edu.uniopet.imobiliariagsonspring.domain.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

    Localizacao findByLatitudeAndLongitude(String s, String s2);

    Localizacao findLocalizacaoByLatitudeContainsAndLongitudeContains(String s, String s2);
}
