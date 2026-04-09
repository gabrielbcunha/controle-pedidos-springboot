package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toEntity(ClienteCreateRequest clienteRequest);

    ClienteResponse toDto(Cliente cliente);

}
