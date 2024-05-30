package com.example.uniburger.model;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Mesa> mesas; // lista de mesas do restaurante

    public Restaurante() {}

    public Restaurante(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.mesas = new ArrayList<Mesa>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public void fecharPedido(Mesa mesa) {
        // se a mesa não estiver disponível, ou seja, se ela tiver um pedido associado
        if (!mesa.isDisponivel()) {
            // recupera o pedido da mesa
            Pedido pedido = mesa.getPedido();
            System.out.println("\n------ ENCERRAMENTO DE PEDIDO -----");
            pedido.imprimirComanda();
            System.out.println("O pedido da mesa " + mesa.getNumero() + " foi fechado com sucesso e a comanda foi impressa.");
            mesa.desassociarPedido();
            System.out.println(" ");
            // se a mesa estiver disponível, ou seja, se não tiver um pedido associado
        } else {
            System.out.println("A mesa " + mesa.getNumero() + " está vazia.");
        }
    }

    // método para remover todas as mesas disponíveis, em caso de término de expediente.
    public void removerMesasDisponiveis() {
        this.mesas.removeIf(mesa -> mesa.isDisponivel());
        System.out.println("Todas as mesas disponíveis foram removidas.");
    }
}