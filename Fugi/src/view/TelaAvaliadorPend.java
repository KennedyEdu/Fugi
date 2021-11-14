package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaAvaliadorPend extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/TelaAvaliadorPendentes.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setTitle("Projeto FUGI");
        primaryStage.setScene(cena);
        primaryStage.show();

    }
}