/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cssexample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 6324569
 */
public class CssExample extends Application {

    Label label = new Label("Text");
    Button button = new Button("Change the Text");
    TextField textField = new TextField();
    
    VBox vbox = new VBox(label, button, textField);
    Scene scene = new Scene(vbox, 500, 500);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        textField.setMaxWidth(200);
        vbox.setAlignment(Pos.CENTER);
        
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("CSS Example");
        stage.show();
    }
    
}
