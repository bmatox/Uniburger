package com.example.uniburger.controller;

import com.example.uniburger.model.Cardapio;
import com.example.uniburger.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public List<Cardapio> getAllItems() {
        return cardapioService.getAllItems();
    }

    @GetMapping("/{id}")
    public Cardapio getItemById(@PathVariable Long id) {
        return cardapioService.getItemById(id);
    }

    @PostMapping
    public Cardapio createItem(@RequestBody Cardapio item) {
        return cardapioService.createItem(item);
    }

    @PutMapping("/{id}")
    public Cardapio updateItem(@PathVariable Long id, @RequestBody Cardapio item) {
        item.setId(id);
        return cardapioService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        cardapioService.deleteItem(id);
    }
}