package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Long> {
}
