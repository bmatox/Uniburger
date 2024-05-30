package com.example.uniburger.controller;

import com.example.uniburger.model.Bebida;
import com.example.uniburger.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @GetMapping
    public ResponseEntity<List<Bebida>> getAllBebidas() {
        return ResponseEntity.ok(bebidaService.getAllBebidas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> getBebidaById(@PathVariable Long id) {
        return ResponseEntity.ok(bebidaService.getBebidaById(id));
    }

    @PostMapping
    public ResponseEntity<Bebida> createBebida(@RequestBody Bebida bebida) {
        return ResponseEntity.ok(bebidaService.createBebida(bebida));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> updateBebida(@PathVariable Long id, @RequestBody Bebida bebida) {
        return ResponseEntity.ok(bebidaService.updateBebida(id, bebida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBebida(@PathVariable Long id) {
        bebidaService.deleteBebida(id);
        return ResponseEntity.ok().build();
    }
}