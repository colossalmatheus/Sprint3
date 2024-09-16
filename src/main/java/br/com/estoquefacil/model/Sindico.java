package br.com.estoquefacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sindico")
public class Sindico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sindico")
    private Long id;

    @Size(min = 4, max = 255, message = "O nome da nova pessoa deve ter, ao menos, 4 caracteres e, no máximo, 255")
    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @CPF
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "contato")
    private String contato;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(
            name = "condominio",
            referencedColumnName = "id_condominio",
            foreignKey = @ForeignKey(
                    name= "sindico_condominio_FK"
            )
    )

    private Condominio condominio;

}
