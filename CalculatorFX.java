/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author joona
 */
public class CalculatorFX extends Application {
    //Määritetään kontrollielementit
    TextField tfNum1;
    TextField tfNum2;
    Button btnAddition;
    Button btnSubtraction;
    Button btnMultiply;
    Button btnDivide;
    Button btnClear;
    Label lblAnswer;
    
    @Override
    public void start(Stage primaryStage) {
        //Määritetään kontrollit
        tfNum1 = new TextField();
        tfNum2 = new TextField();
        btnAddition = new Button("+");
        btnSubtraction = new Button("-");
        btnMultiply = new Button("*");
        btnDivide = new Button("/");
        btnClear = new Button("Clear");
        lblAnswer = new Label("?");
        
        //Tehdään answer-labelille tummennetut reunat
        lblAnswer.setAlignment(Pos.CENTER);
        lblAnswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        
        //Määritetään horisontaalinen ja vertikaalinen väli
        root.setHgap(10);
        root.setVgap(10);
        
        //Määritellään nappuloiden sijainti
        root.add(btnAddition, 0, 0);
        root.add(btnSubtraction, 1, 0);
        root.add(btnMultiply, 0, 1);
        root.add(btnDivide, 1, 1);
        root.add(btnClear, 0, 4, 2, 1);
        
        root.add(tfNum1, 0, 2);
        root.add(tfNum2, 1, 2);
        root.add(lblAnswer, 0, 3, 2, 1);
        
        setWidths();
        attachCode();
        
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void setWidths() {
        tfNum1.setPrefWidth(70);
        tfNum2.setPrefWidth(70);
        btnAddition.setPrefWidth(70);
        btnSubtraction.setPrefWidth(70);
        btnMultiply.setPrefWidth(70);
        btnDivide.setPrefWidth(70);
        btnClear.setPrefWidth(150);
        lblAnswer.setPrefWidth(150);
    }
    
    public void attachCode() {
        //Joka nappula ajaa painettaessa BTNCODE:n
        btnAddition.setOnAction(e -> btncode(e));
        btnSubtraction.setOnAction(e -> btncode(e));
        btnMultiply.setOnAction(e -> btncode(e));
        btnDivide.setOnAction(e -> btncode(e));
        btnClear.setOnAction(e -> btncode(e));
    }
    
    public void btncode(ActionEvent e) {
        int num1, num2, answer;
        char symbol;
        //e kertoo mitä nappia on painettu
        if (e.getSource() == btnClear)
        {
            tfNum1.setText("");
            tfNum2.setText("");
            lblAnswer.setText("");
            tfNum1.requestFocus();
            return;
        }
        
        //Lukee numerot tekstikentiltä
        num1 = Integer.parseInt(tfNum1.getText());
        num2 = Integer.parseInt(tfNum2.getText());
        if (e.getSource() == btnAddition) 
        {
            symbol = '+';
            answer = num1 + num2;
        }
        else if (e.getSource() == btnSubtraction)
        {
            symbol = '-';
            answer = num1 - num2;
        }
        else if (e.getSource() == btnMultiply)
        {
            symbol = '*';
            answer = num1 * num2;
        }
        else
        {
            symbol = '/';
            answer = num1 / num2;
        }
        //Näyttää vastauksen
        lblAnswer.setText("" + num1 + symbol + num2 + "=" + answer);
    }
        
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
