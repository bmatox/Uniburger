package com.example.uniburger.controller;

import com.example.uniburger.model.Mesa;
import com.example.uniburger.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<Mesa>> getAllMesas() {
        return ResponseEntity.ok(mesaService.getAllMesas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Long id) {
        return ResponseEntity.ok(mesaService.getMesaById(id));
    }

    @PostMapping
    public ResponseEntity<Mesa> createMesa(@RequestBody Mesa mesa) {
        return ResponseEntity.ok(mesaService.createMesa(mesa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        return ResponseEntity.ok(mesaService.updateMesa(id, mesa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
        return ResponseEntity.ok().build();
    }
}