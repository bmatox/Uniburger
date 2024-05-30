package com.example.uniburger.service;

import com.example.uniburger.model.Prato;
import com.example.uniburger.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    public List<Prato> getAllPratos() {
        return pratoRepository.findAll();
    }

    public Prato getPratoById(Long id) {
        Optional<Prato> optionalPrato = pratoRepository.findById(id);
        return optionalPrato.orElse(null);
    }

    public Prato createPrato(Prato prato) {
        return pratoRepository.save(prato);
    }

    public Prato updatePrato(Long id, Prato prato) {
        Optional<Prato> optionalPrato = pratoRepository.findById(id);
        if (optionalPrato.isPresent()) {
            Prato existingPrato = optionalPrato.get();
            existingPrato.setNome(prato.getNome());
            existingPrato.setPreco(prato.getPreco());
            existingPrato.setCategoria(prato.getCategoria());
            existingPrato.setIngredientes(prato.getIngredientes());
            return pratoRepository.save(existingPrato);
        } else {
            return null;
        }
    }

    public void deletePrato(Long id) {
        pratoRepository.deleteById(id);
    }
}