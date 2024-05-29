package com.example.uniburger.service;

import com.example.uniburger.model.Cardapio;
import com.example.uniburger.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    public List<Cardapio> getAllItems() {
        return cardapioRepository.findAll();
    }

    public Cardapio getItemById(Long id) {
        return cardapioRepository.findById(id).orElse(null);
    }

    public Cardapio createItem(Cardapio item) {
        return cardapioRepository.save(item);
    }

    public Cardapio updateItem(Cardapio item) {
        return cardapioRepository.save(item);
    }

    public void deleteItem(Long id) {
        cardapioRepository.deleteById(id);
    }
}