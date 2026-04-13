package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoUpdateRequest {

    @Valid
    private List<ItemPedidoUpdateRequest> itens;

}
