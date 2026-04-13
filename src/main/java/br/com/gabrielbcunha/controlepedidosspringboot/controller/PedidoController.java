package br.com.gabrielbcunha.controlepedidosspringboot.controller;

import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.PedidoCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.PedidoResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.PedidoUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> adicionarPedido(@Valid @RequestBody PedidoCreateRequest request) {
        PedidoResponse pedidoNovo = pedidoService.adicionarPedido(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoNovo);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        List<PedidoResponse> listarTodosPedidos = pedidoService.listarTodosPedidos();
        return ResponseEntity.ok(listarTodosPedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPedidoPorId(@PathVariable Long id) {
        PedidoResponse pedidoPorId = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedidoPorId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizarPedidoPorId(@PathVariable Long id, @Valid @RequestBody PedidoUpdateRequest request) {
        PedidoResponse pedidoModificado = pedidoService.modificarPedido(id, request);
        return ResponseEntity.ok(pedidoModificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoResponse> removerPedidoPorId(@PathVariable Long id) {
        pedidoService.removerPedido(id);
        return ResponseEntity.noContent().build();
    }

}
