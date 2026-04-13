package br.com.gabrielbcunha.controlepedidosspringboot.controller;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ProdutoCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ProdutoResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ProdutoUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.service.ClienteService;
import br.com.gabrielbcunha.controlepedidosspringboot.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ClienteService clienteService;

    public ProdutoController(ProdutoService produtoService, ClienteService clienteService) {
        this.produtoService = produtoService;
        this.clienteService = clienteService;
    }

    @PostMapping()
    public ResponseEntity<ProdutoResponse> adicionarProduto(@Valid @RequestBody ProdutoCreateRequest request) {
        ProdutoResponse produtoNovo = produtoService.adicionarProduto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoNovo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarTodosProdutos(){
        List<ProdutoResponse> listarTodosProdutos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(listarTodosProdutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProdutoPorId(@PathVariable Long id){
        ProdutoResponse produtoPorId = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produtoPorId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProdutoPorId(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateRequest request) {
        ProdutoResponse produtoModificado = produtoService.modificarProduto(id, request);
        return ResponseEntity.ok(produtoModificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponse> removerProdutoPorId(@PathVariable Long id){
        clienteService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }

}
