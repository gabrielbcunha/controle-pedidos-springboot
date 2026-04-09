package br.com.gabrielbcunha.controlepedidosspringboot.dto;

import br.com.gabrielbcunha.controlepedidosspringboot.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {
    private Long id;
    private String nome;
    private String numeroContato;

}
