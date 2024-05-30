package com.example.uniburger.service;

import com.example.uniburger.model.ItemPedido;
import com.example.uniburger.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido getItemPedidoById(Long id) {
        Optional<ItemPedido> optionalItemPedido = itemPedidoRepository.findById(id);
        return optionalItemPedido.orElse(null);
    }

    public ItemPedido createItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido updateItemPedido(Long id, ItemPedido itemPedido) {
        Optional<ItemPedido> optionalItemPedido = itemPedidoRepository.findById(id);
        if (optionalItemPedido.isPresent()) {
            ItemPedido existingItemPedido = optionalItemPedido.get();
            existingItemPedido.setCardapio(itemPedido.getCardapio());
            existingItemPedido.setQuantidade(itemPedido.getQuantidade());
            return itemPedidoRepository.save(existingItemPedido);
        } else {
            return null;
        }
    }

    public void deleteItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}