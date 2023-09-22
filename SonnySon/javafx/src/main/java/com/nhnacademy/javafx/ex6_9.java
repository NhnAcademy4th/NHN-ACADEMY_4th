package com.nhnacademy.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex6_9 extends Application {

    public static void main(String[] args) {
        launch();
    }

    Canvas canvas;

    private double[] xcoord;
    private double[] ycoord;
    private int count;

    @Override
    public void start(Stage stage) throws Exception {
        canvas = new Canvas(500,500);

        xcoord = new double[500];
        ycoord = new double[500];
        count = -1;

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Multifle Poligon");
        stage.setResizable(false);

        canvas.setOnMouseClicked(e -> mousePressed(e));

        stage.show();
    }
    public void mousePressed(MouseEvent evt){
        count++;
        xcoord[count] = evt.getX();
        ycoord[count] = evt.getY();
        draw();
    }
    public void draw(){
        GraphicsContext g = canvas.getGraphicsContext2D();

        g.setFill(Color.WHITE);
        g.fillRect(0,0,g.getCanvas().getWidth(),g.getCanvas().getHeight());

        if(count == 0){
            return;
        }

        g.setStroke(Color.BLACK);
        g.setLineWidth(5);
        for (int i = 0; i < count; i++) {
            g.strokeLine(xcoord[i],ycoord[i],xcoord[i+1],ycoord[i+1]);
        }

        g.setFill(Color.RED);
        if(count > 1){
            g.fillPolygon(xcoord,ycoord,count+1);
        }
    }
}
