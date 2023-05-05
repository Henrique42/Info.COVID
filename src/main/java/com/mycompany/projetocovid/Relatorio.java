package com.mycompany.projetocovid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

// Classe que recebe o "relatório" pelo json, ou seja, o conjunto de todos os dados daquele dia
@JsonIgnoreProperties(ignoreUnknown=true)
public class Relatorio {
    // Lista de dados de um dia, cada estado representa 1 dado
    public ArrayList<Dado> data = null;
    // Mês ao qual o relatório se refere
    public int mes;
}