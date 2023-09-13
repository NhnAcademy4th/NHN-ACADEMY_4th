package com.nhnacademy.javafx;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  This file can be used to draw simple pictures.  Just fill in
 *  the definition of drawPicture with the code that draws your picture.
 */
public class ex3_8 extends Application {

    /**
     * Draws a picture.  The parameters width and height give the size
     * of the drawing area, in pixels.
     */
    public void drawPicture(GraphicsContext g) {

        double boxSize = 50;

        for(int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){
                if((i % 2 == 0 && j % 2 == 0)||(i % 2 != 0 && j % 2 != 0)){
                    g.setFill(Color.RED);
                    g.fillRect(boxSize*i, boxSize*j, boxSize * i + 50, boxSize * j + 50);
                }else{
                    g.setFill(Color.BLACK);
                    g.fillRect(boxSize*i, boxSize*j, boxSize * i + 50, boxSize * j + 50);
                }
            }
        }
    } // end drawPicture()

    public void start(Stage stage) {
        int width = 400;   // The width of the image.  You can modify this value!
        int height = 400;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D());
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Graphics"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

} // end SimpleGraphicsStarter