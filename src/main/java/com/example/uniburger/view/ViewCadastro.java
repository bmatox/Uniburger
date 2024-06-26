package com.example.uniburger.view;

import com.example.uniburger.model.*;
import com.example.uniburger.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewCadastro {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BebidaService bebidaService;

    @Autowired
    private PratoService pratoService;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private CardapioService cardapioService;

    @GetMapping("/cadastro_cliente")
    public String cadastroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro_cliente";
    }

    @PostMapping("/cadastro_cliente")
    public String cadastrarCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteService.createCliente(cliente);
        model.addAttribute("message", "Cliente cadastrado com sucesso!");
        return "cadastro_cliente";
    }

    @GetMapping("/cadastro_bebidas")
    public String cadastroBebidas(Model model) {
        model.addAttribute("bebida", new Bebida());
        return "cadastro_bebidas";
    }

    @PostMapping("/cadastro_bebidas")
    public String cadastrarBebida(@ModelAttribute Bebida bebida, Model model) {
        bebidaService.createBebida(bebida);
        model.addAttribute("message", "Bebida cadastrada com sucesso!");
        return "cadastro_bebidas";
    }

    @GetMapping("/cadastro_prato")
    public String cadastroPrato(Model model) {
        model.addAttribute("prato", new Prato());
        return "cadastro_prato";
    }

    @PostMapping("/cadastro_prato")
    public String cadastrarPrato(@ModelAttribute Prato prato, Model model) {
        pratoService.createPrato(prato);
        model.addAttribute("message", "Prato cadastrado com sucesso!");
        return "cadastro_prato";
    }

    @GetMapping("/cadastro_restaurante")
    public String cadastroRestaurante(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        return "cadastro_restaurante";
    }

    @PostMapping("/cadastro_restaurante")
    public String cadastrarRestaurante(@ModelAttribute Restaurante restaurante, Model model) {
        restauranteService.createRestaurante(restaurante);
        model.addAttribute("message", "Restaurante cadastrado com sucesso!");
        return "cadastro_restaurante";
    }

    @GetMapping("/cadastro_mesa")
    public String cadastroMesa(Model model) {
        model.addAttribute("mesa", new Mesa());
        return "cadastro_mesa";
    }

    @PostMapping("/cadastro_mesa")
    public String cadastrarMesa(@ModelAttribute Mesa mesa, Model model) {
        mesaService.createMesa(mesa);
        model.addAttribute("message", "Mesa cadastrada com sucesso!");
        return "cadastro_mesa";
    }

    @GetMapping("/cadastro_pedido")
    public String cadastroPedido(Model model) {
        model.addAttribute("pedido", new Pedido());

        // Busca todos os clientes do banco de dados
        List<Cliente> clientes = clienteService.getAllClientes();

        // Adiciona a lista de clientes ao modelo
        model.addAttribute("clientes", clientes);

        List<ItemPedido> itemPedido = itemPedidoService.getAllItemPedidos();
        model.addAttribute("itensPedido", itemPedido);

        return "cadastro_pedido";
    }

    @PostMapping("/cadastro_pedido")
    public String cadastrarPedido(@ModelAttribute Pedido pedido, @RequestParam Long itemPedidoId, @RequestParam Long clienteId, Model model) {
        // Busca o item de pedido pelo ID
        ItemPedido itemPedido = itemPedidoService.getItemPedidoById(itemPedidoId);

        // Busca o cliente pelo ID
        Cliente cliente = clienteService.getClienteById(clienteId);

        // Verifica se o item de pedido e o cliente existem
        if (itemPedido != null && cliente != null) {
            // Adiciona o item de pedido ao pedido
            pedido.getItens().add(itemPedido);

            // Associa o cliente ao pedido
            pedido.setCliente(cliente);

            // Salva o pedido
            pedidoService.createPedido(pedido);

            model.addAttribute("message", "Pedido cadastrado com sucesso!");
        } else {
            model.addAttribute("message", "Item de pedido ou cliente não encontrado!");
        }

        return "cadastro_pedido";
    }

    @GetMapping("/cadastro_itempedido")
    public String cadastroItemPedido(Model model) {
        model.addAttribute("itemPedido", new ItemPedido());

        // Busca todos os itens do cardapio do banco de dados
        List<Cardapio> cardapio = cardapioService.getAllItems();

        // Adiciona a lista de itens do cardapio ao modelo
        model.addAttribute("cardapio", cardapio);

        return "cadastro_itempedido";
    }

    @PostMapping("/cadastro_itempedido")
    public String cadastrarItemPedido(@ModelAttribute ItemPedido itemPedido, Model model) {
        itemPedidoService.createItemPedido(itemPedido);
        model.addAttribute("message", "Item do pedido cadastrado com sucesso!");
        return "cadastro_itempedido";
    }

    @GetMapping("/exibir_cardapio")
    public String exibirCardapio(Model model) {
        List<Cardapio> cardapio = cardapioService.getAllItems();
        model.addAttribute("cardapio", cardapio);
        return "exibir_cardapio";
    }

}