package com.mbueno.lanchonete.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "lanche")
public class Lanche implements Serializable {

    private Long id;
    private String nome;
    private List<Ingrediente> ingredientes;
    private double valor;

    public Lanche(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "valor")
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @OneToMany(mappedBy = "lanche", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double valorLanche(){
        for (Ingrediente ingrediente: ingredientes){
            valor += ingrediente.getValor();
        }
        return valor;
    }

    @Override
    public String toString() {
        return "Lanche [id=" + id + ", nome=" + nome + ", valor=" + getValor() + "]";
    }

}
