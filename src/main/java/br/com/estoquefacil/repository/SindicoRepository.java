package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Sindico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SindicoRepository extends JpaRepository<Sindico,Long> {
}
