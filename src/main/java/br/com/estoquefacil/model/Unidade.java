package br.com.estoquefacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_unidade")
    private Long id;

    @Size(min = 1, max = 4, message = "O número do novo condominio deve ter 1 caractere e, no máximo, 4")
    @Column(name="numero")
    private String numero;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "id_condominio",
            referencedColumnName = "id_condominio",
            foreignKey = @ForeignKey(
                    name = "id_condominio_fk"
            )
    )
    private Condominio condominio;
}
