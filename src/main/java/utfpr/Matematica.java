/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr;

import java.util.List;

/**
 *
 * @author Edmundo
 */
class Matematica {

    public int soma(int a, int b) {
        return a + b;
    }

    public Double mediana(List<Double> listaNumeros) {
        int esq = 0;
        int dir = listaNumeros.size() - 1;
        int meio;
        meio = (esq + dir) / 2;
        Double mediana = listaNumeros.get(meio);
        return mediana;
    }

    double media(List<Double> listaNumeros) {
        double total = 0;
        for (double numero : listaNumeros) {
            total += numero;
        }
        double media = total / listaNumeros.size();
        return media;
    }

    double menorValor(List<Double> listaNumeros) {
        double menor = listaNumeros.get(0);
        for(double numero : listaNumeros)
            if(numero < menor)
                menor = numero;
        return menor;
    }

    double maiorValor(List<Double> listaNumeros) {
        double maior = listaNumeros.get(0);
        for(double numero : listaNumeros)
            if(numero > maior)
                maior = numero;
        return maior;
    }

    int NumeroValoresAcimaMedia(List<Double> listaNumeros) {
        double media = this.media(listaNumeros);
        int qtd = 0;
        for(double numero : listaNumeros)
            if(numero > media)
                qtd++;
        return qtd;
    }

    double NumeroValoresBaixoMedia(List<Double> listaNumeros) {
       double media = this.media(listaNumeros);
        int qtd = 0;
        for(double numero : listaNumeros)
            if(numero < media)
                qtd++;
        return qtd;
    }

    double desvioPadrao(List<Double> listaNumeros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
