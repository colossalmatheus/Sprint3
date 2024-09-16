package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador,Long> {
}
