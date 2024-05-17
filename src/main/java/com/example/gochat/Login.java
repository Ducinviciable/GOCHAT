package com.example.gochat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Login extends Application{



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login-Res.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
