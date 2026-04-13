package br.com.gabrielbcunha.controlepedidosspringboot.service;

import br.com.gabrielbcunha.controlepedidosspringboot.mapper.ItemPedidoMapper;
import br.com.gabrielbcunha.controlepedidosspringboot.mapper.PedidoMapper;
import br.com.gabrielbcunha.controlepedidosspringboot.mapper.ProdutoMapper;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.*;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Cliente;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.ItemPedido;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Pedido;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Produto;
import br.com.gabrielbcunha.controlepedidosspringboot.repository.ClienteRepository;
import br.com.gabrielbcunha.controlepedidosspringboot.repository.PedidoRepository;
import br.com.gabrielbcunha.controlepedidosspringboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final ItemPedidoMapper itemPedidoMapper;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoMapper produtoMapper, ItemPedidoMapper itemPedidoMapper, ProdutoRepository produtoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoMapper = produtoMapper;
        this.itemPedidoMapper = itemPedidoMapper;
        this.produtoRepository = produtoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    public PedidoResponse adicionarPedido(PedidoCreateRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("O cliente não existe"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedidos = new ArrayList<>();

        for (ItemPedidoCreateRequest itemPedidoDto : request.getItens()) {

            Produto produto = produtoRepository.findById(itemPedidoDto.getProdutoId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto com id: " + itemPedidoDto.getProdutoId() + " não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(itemPedidoDto.getQuantidade());
            item.setValorUnitario(produto.getPreco());
            item.setPedido(pedido);

            item.calcularSubTotal();
            itensPedidos.add(item);
        }

        pedido.setItens(itensPedidos);
        pedido.calcularValorTotalPedido();
        pedido =  pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoResponse> listarTodosPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidoMapper.toDtoList(pedidos);
    }

    public PedidoResponse buscarPedidoPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O id do Pedido deve existir e ser positivo");
        }

        return pedidoRepository.findById(id)
                .map(pedidoMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("O Pedido procurado não existe"));
    }

    public PedidoResponse modificarPedido(Long id, PedidoUpdateRequest request) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O Pedido não existe"));

        List<ItemPedido> itensPedidos = new ArrayList<>();

        for (ItemPedidoUpdateRequest itemPedidoDto: request.getItens()) {

            Produto produto = produtoRepository.findById(itemPedidoDto.getProdutoId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto com id: " + itemPedidoDto.getProdutoId() + " não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setQuantidade(itemPedidoDto.getQuantidade());
            item.setValorUnitario(produto.getPreco());
            item.setPedido(pedido);
            item.setProduto(produto);

            item.calcularSubTotal();
            itensPedidos.add(item);
        }

        pedido.setItens(itensPedidos);
        pedido.calcularValorTotalPedido();
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }

    public void removerPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O Pedido não existe"));
        pedidoRepository.delete(pedido);
    }

}
