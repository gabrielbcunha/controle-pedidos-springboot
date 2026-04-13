package br.com.gabrielbcunha.controlepedidosspringboot.repository;

import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
