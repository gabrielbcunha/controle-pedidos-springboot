package br.com.gabrielbcunha.controlepedidosspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCreateRequest {

    @NotBlank(message="O nome do Cliente deve existir")
    private String nome;

    @NotBlank(message="O número de contato do Cliente deve existir")
    private String numeroContato;

}
