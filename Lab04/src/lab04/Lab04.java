/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 6324569
 */
public class Lab04 extends Application {
    int iterator = 0;
    double[] info = new double[8];
    String[] questions = {"Number of days on the trip",
    "Amount of airfare, if any",
    "Amount of car rental fees, if any",
    "Number of miles driven, if a private vehicle was used",
    "Amount of parking fees, if any",
    "Amount of taxi charges, if any",
    "Conference or seminar registration fees, if any",
    "Lodging charges, per night"};
    
    String[] conclusions = {"1. Total expenses: ",
    "2. Total allowable expenses: ",
    "3. Excess that must be paid:",
    "4. Amount saved: "};
    
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
                
                if (iterator < 7) {
                    errorMessage.setText("");
                    textField.setText("");
                    
                    info[iterator] = num;
                    label.setText(questions[iterator + 1]);
                    iterator++;
                } else {
                    info[0] = Math.round(info[0]);
                    info[3] = Math.round(info[3]);
                    
                    displayInfo();
                }
                
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
    
    private void displayInfo() {
        
        for (int i = 0; i < 4; i++) {
            for (Node node : gridPane.getChildren()) {
                if (GridPane.getColumnIndex(node) == i) {
                    node.setVisible(false);
                }
            }
        }
        
        gridPane.add(new Label(conclusions[0]), 0, 0);
        gridPane.add(new Label(conclusions[1]), 0, 1);
        gridPane.add(new Label(conclusions[2]), 0, 2);
        gridPane.add(new Label(conclusions[3]), 0, 3);
        
        double allowableExpenses = info[0] * 10 + info[0] * info[0] * 20 + info[0] * 95;
        double actualExpenses = info[0] * ((info[4] >= 10) ? 10 : info[4]) +
                info[0] * ((info[5] >= 20) ? 20 : info[5]) +
                info[0] * ((info[7] >= 95) ? 95 : info[7]);
        double toPay = info[1] + info[2] + info[4] + info[5] + info[6] + info[7];
        double reimburses = info[0] * 37 + actualExpenses + 0.27 * info[3];
        
        gridPane.add(new Label("" + toPay), 1, 0);
        gridPane.add(new Label("" + allowableExpenses), 1, 1);
        gridPane.add(new Label("" + (toPay - reimburses)), 1, 2);
        gridPane.add(new Label("" + actualExpenses), 1, 3);
    }
}
