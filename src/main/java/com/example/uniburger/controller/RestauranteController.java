package com.example.uniburger.controller;

import com.example.uniburger.model.Restaurante;
import com.example.uniburger.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> getAllRestaurantes() {
        return restauranteService.getAllRestaurantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable Long id) {
        Restaurante restaurante = restauranteService.getRestauranteById(id);
        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.createRestaurante(restaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        Restaurante updatedRestaurante = restauranteService.updateRestaurante(id, restaurante);
        if (updatedRestaurante != null) {
            return ResponseEntity.ok(updatedRestaurante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
        return ResponseEntity.noContent().build();
    }
}