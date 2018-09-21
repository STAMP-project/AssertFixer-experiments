package com.mbueno.lanchonete.entities;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PedidoServiceTest {

    /*
    Alface - R$ 0.40
    Bacon - R$ 2,00
    Hambúrguer de carne - R$ 3,00
    Ovo - R$ 0,80
    Queijo - R$ 1,50
     */
    public List<Ingrediente> retornaIngredientes(){
        List<Ingrediente> ingredientes = new ArrayList<>();

        Ingrediente alface = new Ingrediente();
        alface.setId(1L);
        alface.setNome("Alface");
        alface.setQuantidade(1);
        alface.setValor(0.4);

        ingredientes.add(alface);

        return ingredientes;
    }



    @Test
    public void realizarPedidoComSucesso(){
        //cenario
        Ingrediente bacon = new Ingrediente();
        bacon.setNome("Bacon");
        bacon.setQuantidade(1);
        bacon.setValor(2.0);

        Ingrediente hamburguer = new Ingrediente();
        hamburguer.setNome("Hamburguer de Carne");
        hamburguer.setQuantidade(1);
        hamburguer.setValor(3.0);

        Ingrediente queijo = new Ingrediente();
        queijo.setNome("Queijo");
        queijo.setQuantidade(1);
        queijo.setValor(1.5);

        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(bacon);
        ingredientes.add(hamburguer);
        ingredientes.add(queijo);

        Lanche lanche1 = new Lanche();
        lanche1.setNome("X-Bacon");
        lanche1.setIngredientes(ingredientes);

        List<Lanche> lanches = new ArrayList<>();
        lanches.add(lanche1);

        //acao
        Pedido pedido = new Pedido();
        pedido.setLanches(lanches);
        pedido.setValor(pedido.valorPedido());

        //verificacao
        Assert.assertEquals(pedido.getValor(), 6.5d, 0.0001d);
    }

    @Test
    public void naoDeveRealizarPedidoSemIngrediente(){

    }

    @Test
    public void naoDeveRealizarPedidoSemLanche(){

    }

    @Test
    public void realizarPedidoComPromocaoLight(){
        //cenario



        //acao

        //verificacao
    }

    @Test
    public void realizarPedidoComPromocaoMuitaCarne(){

    }

    @Test
    public void realizarPedidoComPromocaoMuitoQueijo(){

    }

    @Test
    public void realizarPedidoComPromocaoInflacao(){

    }
}
