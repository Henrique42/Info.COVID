package com.mycompany.projetocovid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

// Controller onde fica o gráfico e a listView de estados

/**
 *
 * @author Henrique
 */
public class InicioController {
    // Lista de relatórios
    ArrayList<Relatorio> relatorios;
    // Lista de estados
    ArrayList<Estado> estados;
    
    @FXML
    private MenuItem opVoltar;

    @FXML
    private MenuItem opClose;

    @FXML
    private ListView<String> listView;

    @FXML
    private BarChart<String, Number> histograma;

    @FXML
    private CategoryAxis eixoCategorias;

    @FXML
    private NumberAxis eixoValores;
    
    // Caso a opção "fechar" seja selecionada no menu, o aplicativo é encerrado
    @FXML
    void onOpClose(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    // Caso a opção "voltar" seja selecionada no menu, o aplicativo retorna a tela inicial
    @FXML
    void onOpVoltar(ActionEvent event) throws IOException {
        histograma.getData().clear();
        App.setRoot("menu");
    }
    
    // Método que varre a lista de registros e seleciona os dados referentes ao estado escolhido
    ArrayList<Dado> filtro(String estado){
        ArrayList<Dado> listaFiltrada = new ArrayList<Dado>();
        
        for(Relatorio r: relatorios){
            for(Dado d: r.data){
                if(d.state.equals(estado)){
                    d.mes = Mes.getNome(r.mes);
                    listaFiltrada.add(d);
                }
            }
        }
        
        return listaFiltrada;
    }
    
    // Método que é ativado quando o usuário escolhe uma opção da listView
    @FXML
    void onMouseClickedLV(MouseEvent event) {
        String estado = listView.getSelectionModel().getSelectedItem();
        // Chama o método para filtrar a lista de dados
        ArrayList<Dado> listaFiltrada = filtro(estado);
        histograma.getData().clear();
        
        // Cria o grupo de dados referentes aos casos de COVID
        BarChart.Series<String, Number> s1 = new BarChart.Series<String, Number>();
        s1.setName("Casos de COVID-19");   
        int ultimo1 = 0;
        // Cria o grupo de dados referentes às mortes por COVID
        BarChart.Series<String, Number> s2 = new BarChart.Series<String, Number>();
        s2.setName("Mortes por COVID-19");   
        int ultimo2 = 0;
        
        // Para cada dado da lista adiciona um valor para o grupo de casos e outro para o de mortes
        // OBS.: as variáveis de "último" servem para subtrair os valores atuais por aqueles do último mês
        for (Dado d: listaFiltrada) {
            s1.getData().add(new BarChart.Data<String, Number>(d.mes, (d.cases - ultimo1)));
            ultimo1 = d.cases;
            s2.getData().add(new BarChart.Data<String, Number>(d.mes, (d.deaths - ultimo2)));
            ultimo2 = d.deaths;
        }
        
        // Cria uma lista de dados para adicionar todos os dados no gráfico
        ArrayList<BarChart.Series<String, Number>> dataList = new ArrayList<BarChart.Series<String, Number>>();
        dataList.add(s1);
        dataList.add(s2);

        // Adiciona todos os dados no gráfico
        histograma.getData().addAll(dataList);
    }
    
    // Método que é ativado quando a tela inicia
    @FXML
    public void initialize() throws IOException {
        ManipulaJson ms = new ManipulaJson();
        // A lista de relatórios é obtida
        relatorios = ms.getDados();
        // A lista de estados é obtida
        estados = ms.getEstados();
        // A lista de estados é ordenada
        Collections.sort(estados, new Ordenador());
        listView.getItems().clear();
        // Os estados são adicionados a listView
        for(Estado e: estados)
            listView.getItems().add(e.nome);
        
        // Atribui título ao gráfico
        histograma.setTitle("Período: Mar/2020 ~ Fev/2021");
        // Atribui título ao eixo X
        eixoCategorias.setLabel("Mês");   
        // Atribui título ao eixo Y
        eixoValores.setLabel("Quantidade");
    }    
}