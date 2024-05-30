package com.example.uniburger.controller;

import com.example.uniburger.model.Prato;
import com.example.uniburger.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @GetMapping
    public List<Prato> getAllPratos() {
        return pratoService.getAllPratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> getPratoById(@PathVariable Long id) {
        Prato prato = pratoService.getPratoById(id);
        if (prato != null) {
            return ResponseEntity.ok(prato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Prato createPrato(@RequestBody Prato prato) {
        return pratoService.createPrato(prato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> updatePrato(@PathVariable Long id, @RequestBody Prato prato) {
        Prato updatedPrato = pratoService.updatePrato(id, prato);
        if (updatedPrato != null) {
            return ResponseEntity.ok(updatedPrato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrato(@PathVariable Long id) {
        pratoService.deletePrato(id);
        return ResponseEntity.noContent().build();
    }
}