package com.example.uniburger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("controllerChoice")
public class ControllerHandler {

    @PostMapping("/controllerHandler")
    public String handleControllerChoice(@RequestParam String controllerChoice, Model model) {
        model.addAttribute("controllerChoice", controllerChoice);
        switch (controllerChoice) {
            case "ClienteView":
                return "redirect:/cadastro_cliente";
            case "BebidaView":
                return "redirect:/cadastro_bebidas";
            case "PratoView":
                return "redirect:/cadastro_prato";
            case "RestauranteView":
                return "redirect:/cadastro_restaurante";
            case "MesaView":
                return "redirect:/cadastro_mesa";
            case "PedidoView":
                return "redirect:/cadastro_pedido";
            case "ItemPedidoView":
                return "redirect:/cadastro_itempedido";
            default:
                return "redirect:/";
        }
    }
}