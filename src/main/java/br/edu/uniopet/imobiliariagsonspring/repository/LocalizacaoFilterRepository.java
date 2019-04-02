package br.edu.uniopet.imobiliariagsonspring.repository;

import br.edu.uniopet.imobiliariagsonspring.domain.Imovel;
import br.edu.uniopet.imobiliariagsonspring.domain.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoFilterRepository extends JpaRepository<Localizacao, String> {
}
