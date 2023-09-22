package com.nhnacademy.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class ex6_1 extends Application {

    public static void main(String[] args) {
        launch();
    }

    // --------------------------------------------------------------------------------

    private GraphicsContext canvasGraphics;
    private double prevShapeX;
    private double prevShapeY;
    private boolean dragging;

    public void start(Stage stage) {
        /* Create the canvas, and set up the GUI */

        Canvas canvas = new Canvas(550,400);

        canvasGraphics = canvas.getGraphicsContext2D();
        canvasGraphics.setFont( Font.font(18) );
        canvasGraphics.setFill(Color.WHITE);
        canvasGraphics.fillRect(0,0,550,400);
        canvasGraphics.setStroke(Color.BLACK);

        canvas.setOnMousePressed( e -> mousePressed(e) );
        canvas.setOnMouseDragged( e -> mouseDragged(e) );

        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-color: black; -fx-border-width: 2px");

        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.setTitle("Mouse Event Info");
        stage.setResizable(false);
        stage.show();

    }

    public void mousePressed(MouseEvent event){
        // SECONDARY == 오른쪽 클릭
        if(event.getButton() == MouseButton.SECONDARY){
            dragging = false;
            canvasGraphics.setFill(Color.WHITE);
            canvasGraphics.fillRect(0,0,500,380);
            return;
        }
        dragging = true;

        double x = event.getX();
        double y = event.getY();

        prevShapeX = x;
        prevShapeY = y;

        if(event.isShiftDown()){
            canvasGraphics.setFill(Color.BLUE);
        }else{
            canvasGraphics.setFill(Color.RED);
        }
        canvasGraphics.fillRect(x - 30, y - 15, 60, 30);
        canvasGraphics.strokeRect(x - 30, y - 15, 60, 30);
    }

    public void mouseDragged(MouseEvent event){
        if(!dragging){
            return;
        }
        double x = event.getX();
        double y = event.getY();

        if(Math.abs(x - prevShapeX) < 5 && Math.abs(y - prevShapeY) < 5){
            return ;
        }

        prevShapeX = x;
        prevShapeY = y;

        if(event.isShiftDown()) {
            canvasGraphics.setFill(Color.BLUE);
        }else{
            canvasGraphics.setFill(Color.RED);
        }
        canvasGraphics.fillRect(x-30,y-15,60,30);
        canvasGraphics.strokeRect(x-30,y-15,60,30);

    }
}