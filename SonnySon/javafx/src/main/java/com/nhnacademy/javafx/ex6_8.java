package com.nhnacademy.javafx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ex6_8 extends Application {
    private Label numberOfLines;
    private Label numberOfWords;
    private Label numberOfChars;
    private Button processBtn;
    private TextArea textArea;
    
    private void doEnter(){
        String inputData = null;

        int numberOfChars = 0;
        int numberOfWords = 1;
        int numberOfLines = 1;

        inputData = textArea.getText();

        if(inputData == null){
            showData(0,0,0);
            return;
        }

        for(char c : inputData.toCharArray()){
            if(c ==32){
                numberOfWords++;
            } else if (c == '\n') {
                numberOfLines++;
                numberOfWords++;
            }else{
                numberOfChars++;
            }
        }
        showData(numberOfLines,numberOfWords,numberOfChars);
    }
    private void showData(int lines, int words,int chars){
        numberOfLines.setText("Number of Lines : "+lines);
        numberOfWords.setText("Number of Words : "+words);
        numberOfChars.setText("Number of Chars : "+chars);

    }

    @Override
    public void start(Stage stage) {

        textArea = new TextArea("Input some txt");
        textArea.setPrefColumnCount(15);
        textArea.setPrefRowCount(8);
        processBtn = new Button("Process the Text");

        processBtn.setOnAction(e -> doEnter());
        processBtn.setMaxSize(1000,1000);
        processBtn.setDefaultButton(true);

        numberOfLines = makeLabel("Number Of Lines");
        numberOfWords = makeLabel("Number Of Words");
        numberOfChars = makeLabel("Number Of Chars");

        VBox root = new VBox(4,textArea,new BorderPane(processBtn),numberOfLines,numberOfWords,numberOfChars);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Line/Word/Char Counter");
        stage.setResizable(false);
        stage.show();
    }

    public Label makeLabel(String text){
        Label label = new Label(text);
        label.setMaxWidth(1000);
        label.setStyle("-fx-background-color: white; "+
                "-fx-font-family: monospace;"+"-fx-font-weight: bold");
        return label;
    }

}
