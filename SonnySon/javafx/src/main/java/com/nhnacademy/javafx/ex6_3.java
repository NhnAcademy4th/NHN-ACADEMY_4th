package com.nhnacademy.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex6_3 extends Application {
    public static void main(String[] args) {
        launch();
    }

    private int die1 = 4;
    private int die2 = 3;
    private Canvas canvas;
    private Button rollButton;
    private long elapsedTime;

    private long startTime;
    private AnimationTimer timer = new AnimationTimer(){
        public void handle(long time){
            die1 = (int)(Math.random() * 6) +1;
            die2 = (int)(Math.random() * 6) +1;
            draw();
            if(time - startTime >= 1000000000){
                timer.stop();
                rollButton.setDisable(false);
            }
        }
    };

    @Override
    public void start(Stage stage) throws Exception {
        canvas = new Canvas(100,100);
        draw();

        rollButton = new Button("Roll");
        rollButton.setMaxWidth(1000);
        rollButton.setOnAction(e -> roll());

        BorderPane root = new BorderPane(canvas);
        root.setCenter(canvas);
        root.setBottom(rollButton);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Dice");
        stage.setResizable(false);
        stage.show();

    }

    private void drawDie(GraphicsContext g, int val, int x , int y){
        g.setFill(Color.WHITE);
        g.fillRect(x,y,35,35);

        g.setStroke(Color.BLACK);
        g.strokeRect(x + 0.5,y + 0.5,34,34);

        g.setFill(Color.BLACK);

        if (val > 1)  // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (val > 3)  // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (val == 6) // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (val == 6) // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (val > 3)  // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (val > 1)  // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }

    private void roll(){
        rollButton.setDisable(true);
        startTime = System.nanoTime();
        timer.start();
    }
    private void draw(){
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(200,200,255));
        g.fillRect(0,0,100,100);
        g.setStroke( Color.BLUE );
        g.setLineWidth(2);
        g.strokeRect(1,1,98,98);
        drawDie(g, die1, 10, 10);
        drawDie(g, die2, 55, 55);
    }
}
