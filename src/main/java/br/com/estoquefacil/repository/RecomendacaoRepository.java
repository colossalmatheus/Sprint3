package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacaoRepository extends JpaRepository<Recomendacao,Long> {
}
