package com.example.uniburger.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cardapio_id")
    private Cardapio cardapio; // o cardápio do item

    @Column
    private int quantidade; // a quantidade do item

    public ItemPedido() {}

    public ItemPedido(Cardapio cardapio, int quantidade) {
        this.cardapio = cardapio;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cardapio getCardapio() {
        return this.cardapio;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}