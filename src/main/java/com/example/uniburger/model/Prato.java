package com.example.uniburger.model;

import jakarta.persistence.*;

@Entity
public class Prato extends Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String categoria; // entrada, principal ou sobremesa

    @Column
    private String ingredientes; // separados por vírgula

    public Prato() {}

    public Prato(String nome, double preco, String categoria, String ingredientes) {
        super(nome, preco);
        this.categoria = categoria;
        this.ingredientes = ingredientes;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public void mostraItemCompleto() {
        System.out.println("Prato: " + getNome() + " - R$ " + getPreco());
        System.out.println("Categoria: " + getCategoria() + " - Ingredientes: " + getIngredientes());
    }
}