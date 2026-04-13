package br.com.gabrielbcunha.controlepedidosspringboot.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoCreateRequest {

    @NotBlank(message="O nome do produto deve existir")
    private String nome;

    @NotNull(message="O preço do produto deve existir e ser positivo")
    @PositiveOrZero
    private BigDecimal preco;

}