package com.exercise.ch06;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex06_4 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private Canvas canvas;
    private Button rollButton;
    private long startTime;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            int dice1 = (int) (Math.random() * 6) + 1;
            int dice2 = (int) (Math.random() * 6) + 1;
            draw(dice1, dice2);
            if (time - startTime >= 1_000_000_000) {
                timer.stop();
                rollButton.setDisable(false);
            }
        }
    };

    @Override
    public void start(Stage stage) throws Exception {
        canvas = new Canvas(100, 100);
        draw(4, 3);

        rollButton = new Button("roll");
        rollButton.setMaxWidth(1000);
        rollButton.setOnAction(e -> roll());

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(rollButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice");
        stage.setResizable(false);
        stage.show();

    }

    private void roll() {
        rollButton.setDisable(true);
        startTime = System.nanoTime();
        timer.start();
    }

    private void drawDie(GraphicsContext g, int dice, double x, double y) {
        g.setFill(Color.WHITE);
        g.fillRect(x, y, 35, 35);
        g.setStroke(Color.BLACK);
        g.strokeRect(x + 0.5, y + 0.5, 34, 34);
        g.setFill(Color.BLACK);
        if (dice > 1)  // upper left dot
        {
            g.fillOval(x + 3, y + 3, 9, 9);
        }
        if (dice > 3)  // upper right dot
        {
            g.fillOval(x + 23, y + 3, 9, 9);
        }
        if (dice == 6) // middle left dot
        {
            g.fillOval(x + 3, y + 13, 9, 9);
        }
        if (dice % 2 == 1) // middle dot (for odd-numbered val's)
        {
            g.fillOval(x + 13, y + 13, 9, 9);
        }
        if (dice == 6) // middle right dot
        {
            g.fillOval(x + 23, y + 13, 9, 9);
        }
        if (dice > 3)  // bottom left dot
        {
            g.fillOval(x + 3, y + 23, 9, 9);
        }
        if (dice > 1)  // bottom right dot
        {
            g.fillOval(x + 23, y + 23, 9, 9);
        }
    }

    private void draw(int dice1, int dice2) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(200, 200, 255));
        g.fillRect(0, 0, 100, 100);
        g.setStroke(Color.BLUE);
        g.strokeRect(1, 1, 98, 98);

        drawDie(g, dice1, 10, 10);
        drawDie(g, dice2, 55, 55);
    }

}
