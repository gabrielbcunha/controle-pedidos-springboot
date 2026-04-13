package br.com.gabrielbcunha.controlepedidosspringboot.mapper;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ProdutoCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ProdutoResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ProdutoUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.entity.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoCreateRequest produtoRequest);

    Produto toEntity(ProdutoUpdateRequest produtoRequest);

    ProdutoResponse toDto(Produto produto);

    List<ProdutoResponse> toDtoList(List<Produto> produtosDto);

}
