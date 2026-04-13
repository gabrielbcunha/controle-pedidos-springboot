package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ItemPedidoCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ItemPedidoResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ItemPedidoUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.ItemPedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ItemPedidoMapper {

    ItemPedido toEntity(ItemPedidoCreateRequest itemRequest);

    ItemPedido toEntity(ItemPedidoUpdateRequest itemRequest);

    ItemPedidoResponse toDto(ItemPedido itemPedido);

    List<ItemPedidoResponse> toDtoList(List<ItemPedido> itensPedidosDto);

}
