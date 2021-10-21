package src.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaAdmAval extends Applicartion {

    public static void main (String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        parent root = FXMLLoader.load(getClass().getResoucer("VE/TelaAdmAvaliador.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setTitle("Projeto FUGI");
        primaryStage.setScene(cena);
        primaryStage.show();

    }

}