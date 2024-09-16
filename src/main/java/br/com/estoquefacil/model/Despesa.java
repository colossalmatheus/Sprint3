package br.com.estoquefacil.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_despesa")
    private Long id;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "condominio",
            referencedColumnName = "id_condominio",
            foreignKey = @ForeignKey(
                    name = "despesa_condominio_fk"
            )
    )

    private Condominio condominio;

}
