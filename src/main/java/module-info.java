module com.mycompany.projetocovid {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    
    opens com.mycompany.projetocovid to javafx.fxml;
    exports com.mycompany.projetocovid;
}