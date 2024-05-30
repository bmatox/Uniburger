package com.example.uniburger.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<ItemPedido> itens;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {}

    public Pedido(Cliente cliente) {
        this.itens = new ArrayList<>(); //cria uma lista vazia de itens
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void alterarItem(Cardapio item, int quantidade, boolean adicionar) {
        if (adicionar == true) {
            ItemPedido novoItem = new ItemPedido(item, quantidade);
            // adiciona o novo item à lista de itens
            itens.add(novoItem);
            System.out.println(quantidade + " " + item.getNome() + "(s) adicionado(s) ao pedido.");
        } else {
            for (ItemPedido itemPedido : itens) {
                if (itemPedido.getCardapio ().equals (item)) {
                    if (itemPedido.getQuantidade () >= quantidade) {
                        itemPedido.setQuantidade (itemPedido.getQuantidade () - quantidade);
                        System.out.println(quantidade + " " + item.getNome() + "(s) removido(s) do pedido.");
                    } else {
                        System.out.println ("Não foi possível remover. Quantidade que se quer remover do ítem " + item.getNome() + ", maior que a quantidade do pedido.");
                    }
                }

            }
        }
    }



    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.getCardapio().getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }


    public void imprimirComanda() {
        // Cria um objeto File que representa o arquivo onde a comanda será escrita
        File file = new File("C:\\Users\\Unifor\\Desktop\\Nova pasta\\comandaimpressa.txt");
        try {
            // Cria um objeto FileWriter que permite escrever no arquivo
            FileWriter fw = new FileWriter(file, true);

            fw.write("\nComanda do Pedido\n");
            fw.write("Cliente: " + cliente.getNome() + "\n");
            fw.write("Itens:\n");
            for (ItemPedido item : itens) {
                // Escreve no arquivo o nome, o preço e a quantidade de cada item
                fw.write(item.getCardapio().getNome() + " - R$ " + item.getCardapio().getPreco() + " - Quantidade: " + item.getQuantidade() + "\n");
            }
            fw.write("Valor Total: R$ " + calcularValorTotal() + "\n");

            fw.close();

            System.out.println("A comanda do pedido foi gerada com sucesso.");
        } catch (IOException e) {
            // imprime a mensagem da exceção se ocorrer um erro de entrada ou saída
            System.out.println(e.getMessage());
        }
    }

}