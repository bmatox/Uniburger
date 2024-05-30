package com.example.uniburger.service;


import com.example.uniburger.model.Bebida;
import com.example.uniburger.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public List<Bebida> getAllBebidas() {
        return bebidaRepository.findAll();
    }

    public Bebida getBebidaById(Long id) {
        Optional<Bebida> optionalBebida = bebidaRepository.findById(id);
        return optionalBebida.orElse(null);
    }

    public Bebida createBebida(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    public Bebida updateBebida(Long id, Bebida bebida) {
        Optional<Bebida> optionalBebida = bebidaRepository.findById(id);
        if (optionalBebida.isPresent()) {
            Bebida existingBebida = optionalBebida.get();
            existingBebida.setNome(bebida.getNome());
            existingBebida.setPreco(bebida.getPreco());
            existingBebida.setTipo(bebida.getTipo());
            existingBebida.setVolume(bebida.getVolume());
            return bebidaRepository.save(existingBebida);
        } else {
            return null;
        }
    }

    public void deleteBebida(Long id) {
        bebidaRepository.deleteById(id);
    }
}