package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.PedidoCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.PedidoResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.PedidoUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Pedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PedidoMapper {

    Pedido toEntity(PedidoCreateRequest pedidoRequest);

    Pedido toEntity(PedidoUpdateRequest pedidoRequest);

    PedidoResponse toDto(Pedido pedido);

    List<PedidoResponse> toDtoList(List<Pedido> pedidosDto);

}
