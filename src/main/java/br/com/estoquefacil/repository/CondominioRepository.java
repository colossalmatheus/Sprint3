package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio,Long> {
}

