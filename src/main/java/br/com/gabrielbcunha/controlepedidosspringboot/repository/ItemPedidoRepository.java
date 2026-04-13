package br.com.gabrielbcunha.controlepedidosspringboot.repository;

import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
