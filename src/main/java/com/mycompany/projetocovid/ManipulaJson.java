package com.mycompany.projetocovid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

// Classe que realiza todas as operações relacionadas a json
public class ManipulaJson {
    // lista de todos os relatórios obtidos
    private ArrayList<Relatorio> listaRelatorios = null;
    // lista de todos os estados obtidos
    private ArrayList<Estado> listaEstados = null;
    // Classe para transformar os dados do json em objeto
    private ObjectMapper om;
    // URL que será utilizada pelo json
    private URL url;
    
    // Método que recebe a lista de relatórios pelo json
    public ArrayList<Relatorio> getDados() throws JsonProcessingException, MalformedURLException, IOException{
        om = new ObjectMapper();
        // Parte do link para a API do COVID que não muda
        String link = "https://covid19-brazil-api.vercel.app/api/report/v1/brazil/";
        
        listaRelatorios = new ArrayList<Relatorio>();
        
        Relatorio r;
        // Ano ao qual os dados se referem
        int ano = 2020;
        // Mês ao qual os dados se referem
        int mes_em_analise = 3, total_meses = 0;
        
        // Estrutura while que vai se repetir até que o link retorne um objeto nulo
        while (total_meses < 12) {
            // URL final (link + ano + mês)
            url = new URL(link + ano + Mes.getData(mes_em_analise));

            // leitura dos objetos do json
            r = om.readValue(url, Relatorio.class);
            
            // Verifica se o retorno é nulo
            // Caso sim, o while é interrompido
            if(r.data.isEmpty())
                break;
            // Caso não:
            else{
                // O mês é atribuído
                r.mes = mes_em_analise;
                // O relatório é adicionado na lista
                listaRelatorios.add(r);
                
                // Caso o mês seja 12, o ano vai passar e o mês volta para janeiro
                if (mes_em_analise >= 12){
                    mes_em_analise = 0;
                    ano++;
                }
            }
            mes_em_analise++; total_meses++;
        }
        
        // retorno da lista
        return listaRelatorios;
    }
    
    // Método que recebe a lista de estados pelo json
    public ArrayList<Estado> getEstados() throws MalformedURLException, IOException{
        om = new ObjectMapper();
        // link para a API dos estados
        url = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/estados");
        
        //leitura dos objetos do json
        listaEstados = om.readValue(url, new TypeReference<ArrayList<Estado>>(){});
        // retorno da lista
        return listaEstados;
    }
}
