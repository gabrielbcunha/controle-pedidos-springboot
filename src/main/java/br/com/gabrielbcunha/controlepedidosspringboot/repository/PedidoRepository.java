package br.com.gabrielbcunha.controlepedidosspringboot.repository;

import br.com.gabrielbcunha.controlepedidosspringboot.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
