package com.calculator.calculatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class CalculatorController {

    private CalculatorHandler calculatorhandler;
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button addition;
    @FXML
    private Button substract;
    @FXML
    private Button multiply;
    @FXML
    private Button divide;
    @FXML
    private Button power;
    @FXML
    private Button radical;
    @FXML
    private Button decimal;
    @FXML
    private Button equal;
    @FXML
    private Button clear;
    @FXML
    private Button clearAll;
    @FXML
    private Label screen;


    public void update(String screen) { // update the main label with the numbers
        this.screen.setText(screen);
    }

    @FXML
    private void initialize(){ //init
        calculatorhandler = new CalculatorHandler();
        ArrayList<Button> buttons = new ArrayList<>(){
            {
                add(zero);
                add(one);
                add(two);
                add(three);
                add(four);
                add(five);
                add(six);
                add(seven);
                add(eight);
                add(nine);
                add(addition);
                add(substract);
                add(multiply);
                add(divide);
                add(power);
                add(decimal);
                add(equal);
                add(radical);
                add(clear);
                add(clearAll);
            }
        };

        for(Button b : buttons){ // event handler
            b.setOnAction(event->{
                Button eventClick = (Button) event.getSource();
                update(calculatorhandler.handler(eventClick.getText()));
            });
        }
    }
}