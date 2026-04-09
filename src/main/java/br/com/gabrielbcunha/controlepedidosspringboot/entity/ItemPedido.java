package br.com.gabrielbcunha.controlepedidosspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="itens_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemPedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="pedido_id", nullable=false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="produto_id", nullable=false)
    private Produto produto;

    @Column(name="quantidade_produto", nullable=false)
    private int quantidade;

    @Column(name="valor_unitario", nullable=false, precision=10, scale=2)
    private BigDecimal valorUnitario;

    @Column(name="sub_total", nullable=false, precision=10, scale=2)
    private BigDecimal subTotal;
}
