package br.com.gabrielbcunha.controlepedidosspringboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoUpdateRequest {

    private String nome;

    private BigDecimal preco;

}