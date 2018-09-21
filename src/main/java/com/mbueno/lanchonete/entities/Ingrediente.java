package com.mbueno.lanchonete.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ingrediente")
public class Ingrediente implements Serializable {

    private Long id;
    private String nome;
    private double valor;
    private int quantidade;

    public Ingrediente(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "valor", nullable = false)
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Column(name = "quantidade")
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Ingrediente [id=" + id + ", nome=" + nome + ", valor=" + valor +
                ", quantidade=" + quantidade +"]";
    }
}
