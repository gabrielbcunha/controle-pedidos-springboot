package br.com.gabrielbcunha.controlepedidosspringboot.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="produtos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_produto",nullable = false, length = 150)
    private String nome;

    @Column(name="preco_produto", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

}
