package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteCreateRequest clienteRequest);

    ClienteResponse toDto(Cliente cliente);

}
