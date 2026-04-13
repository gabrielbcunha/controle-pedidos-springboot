package br.com.gabrielbcunha.controlepedidosspringboot.service;

import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.model.dto.ClienteUpdateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.model.entity.Cliente;
import br.com.gabrielbcunha.controlepedidosspringboot.mapper.ClienteMapper;
import br.com.gabrielbcunha.controlepedidosspringboot.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponse adicionarCliente(ClienteCreateRequest cliente) {

        Cliente novoCliente = clienteMapper.toEntity(cliente);
        Cliente clienteSalvo = clienteRepository.save(novoCliente);

        return clienteMapper.toDto(clienteSalvo);
    }

    public List<ClienteResponse> listarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDtoList(clientes);
    }

    public ClienteResponse buscarClientePorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O id do Cliente deve existir e ser positivo");
        }

        return clienteRepository.findById(id)
                .map(clienteMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("O Cliente procurado não existe"));
    }

    public ClienteResponse modificarCliente(Long id, ClienteUpdateRequest clienteUpdateRequest) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente clienteAtualizado = clienteMapper.toEntity(clienteUpdateRequest);
            Cliente clienteSalvo = clienteRepository.save(clienteAtualizado);
            return clienteMapper.toDto(clienteSalvo);
        } else {
            throw new IllegalArgumentException("O Cliente a ser modificado deve existir");
        }
    }

    public void removerCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            clienteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("O Cliente a ser removido não existe");
        }
    }

}
