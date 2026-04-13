package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import br.com.gabrielbcunha.controlepedidosspringboot.model.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PedidoResponse {
    private Long id;
    private Long idCliente;
    private List<ItemPedidoResponse> itens;
    private BigDecimal valorTotalPedido;
    private LocalDate dataPedido;
    private StatusPedido statusPedido;
}
