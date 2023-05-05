package com.mycompany.projetocovid;

import java.util.Comparator;

// Classe que implementa a classe Comparator, servindo para ordenar os estados
public class Ordenador implements Comparator<Estado>{
    // Método que faz a comparação dos estados pelo nome
    @Override
    public int compare(Estado a, Estado b) {
        return a.nome.compareTo(b.nome);
    }
    
}
