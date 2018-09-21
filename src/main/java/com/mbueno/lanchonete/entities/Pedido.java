package com.mbueno.lanchonete.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "pedido")
public class Pedido implements Serializable {

    private Long id;
    private List<Lanche> lanches;
    private double valor;

    public Pedido(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    public List<Lanche> getLanches() {
        return lanches;
    }

    public void setLanches(List<Lanche> lanches) {
        this.lanches = lanches;
    }

    @Column(name = "valor", nullable = false)
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double valorPedido(){
        for (Lanche lanche: lanches){
            valor += lanche.valorLanche();
        }
        return valor;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", valor=" + valor + "]";
    }
}
