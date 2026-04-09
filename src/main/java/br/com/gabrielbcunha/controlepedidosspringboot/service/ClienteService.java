package br.com.gabrielbcunha.controlepedidosspringboot.service;

import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteCreateRequest;
import br.com.gabrielbcunha.controlepedidosspringboot.dto.ClienteResponse;
import br.com.gabrielbcunha.controlepedidosspringboot.entity.Cliente;
import br.com.gabrielbcunha.controlepedidosspringboot.mapper.ClienteMapper;
import br.com.gabrielbcunha.controlepedidosspringboot.repository.ClienteRepository;
import org.springframework.stereotype.Service;


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

}
