package com.example.uniburger.view;

import com.example.uniburger.model.Cliente;
import com.example.uniburger.model.Bebida; // Importação da classe Bebida
import com.example.uniburger.service.ClienteService;
import com.example.uniburger.service.BebidaService; // Importação do serviço BebidaService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteView {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BebidaService bebidaService; // Injeção do serviço BebidaService

    @GetMapping("/cadastro_cliente")
    public String cadastroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro_cliente";
    }

    @GetMapping("/cadastro_bebidas")
    public String cadastroBebidas(Model model) {
        model.addAttribute("bebida", new Bebida()); // Alteração de "bebidas" para "bebida"
        return "cadastro_bebidas";
    }

    @PostMapping("/cadastro_cliente")
    public String cadastrarCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteService.createCliente(cliente);
        model.addAttribute("message", "Cliente cadastrado com sucesso!");
        return "cadastro_cliente";
    }
}