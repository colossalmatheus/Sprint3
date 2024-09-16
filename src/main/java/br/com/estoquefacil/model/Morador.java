package br.com.estoquefacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "morador")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_morador")
    private Long id;

    @Size(min = 4, max = 255, message = "O nome da nova pessoa deve ter, ao menos, 4 caracteres e, no máximo, 255")
    @NotEmpty(message = "O nome não pode estar vazio")
    @Column(name = "nome")
    private String nome;

    @CPF
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "contato")
    private String contato;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "unidade_morador",
            joinColumns = @JoinColumn(
                    name = "id_morador",
                    referencedColumnName = "id_morador",
                    foreignKey = @ForeignKey(name = "id_morador_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_unidade",  // Correção: Coluna da tabela unidade
                    referencedColumnName = "id_unidade",
                    foreignKey = @ForeignKey(name = "id_unidade_morador_fk")
            )
    )

    private Set<Unidade> unidade = new LinkedHashSet<>();

}
