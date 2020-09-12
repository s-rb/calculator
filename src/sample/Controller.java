package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnPercent;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnXmultipleX;

    @FXML
    private Button btnRoot;

    @FXML
    private Button btn1divByX;

    @FXML
    private Button btnClearCurrent;

    @FXML
    private Button btnBackspace;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnX;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btn0;

    @FXML
    private Button btnComma;

    @FXML
    private Button btnEquals;

    @FXML
    private Label labelField;

    @FXML
    private Button btnMemClear;

    @FXML
    private Button btnMemReturn;

    @FXML
    private Button btnMemPlus;

    @FXML
    private Button btnMemMinus;

    private String stringNum = "";
    private float firstNum;
    private char operation;

    @FXML
    void initialize() {
        btn0.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(0);
        });
        btn1.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(1);
        });
        btn2.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(2);
        });
        btn3.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(3);
        });
        btn4.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(4);
        });
        btn5.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(5);
        });
        btn6.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(6);
        });
        btn7.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(7);
        });
        btn8.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(8);
        });
        btn9.setOnAction(event -> { // Обрабатываем событие event нажатие на кнопку
            addNumber(9);
        });
        btnPlus.setOnAction(event -> {
            mathAction('+');
        });
        btnMinus.setOnAction(event -> {
            mathAction('-');
        });
        btnEquals.setOnAction(event -> {
            equalAction();
        });
        btnX.setOnAction(event -> {
            mathAction('*');
        });
        btnDivide.setOnAction(event -> {
            mathAction('/');
        });
        btnComma.setOnAction(event -> {
            if (!this.stringNum.contains(".")) {
                this.stringNum += ".";
                labelField.setText(stringNum);
            }
        });
        btnPercent.setOnAction(event -> {
            if (!this.stringNum.equals("")) {
                float num = Float.parseFloat(this.stringNum) * 0.1f;
                this.stringNum = Float.toString(num);
                labelField.setText(stringNum);
            }
        });
        btnClearAll.setOnAction(actionEvent -> {
            labelField.setText("0");
            this.stringNum = "";
            this.firstNum = 0;
            this.operation = 'E';
        });
        // +- button = *-1
//        assert btnPercent != null : "fx:id=\"btnPercent\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnXmultipleX != null : "fx:id=\"btnXmultipleX\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnRoot != null : "fx:id=\"btnRoot\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn1divByX != null : "fx:id=\"btn1divByX\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnClearCurrent != null : "fx:id=\"btnClearCurrent\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnBackspace != null : "fx:id=\"btnBackspace\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnX != null : "fx:id=\"btnX\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnComma != null : "fx:id=\"btnComma\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'sample.fxml'.";
//        assert labelField != null : "fx:id=\"labelField\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnMemClear != null : "fx:id=\"btnMemClear\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnMemReturn != null : "fx:id=\"btnMemReturn\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnMemPlus != null : "fx:id=\"btnMemPlus\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnMemMinus != null : "fx:id=\"btnMemMinus\" was not injected: check your FXML file 'sample.fxml'.";

    }

    void equalAction() {

        if (this.operation == '+' || this.operation == '-' || this.operation == '/' || this.operation == '*') {
            float res = 0;
            switch (this.operation) {
                case '+':
                    res = this.firstNum + Float.parseFloat(this.stringNum);
                    break;
                case '-':
                    res = this.firstNum - Float.parseFloat(this.stringNum);
                    break;
                case '*':
                    res = this.firstNum * Float.parseFloat(this.stringNum);
                    break;
                case '/':
                    if (Float.parseFloat(this.stringNum) != 0) {
                        res = this.firstNum / Float.parseFloat(this.stringNum);
                    } else res = 0;
                    break;
            }
            labelField.setText(Float.toString(res));
            this.operation = 'E';
            this.firstNum = 0;
            this.stringNum = "";
        }
    }

    void mathAction(char operation) {
        if (this.operation != '+' && this.operation != '-' && this.operation != '/' && this.operation != '*') {
            this.firstNum = Float.parseFloat(this.stringNum);
            labelField.setText(String.valueOf(operation));
            this.stringNum = "";
            this.operation = operation;
        }
    }

    void addNumber(int number) {
        this.stringNum += Integer.toString(number);
        labelField.setText(this.stringNum);
    }
}
