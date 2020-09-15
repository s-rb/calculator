package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class Controller {

    private String stringNum = "";
    private BigDecimal firstNum;
    private BigDecimal secondNum;
    private char operation;

    // TODO исправить результат очень больших чесел на е в степени
    // TODO запоминать промежуточный результат. (2 + 3 = 5, далее + 4 = должо быть 9)
    public static final int SCALE = 7;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btnPercent;
    @FXML
    private Button btnClearAll;
    @FXML
    private Button btnXmultiplyX;
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
        btnClearAll.setOnAction(event -> {
            labelField.setText("0");
            this.stringNum = "";
            this.firstNum = BigDecimal.ZERO;
            this.operation = 'E';
        });
        btnXmultiplyX.setOnAction(event -> {
            String text = labelField.getText();
            squareAction(text);
        });
        btn1divByX.setOnAction(event -> {
            String text = labelField.getText();
            oneDivByXAction(text);
        });
        btnBackspace.setOnAction(event -> {
            removeNumber();
        });
    }

    private void oneDivByXAction(String text) {
        String textToShow = null;
        if (isNull(text) || "".equals(text) || text.equals("0")) {
            textToShow = "0";
        } else {
            double parseDouble = Double.parseDouble(text);
            BigDecimal x = BigDecimal.valueOf(parseDouble);
            BigDecimal res = BigDecimal.ONE.divide(x, SCALE, RoundingMode.HALF_UP);
            textToShow = getTextToShow(res);
        }

        labelField.setText(textToShow);
        this.operation = 'E';
        this.firstNum = BigDecimal.ZERO;
        this.stringNum = "";
    }

    private void squareAction(String text) {
        double parseDouble = Double.parseDouble(text);
        BigDecimal x = BigDecimal.valueOf(parseDouble);
        BigDecimal res = x.multiply(x);
        String textToShow = getTextToShow(res);

        labelField.setText(textToShow);
        this.operation = 'E';
        this.firstNum = BigDecimal.ZERO;
        this.stringNum = "";
    }

    void equalAction() {

        if (this.operation == '+' || this.operation == '-' || this.operation == '/' || this.operation == '*') {
            BigDecimal res = BigDecimal.ZERO;

            secondNum = BigDecimal.valueOf(Double.parseDouble(this.stringNum));

            switch (this.operation) {
                case '+' -> res = this.firstNum.add(secondNum);
                case '-' -> res = this.firstNum.subtract(secondNum);
                case '*' -> res = this.firstNum.multiply(secondNum);
                case '/' -> {
                    BigDecimal divisor = secondNum;
                    if (divisor.signum() != 0) {
                        res = this.firstNum.divide(divisor, SCALE, RoundingMode.HALF_UP);
                    } else {
                        res = BigDecimal.ZERO;
                    }
                }
            }

            String textToShow = getTextToShow(res);
            this.firstNum = res;
            labelField.setText(textToShow);
//            this.operation = 'E';
//            this.firstNum = BigDecimal.ZERO;
//            this.stringNum = "";
        }
    }

    private String getTextToShow(BigDecimal res) {
        if (isNull(res)) {
            return "";
        }
        String textToShow = res.toPlainString();
        if (textToShow.matches("[0-9]+[.][0-9]+[0]+")) {
            char[] chars = textToShow.toCharArray();
            int lastIndex = chars.length - 1;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != '0') {
                    break;
                }
                lastIndex--;
            }

            StringBuilder tempRes = new StringBuilder();
            for (int i = 0; i <= lastIndex; i++) {
                tempRes.append(chars[i]);
            }
            textToShow = tempRes.toString();
        }
        if (textToShow.endsWith(".")) {
            textToShow = textToShow.replaceAll("\\.", "");
        }
        return textToShow;
    }

    void mathAction(char operation) {
//        if (this.operation != '+' && this.operation != '-' && this.operation != '/' && this.operation != '*') {
            secondNum = BigDecimal.ZERO;
            firstNum = BigDecimal.valueOf(Double.parseDouble(this.stringNum));
            labelField.setText(String.valueOf(operation));
            this.stringNum = "";
            this.operation = operation;
//        }
    }

    void addNumber(int number) {
        this.stringNum += Integer.toString(number);
        labelField.setText(this.stringNum);
    }

    void removeNumber() {
        String text = labelField.getText();
        this.stringNum = text.substring(0, text.length() - 1);
        labelField.setText(this.stringNum);
    }
}
