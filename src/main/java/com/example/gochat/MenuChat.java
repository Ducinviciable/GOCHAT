package com.example.gochat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuChat extends Application{

    public static void main(String[] args) throws Exception {

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InterfaceChat.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("LOGIN");

        stage.setScene(scene);
        stage.show();

    }

}
