package com.mycompany.projetocovid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Classe que recebe os dados de um estado referente a determinado mês
@JsonIgnoreProperties(ignoreUnknown=true)
public class Dado {
    // Nome do estado
    public String state = null;
    // Número de casos
    public int cases = 0;
    // Número de mortes
    public int deaths = 0;
    // Mês ao qual o dado se refere, pra ser exibido no gráfico
    public String mes;
}