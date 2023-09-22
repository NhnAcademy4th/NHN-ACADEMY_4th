package com.exercise.ch06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex06_9 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private double[] xCoord, yCoord;

    private int pointCount;
    private Canvas canvas;

    private boolean complete;

    @Override
    public void start(Stage stage) throws Exception {
        xCoord = new double[500];
        yCoord = new double[500];

        canvas = new Canvas(500, 500);
        canvas.setOnMousePressed(e -> mousePressed(e));
        draw();

        StackPane root = new StackPane(canvas);
        root.setStyle("-fx-border-color: black");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Create Polygon");
        stage.setResizable(false);
        stage.show();
    }

    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (pointCount == 0) {
            return;
        }

        g.setLineWidth(2);
        g.setStroke(Color.BLACK);

        if (complete) {
            g.setFill(Color.RED);
            g.fillPolygon(xCoord, yCoord, pointCount);
            g.strokePolygon(xCoord, yCoord, pointCount);
        } else {
            g.setFill(Color.BLACK);
            g.fillRect(xCoord[0] - 2, yCoord[0] - 2, 4, 4);
            for (int i = 0; i < pointCount - 1; i++) {
                g.strokeLine(xCoord[i], yCoord[i], xCoord[i + 1], yCoord[i + 1]);
            }
        }


    }

    private void mousePressed(MouseEvent event) {
        if (complete) {
            complete = false;
            xCoord[0] = event.getX();
            yCoord[0] = event.getY();
            pointCount = 1;
        } else if (pointCount > 0 && pointCount > 0 && (Math.abs(xCoord[0] - event.getX()) <= 3)
                && (Math.abs(yCoord[0] - event.getY()) < 3)) {
            complete = true;
        } else if (event.getButton() == MouseButton.SECONDARY || pointCount == 500) {
            complete = true;
        } else {
            xCoord[pointCount] = event.getX();
            yCoord[pointCount] = event.getY();
            pointCount++;
        }
        draw();
    }
}
