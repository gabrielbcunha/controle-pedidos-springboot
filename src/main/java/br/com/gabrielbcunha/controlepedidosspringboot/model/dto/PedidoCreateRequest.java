package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoCreateRequest {

    @NotNull(message="O ID do cliente deve existir")
    private Long clienteId;

    @NotEmpty(message="Pelo menos um item deve existir")
    @Valid
    private List<ItemPedidoCreateRequest> itens;

}
