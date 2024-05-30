package com.example.uniburger.service;

import com.example.uniburger.model.Mesa;
import com.example.uniburger.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Mesa getMesaById(Long id) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id);
        return optionalMesa.orElse(null);
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(Long id, Mesa mesa) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id);
        if (optionalMesa.isPresent()) {
            Mesa existingMesa = optionalMesa.get();
            existingMesa.setNumero(mesa.getNumero());
            existingMesa.setDisponivel(mesa.isDisponivel());
            existingMesa.setPedido(mesa.getPedido());
            return mesaRepository.save(existingMesa);
        } else {
            return null;
        }
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}