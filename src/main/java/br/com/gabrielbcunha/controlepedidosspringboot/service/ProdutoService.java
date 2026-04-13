package br.com.gabrielbcunha.controlepedidosspringboot.service;

import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ProdutoCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ProdutoResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ProdutoUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Produto;
import br.com.gabrielbcunha.controlepedidosspringboot.mapper.ProdutoMapper;
import br.com.gabrielbcunha.controlepedidosspringboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoResponse adicionarProduto (ProdutoCreateRequest request){
        Produto produtoCriado = produtoMapper.toEntity(request);
        Produto produtoSalvo = produtoRepository.save(produtoCriado);
        return produtoMapper.toDto(produtoSalvo);
    }

    public List<ProdutoResponse> listarTodosProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtoMapper.toDtoList(produtos);
    }

    public ProdutoResponse buscarProdutoPorId(Long id){
        if(id == null || id <= 0){
            throw new IllegalArgumentException("O id do Produto deve existir e ser positivo");
        }

        return produtoRepository.findById(id)
                .map(produtoMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("O Produto procurado não existe"));
    }

    public ProdutoResponse modificarProduto (Long id, ProdutoUpdateRequest request){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            Produto produtoAtualizado = produtoMapper.toEntity(request);
            Produto produtoSalvo = produtoRepository.save(produtoAtualizado);
            return produtoMapper.toDto(produtoSalvo);
        } else {
            throw new IllegalArgumentException("O Produto a ser modificado deve existir");
        }
    }

    public void removerProduto(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            produtoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("O Produto a ser removido não existe");
        }
    }

}
