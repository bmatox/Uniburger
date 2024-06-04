package com.example.uniburger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerHandler {

    @PostMapping("/controllerHandler")
    public String handleControllerChoice(@RequestParam String controllerChoice, Model model) {
        switch (controllerChoice) {
            case "ClienteView":
                // Redireciona para a página de cadastro de cliente
                return "redirect:/cadastro_cliente";
            // Adicione outros casos para cada controlador que você tem
            case "BebidaView":
                // Redireciona para a página de bebidas
                return "redirect:/cadastro_bebidas";
            case "MesaView":
                return "redirect:/mesas";
            default:
                // Se nenhuma opção válida foi selecionada, redireciona para a página inicial
                return "redirect:/";
        }
    }
}