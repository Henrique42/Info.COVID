package com.mycompany.projetocovid;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

// Controller da tela inicial, com o título e um botão que leva ao gráfico
public class MenuController {

    @FXML
    private Button btInicio;
    
    // Método que, ao clicar no botão, passa para a próxima tela
    @FXML
    void onBtInicio(ActionEvent event) throws IOException{
        App.setRoot("inicio");
    }
}