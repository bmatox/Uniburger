package com.example.uniburger.model;

import jakarta.persistence.*;

@Entity
public class Bebida extends Cardapio {

    @Column
    private String tipo; // alcoólica ou não-alcoólica

    @Column
    private int volume; // em ml

    public Bebida() {}

    public Bebida(String nome, double preco, String tipo, int volume) {
        super(nome, preco);
        this.tipo = tipo;
        this.volume = volume;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVolume() {
        return volume;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void mostraItemCompleto() {
        System.out.println("Bebida: " + getNome() + " - R$ " + getPreco());
        System.out.println("Tipo: " + getTipo() + " - Volume: " + getVolume() + " ml");
    }
}