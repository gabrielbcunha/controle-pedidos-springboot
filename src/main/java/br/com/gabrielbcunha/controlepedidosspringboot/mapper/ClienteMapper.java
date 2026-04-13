package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ClienteUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteCreateRequest clienteRequest);

    Cliente toEntity(ClienteUpdateRequest clienteRequest);

    ClienteResponse toDto(Cliente cliente);

    List<ClienteResponse> toDtoList(List<Cliente> clientesDto);

}
