package com.exercise.ch06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ex06_8 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private TextArea textInput;
    private Label linesLabel;
    private Label wordsLabel;
    private Label charsLabel;

    Button countButton;

    @Override
    public void start(Stage stage) throws Exception {
        textInput = new TextArea();
        textInput.setPrefRowCount(15);
        textInput.setPrefColumnCount(30);

        countButton = new Button("Process the Text");
        countButton.setOnAction(e -> processInput());

        String style = "-fx-padding: 5px; -fx-font: bold 14pt serif; -fx-background-color: white";

        linesLabel = new Label(" Number of lines: ");
        linesLabel.setStyle(style);
        linesLabel.setMaxWidth(1000);

        wordsLabel = new Label(" Number of words: ");
        wordsLabel.setStyle(style);
        wordsLabel.setMaxWidth(1000);

        charsLabel = new Label(" Number of chars: ");
        charsLabel.setStyle(style);
        charsLabel.setMaxWidth(1000);

        VBox root = new VBox(4, textInput, new BorderPane(countButton),
                linesLabel, wordsLabel, charsLabel);
        root.setStyle("-fx-background-color: #009; -fx-border-color: #009; -fx-border-width: 3px");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Line/Word/Char Counter");
        stage.setResizable(false);
        stage.show();
    }

    private void processInput() {
        String text = textInput.getText();
        int chars = text.length();
        int lines = 1;
        int words = 0;

        boolean isWord = true;
        for (int i = 0; i < chars; i++) {
            char character = text.charAt(i);
            if (character == '\n') {
                isWord = true;
                lines++;
            }
            if (Character.isLetter(character) && isWord) {
                words++;
                isWord = false;
            }
            if (character == ' ') {
                isWord = true;
            }
        }

        linesLabel.setText(" Number of lines: " + lines);
        wordsLabel.setText(" Number of words: " + words);
        charsLabel.setText(" Number of chars: " + chars);

    }
}
