package com.example.uniburger.service;

import com.example.uniburger.model.Restaurante;
import com.example.uniburger.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Restaurante getRestauranteById(Long id) {
        Optional<Restaurante> optionalRestaurante = restauranteRepository.findById(id);
        return optionalRestaurante.orElse(null);
    }

    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante updateRestaurante(Long id, Restaurante restaurante) {
        Optional<Restaurante> optionalRestaurante = restauranteRepository.findById(id);
        if (optionalRestaurante.isPresent()) {
            Restaurante existingRestaurante = optionalRestaurante.get();
            existingRestaurante.setNome(restaurante.getNome());
            existingRestaurante.setEndereco(restaurante.getEndereco());
            existingRestaurante.setTelefone(restaurante.getTelefone());
            existingRestaurante.setMesas(restaurante.getMesas());
            return restauranteRepository.save(existingRestaurante);
        } else {
            return null;
        }
    }

    public void deleteRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }
}