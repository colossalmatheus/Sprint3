package br.com.estoquefacil.repository;

import br.com.estoquefacil.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade,Long> {
    @Query("SELECT u FROM Unidade u WHERE u.condominio.id = :condominioId")
    List<Unidade> findByCondominioId(@Param("condominioId") Long condominioId);
    void deleteByCondominioId(Long id);
}
