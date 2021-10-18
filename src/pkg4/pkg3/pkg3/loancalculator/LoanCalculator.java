/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg3.pkg3.loancalculator;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Iván Zambrana Naranjo
 */
public class LoanCalculator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Title
        primaryStage.setTitle("Loan Calculator");
        
        //GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Labels, Textfields and button
        Label lbInterestRate = new Label("Annual Interest Rate:");
        grid.add(lbInterestRate, 1, 0);
        TextField tfInterestRate = new TextField();
        grid.add(tfInterestRate, 2, 0);
        
        Label lbNumberYears = new Label("Number of Years:");
        grid.add(lbNumberYears, 1, 1);
        TextField tfNumberYears = new TextField();
        grid.add(tfNumberYears, 2, 1);
        
        Label lbLoanAmount = new Label("Loan Amount:");
        grid.add(lbLoanAmount, 1, 2);
        TextField tfLoanAmount = new TextField();
        grid.add(tfLoanAmount, 2, 2);
        
        Label lbMonthlyPayment = new Label("Monthly Payment:");
        grid.add(lbMonthlyPayment, 1, 3);
        TextField tfMonthlyPayment = new TextField();
        grid.add(tfMonthlyPayment, 2, 3);
        
        Label lbTotalPayment = new Label("Annual Interest Rate:");
        grid.add(lbTotalPayment, 1, 4);
        TextField tfTotalPayment = new TextField();
        grid.add(tfTotalPayment, 2, 4);
        
        Button btnCalculate = new Button();
        btnCalculate.setText("Calculate");
        grid.add(btnCalculate, 2, 5);
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    double i = Double.parseDouble(tfInterestRate.getText());
                    int n = Integer.parseInt(tfNumberYears.getText());
                    int h = Integer.parseInt(tfLoanAmount.getText()); 
                    
                    double r = i /1200;
                    double m = h * r / (1 - Math.pow((1 + r), -12 * n));
                    double t = n * 12 * m;
                    
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                     String formattedDoubleM = decimalFormat.format(m);
                     String formattedDoubleT = decimalFormat.format(t);
                    tfMonthlyPayment.setText("$"+ formattedDoubleM);
                    tfTotalPayment.setText("$"+formattedDoubleT);
                    
                } catch (NumberFormatException E)
                {
                    System.out.println("Format error or empty fields!!");
                }
                
                
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(grid);
        
        Scene scene = new Scene(root, 350, 250);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
