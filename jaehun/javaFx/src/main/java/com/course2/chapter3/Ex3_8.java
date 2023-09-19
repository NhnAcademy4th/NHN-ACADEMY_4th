package com.course2.chapter3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ex3_8 extends Application {

    public void drawPicture(GraphicsContext g, int width, int height) {
        g.setFill(Color.RED);
        g.fillRect(0,0,width,height);
        g.setFill(Color.BLACK);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j)%2==1){
                    g.fillRect(j*50,i*50,50,50);
                }
            }
        }
    }

    public void start(Stage stage) {
        int width = 400;
        int height = 400;
        Canvas canvas = new Canvas(width, height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ex3.8 - draw checkerboard");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}