package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa,Long> {
}
