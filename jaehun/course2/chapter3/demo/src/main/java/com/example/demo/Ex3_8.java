package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This file can be used to draw simple pictures.  Just fill in
 * the definition of drawPicture with the code that draws your picture.
 */
public class Ex3_8 extends Application {
    public void drawPicture(GraphicsContext g, int width, int height) {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 400, 400);
        g.setFill(Color.RED);
        for(int i=0;i<400;i+=50){
            if(i%100==0) {
                for (int j = 0; j < 400; j += 100) {
                    g.fillRect(j, i, 50, 50);
                }
            }else{
                for(int j=50;j<400;j+=100){
                    g.fillRect(j,i,50,50);
                }
            }
        }
;    } // end drawPicture()

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public void start(Stage stage) {
        int width = 400;   // The width of the image.  You can modify this value!
        int height = 400;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width, height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
//        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
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