package br.com.gabrielbcunha.controlepedidosspringboot.controller;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping()
    public ResponseEntity<ClienteResponse> adicionarCliente(@Valid @RequestBody ClienteCreateRequest request) {
        ClienteResponse clienteNovo = clienteService.adicionarCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        List<ClienteResponse> listaTodosClientes = clienteService.listarTodosClientes();
        return ResponseEntity.ok(listaTodosClientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarClientePorId(@PathVariable Long id) {
        ClienteResponse clientePorId = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(clientePorId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizarClientePorId(@PathVariable Long id, @RequestBody ClienteUpdateRequest request) {
        ClienteResponse clienteModificado = clienteService.modificarCliente(id, request);
        return ResponseEntity.ok(clienteModificado);
    }

}
