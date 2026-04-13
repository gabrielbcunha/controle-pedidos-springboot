package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoUpdateRequest {

    private Long produtoId;

    @Positive(message="A quantidade de Itens deve ser maior do que zero")
    private Integer quantidade;

}
