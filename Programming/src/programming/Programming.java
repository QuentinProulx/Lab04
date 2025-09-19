/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programming;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 6324569
 */
public class Programming extends Application {

    Label label = new Label("Welcome to this thing");
    Pane pane = new Pane(label);
    Scene scene = new Scene(pane, 500, 500);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        label.setId("label-error");

        scene.getStylesheets().add("res/style.css");
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Cool Application");
        stage.show();
    }
    
}
