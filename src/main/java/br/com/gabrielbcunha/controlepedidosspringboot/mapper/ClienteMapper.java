package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.entity.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteCreateRequest clienteRequest);

    Cliente toEntity(ClienteUpdateRequest clienteRequest);

    ClienteResponse toDto(Cliente cliente);

    List<ClienteResponse> toDtoList(List<Cliente> clientesDto);

}
