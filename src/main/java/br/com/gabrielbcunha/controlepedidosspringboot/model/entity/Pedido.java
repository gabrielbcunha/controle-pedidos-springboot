package br.com.gabrielbcunha.controlepedidosspringboot.model.entity;

import br.com.gabrielbcunha.controlepedidosspringboot.model.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ItemPedido> itens = new ArrayList<>();

    @Column(name="valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotalPedido;

    @Column(name="data_pedido", nullable = false)
    private LocalDate dataPedido;

    @Enumerated(EnumType.STRING)
    @Column(name="status_pedido", nullable = false)
    private StatusPedido statusPedido;

    @PrePersist
    public void definidoNaCriacao(){
        this.dataPedido = LocalDate.now();

        this.statusPedido = StatusPedido.PENDENTE;
    }

    public void calcularValorTotalPedido(){
        if (!this.itens.isEmpty()){
            this.valorTotalPedido = this.itens.stream()
                    .map(ItemPedido::getSubTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        } else {
            this.valorTotalPedido = BigDecimal.ZERO;
        }
    }
}
