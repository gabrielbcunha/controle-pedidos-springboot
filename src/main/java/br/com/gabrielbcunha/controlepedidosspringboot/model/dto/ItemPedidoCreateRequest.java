package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoCreateRequest {

    @NotNull(message="O ID do produto deve existir")
    private Long produtoId;

    @NotNull(message="A quantidade do produto deve existir")
    @Positive(message="A quantidade deve ser maior do que zero")
    private Integer quantidade;

}
