package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoResponse {

    private Long id;

    private Long produtoId;

    private Integer quantidade;

    private BigDecimal valorUnitario;

    private BigDecimal subTotal;
}
