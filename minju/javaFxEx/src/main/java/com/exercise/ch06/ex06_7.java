package com.exercise.ch06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ex06_7 extends Application {
    public static void main(String[] args) {
        launch();
    }

    private StatCalc stats;
    private TextField numberInput;
    private Button enterButton;
    private Button clearButton;
    private Label message;
    private Label countLabel;
    private Label sumLabel;
    private Label meanLabel;
    private Label standevLabel;

    @Override
    public void start(Stage stage) throws Exception {
        stats = new StatCalc();

        numberInput = new TextField();
        numberInput.setPrefColumnCount(8);

        enterButton = new Button("Enter");
        enterButton.setOnAction(e -> doEnter());
        enterButton.setMaxSize(1000, 1000);
        enterButton.setDefaultButton(true);
        clearButton = new Button("Clear");
        clearButton.setOnAction(e -> doClear());
        clearButton.setMaxSize(1000, 1000);

        countLabel = makeLabel(" Number of Entries:  0");
        sumLabel = makeLabel(" Sum:                0.0");
        meanLabel = makeLabel(" Average:            undefined");
        standevLabel = makeLabel(" Standard Deviation: undefined");

        message = new Label("Enter a number, press return:");
        message.setFont(Font.font(16));
        message.setTextFill(Color.WHITE);

        TilePane inputPanel = new TilePane(3, 3, numberInput, enterButton, clearButton);
        inputPanel.setPrefColumns(3);
        TilePane root = new TilePane(3, 3, message, inputPanel, countLabel, sumLabel, meanLabel, standevLabel);
        root.setPrefColumns(1);
        root.setStyle("-fx-border-color:black; " +
                "-fx-border-width:3; -fx-background-color:black");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Calc GUI");
        stage.setResizable(false);
        stage.show();
    }

    private Label makeLabel(String text) {
        Label label = new Label(text);
        label.setMaxSize(1000, 1000);
        label.setStyle("-fx-background-color:white; " +
                "-fx-font-family: monospace; -fx-font-weight: bold");
        return label;
    }

    private void doClear() {
        stats = new StatCalc();
        message.setText("Enter a number, press return:");
        numberInput.setText("");
        showData();
    }

    private void doEnter() {
        double number;
        message.setText("Enter a number, press return:");
        try {
            number = Double.parseDouble(numberInput.getText());
        } catch (NumberFormatException e) {
            message.setText("\"" + numberInput.getText() + "\" is not a legal number.");
            numberInput.clear();
            numberInput.requestFocus();
            return;
        }
        stats.enter(number);
        showData();
        numberInput.clear();
    }

    private void showData() {
        countLabel.setText(" Number of Entries:  " + stats.getCount());
        sumLabel.setText(" Sum:                " + stats.getSum());
        try {
            meanLabel.setText(" Average:            " + stats.getMean());
        } catch (IllegalArgumentException e) {
            meanLabel.setText(" Average:            undefined");
        }
        try {
            standevLabel.setText(" Standard Deviation: " + stats.getStandardDeviation());
        } catch (IllegalArgumentException e) {
            standevLabel.setText(" Standard Deviation: undefined");
        }
    }


}
