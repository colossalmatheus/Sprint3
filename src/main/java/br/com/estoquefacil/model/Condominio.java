package br.com.estoquefacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "condominio")
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condominio")
    private Long id;

    @Size(min = 4, max = 255, message = "O nome do novo condominio deve ter 4 caracteres e, no máximo, 255")
    @Column(name = "nome")
    private String nome;

    @Size(min = 4, max = 255, message = "O endereco do novo condominio deve ter 4 caracteres e, no máximo, 255")
    @Column(name = "endereco")
    private String endereco;

    @Size(min = 14, max = 18, message = "O cnpj do novo condominio deve ter 14 caracteres")
    @Column(name = "cnpj")
    private String cnpj;


    @Size(min = 4, max = 255, message = "O financeiro do novo condominio deve ter 4 caracteres e, no máximo, 255")
    @Column(name = "financeiro")
    private String financeiro;


}
