package com.exercise.ch06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex06_1 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private boolean dragging = false;
    private double prevX;
    private double prevY;

    @Override
    public void start(Stage stage) {
        int vector = 500;
        Canvas canvas = new Canvas(vector, vector);
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, vector, vector);
        g.setStroke(Color.BLACK);

        canvas.setOnMouseClicked(e -> mousePressed(g, e));
        canvas.setOnMouseDragged(e -> mouseDragged(g, e));

        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-color: black; -fx-border-width: 2px");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mouse Drag Demo");
        stage.setResizable(false);
        stage.show();
    }

    public void mousePressed(GraphicsContext g, MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            dragging = false;
            g.setFill(Color.WHITE);
            g.fillRect(0, 0, 500, 500);
            return;
        }
        dragging = true;

        prevX = event.getX();
        prevY = event.getY();

        if (event.isShiftDown()) {
            fillBlueOval(g, prevX, prevY);
        } else {
            fillRedRect(g, prevX, prevY);
        }
    }

    public void mouseDragged(GraphicsContext g, MouseEvent event) {
        if (!dragging) {
            return;
        }

        double x = event.getX();
        double y = event.getY();

        if (Math.abs(prevX - x) < 5 || Math.abs(prevY - y) < 5) {
            return;
        }

        prevX = x;
        prevY = y;

        if (event.isShiftDown()) {
            fillBlueOval(g, x, y);
        } else {
            fillRedRect(g, x, y);
        }
    }

    private static void fillBlueOval(GraphicsContext g, double x, double y) {
        g.setFill(Color.BLUE);
        g.fillOval(x - 30, y - 15, 60, 30);
        g.strokeOval(x - 30, y - 15, 60, 30);
    }

    private static void fillRedRect(GraphicsContext g, double x, double y) {
        g.setFill(Color.RED);
        g.fillRect(x - 30, y - 15, 60, 30);
        g.strokeRect(x - 30, y - 15, 60, 30);
    }
}
