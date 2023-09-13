package com.nhnacademy.javafx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ex3_8 extends Application {


    public void drawPicture(GraphicsContext g, int width, int height) {

        g.setFill(Color.RED);
        g.fillRect(0, 0, width, height);

        g.setFill(Color.BLACK);
        for (int i = 0; i < width / 50; i++) {
            for (int j = 0; j < height / 50; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    g.fillRect(i * 50, j * 50, 50, 50);
                }
                if (i % 2 == 1 && j % 2 == 1) {
                    g.fillRect(i * 50, j * 50, 50, 50);
                }
            }

        }

        g.fillRect(0, 0, 50, 50);


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
        stage.setTitle("Checkerboard");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

}