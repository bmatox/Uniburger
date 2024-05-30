package com.example.uniburger.service;

import com.example.uniburger.model.Pedido;
import com.example.uniburger.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        return optionalPedido.orElse(null);
    }

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Long id, Pedido pedido) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido existingPedido = optionalPedido.get();
            existingPedido.setCliente(pedido.getCliente());
            existingPedido.setItens(pedido.getItens());
            return pedidoRepository.save(existingPedido);
        } else {
            return null;
        }
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}