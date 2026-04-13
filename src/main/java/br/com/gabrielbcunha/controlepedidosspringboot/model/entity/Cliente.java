package br.com.gabrielbcunha.controlepedidosspringboot.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_cliente", nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 20)
    private String numeroContato;

    @OneToMany(mappedBy="cliente")
    private List<Pedido> pedidos;
}
