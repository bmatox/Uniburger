package com.example.uniburger.controller;

import com.example.uniburger.model.ItemPedido;
import com.example.uniburger.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemPedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> getAllItemPedidos() {
        return ResponseEntity.ok(itemPedidoService.getAllItemPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> getItemPedidoById(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.getItemPedidoById(id));
    }

    @PostMapping
    public ResponseEntity<ItemPedido> createItemPedido(@RequestBody ItemPedido itemPedido) {
        return ResponseEntity.ok(itemPedidoService.createItemPedido(itemPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> updateItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        return ResponseEntity.ok(itemPedidoService.updateItemPedido(id, itemPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.deleteItemPedido(id);
        return ResponseEntity.ok().build();
    }
}