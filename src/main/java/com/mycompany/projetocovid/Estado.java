package com.mycompany.projetocovid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Classe que recebe a lista de todos os estados

/**
 *
 * @author Henrique
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Estado {
    // nome do estado
    public String nome;
}