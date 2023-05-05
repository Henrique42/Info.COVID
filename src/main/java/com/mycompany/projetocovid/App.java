package com.mycompany.projetocovid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Classe que inicia a aplicação
public class App extends Application {

    private static Scene scene;
    
    // Método que cria a cena e diz qual é o fxml inicial
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"), 720, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    // Método que define a tela inicial
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    // Método que carrega o fxml
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    
    // Método main, que inicia a aplicação
    public static void main(String[] args) {
        launch();
    }

}