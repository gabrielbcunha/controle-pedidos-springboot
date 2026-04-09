package br.com.gabrielbcunha.controlepedidosspringboot.repository;

import br.com.gabrielbcunha.controlepedidosspringboot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
