package com.controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            stage.setResizable(false);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/insertion.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 360, 390);
            stage.setTitle("Ajout de membre");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
}
