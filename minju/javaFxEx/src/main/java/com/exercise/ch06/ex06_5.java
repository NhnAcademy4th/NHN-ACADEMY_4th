package com.exercise.ch06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex06_5 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private int selectedRow = -1;
    private int selectedColumn = -1;

    @Override
    public void start(Stage stage) throws Exception {
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext g = canvas.getGraphicsContext2D();
        drawBoard(g, 400, 400);
        canvas.setOnMousePressed(e -> mousePressed(g, e, 400, 400));
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Checker Board");
        stage.setResizable(false);
        stage.show();
    }

    private void drawBoard(GraphicsContext g, int width, int height) {

        g.setFill(Color.RED);
        g.fillRect(0, 0, width, height);
        g.setFill(Color.BLACK);

        for (int i = 0; i < width / 50; i++) {
            for (int j = 0; j < height / 50; j++) {
                if ((i + j) % 2 == 0) {
                    g.fillRect(i * 50, j * 50, 50, 50);
                }
            }
        }
    }

    private void mousePressed(GraphicsContext g, MouseEvent event, int width, int height) {
        g.setStroke(Color.rgb(50, 200, 140));
        g.setLineWidth(3);

        int row = (int) (event.getX() / 50);
        int column = (int) (event.getY() / 50);

        drawBoard(g, width, height);

        if (selectedRow == row && selectedColumn == column) {
            selectedRow = -1;
            selectedColumn = -1;
        } else {
            selectedRow = row;
            selectedColumn = column;
            g.strokeRect(row * 50 + 1.5, column * 50 + 1.5, 47, 47);
        }
    }
}
