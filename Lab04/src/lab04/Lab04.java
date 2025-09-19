/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 6324569
 */
public class Lab04 extends Application {
    double[] info = new double[8];
    
    Label label = new Label("Enter number of days on the trip");
    TextField textField = new TextField();
    Button button = new Button("Submit");
    Label errorMessage = new Label("");
    
    HBox hBox = new HBox(textField);
    GridPane gridPane = new GridPane();
    
    Scene scene = new Scene(gridPane, 500, 500);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        textField.setMaxWidth(150);
        
        button.setOnMouseClicked(e -> {
            double num = 0;
            
            try {
                num = Double.parseDouble(textField.getText());
            } catch (NumberFormatException m) {
                errorMessage.setText("TextField must contain ONLY numbers");
            }
        });
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 10, 20, 10));
        
        gridPane.add(label, 0, 0);
        gridPane.add(hBox, 0, 1);
        gridPane.add(button, 0, 2);
        gridPane.add(errorMessage, 0, 4);
        
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setHalignment(hBox, HPos.CENTER);
        GridPane.setHalignment(button, HPos.CENTER);
        GridPane.setHalignment(errorMessage, HPos.CENTER);
        
        hBox.setAlignment(Pos.CENTER);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Lab 04");
        stage.show();
    }
    
}
