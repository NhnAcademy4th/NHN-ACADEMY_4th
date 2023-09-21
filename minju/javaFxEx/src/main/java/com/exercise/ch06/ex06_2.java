package com.exercise.ch06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex06_2 extends Application {

    private double redX;
    private double redY;
    private double blueX;
    private double blueY;
    private double offsetX;
    private double offsetY;
    private boolean dragging;
    private boolean dragRedSquare;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(600, 500);
        setStartingPoint();
        draw(canvas);

        canvas.setOnMousePressed(e -> mousePressed(e));
        canvas.setOnMouseDragged(e -> mouseDragged(canvas, e));
        canvas.setOnMouseReleased(e -> mouseReleased(e));

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                System.out.println("press!");
                setStartingPoint();
                draw(canvas);
            }
        });

        stage.setScene(scene);
        stage.setTitle("Drag Squares");
        stage.setResizable(false);
        stage.show();

    }

    private void draw(Canvas canvas) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        g.setFill(Color.RED);
        g.fillRect(redX, redY, 100, 100);

        g.setFill(Color.BLUE);
        g.fillRect(blueX, blueY, 100, 100);
    }

    public void mousePressed(MouseEvent event) {
        if (dragging) {
            return;
        }
        double x = event.getX();
        double y = event.getY();

        if (x >= blueX && x < blueX + 100
                && y >= blueY && y < blueY + 100) {
            dragging = true;
            dragRedSquare = false;
            offsetX = x - blueX;
            offsetY = y - blueY;
        } else if (x >= redX && x < redX + 100 &&
                y >= redY && y < redY + 100) {
            dragging = true;
            dragRedSquare = true;
            offsetX = x - redX;
            offsetY = y - redY;
        }
    }

    public void mouseDragged(Canvas canvas, MouseEvent event) {
        if (!dragging) {
            return;
        }

        double x = event.getX();
        double y = event.getY();

        if (dragRedSquare) {
            redX = x - offsetX;
            redY = y - offsetY;
        } else {
            blueX = x - offsetX;
            blueY = y - offsetY;
        }
        draw(canvas);
    }

    public void mouseReleased(MouseEvent event) {
        dragging = false;
    }

    private void setStartingPoint() {
        redX = 150;
        redY = 200;
        blueX = 350;
        blueY = 200;
    }
}
