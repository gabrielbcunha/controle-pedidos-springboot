package br.com.gabrielbcunha.controlepedidosspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy="pedido")
    private List<ItemPedido> itens;

    @Column(name="valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotalPedido;

    @Column(name="data_pedido", nullable = false)
    private LocalDate dataPedido;

    @Column(name="status_pedido", nullable = false)
    private String statusPedido;
}
