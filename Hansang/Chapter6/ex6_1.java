package com.example.jad230919;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ex6_1 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private Canvas canvas;
    private double prevX, prevY;   // The previous location of the mouse, when
    // the user is drawing by dragging the mouse.
    private GraphicsContext g;  // For drawing on the canvas.

    private boolean dragging;

    public void start(Stage stage) {

        canvas = new Canvas(550,400);
        g = canvas.getGraphicsContext2D();
        clearPalette();

        canvas.setOnMousePressed( e -> mousePressed(e) );
        canvas.setOnMouseDragged( e -> mouseDragged(e) );
        canvas.setOnMouseReleased( e -> mouseReleased(e) );

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Exercise 6.1");
        stage.show();

    }

    public void mousePressed(MouseEvent evt) {

        dragging = true;

        if (dragging == false)
            return;

        if (evt.getButton() == MouseButton.SECONDARY){
            clearPalette();
        }
        else {
            int x = (int) evt.getX();   // x-coordinate where the user clicked.
            int y = (int) evt.getY();   // y-coordinate where the user clicked.

            if (evt.isShiftDown()) {
                g.setFill(Color.BLUE);
                g.fillOval(x - 30, y - 15, 60, 30);
                g.strokeOval( x - 30, y - 15, 60, 30 );
            } else {
                g.setFill(Color.RED);
                g.fillRect(x - 30, y - 15, 60, 30);
                g.strokeRect( x - 30, y - 15, 60, 30 );
            }
        }
    } // end mousePressed()

    public void clearPalette() {

        int width = (int)canvas.getWidth();    // Width of the canvas.
        int height = (int)canvas.getHeight();  // Height of the canvas.

        g.setFill(Color.WHITE);
        g.fillRect(0,0,width,height);

        }


    private void mouseDragged(MouseEvent e) {
        if (dragging == false)
            return;  // Nothing to do because the user isn't drawing.

        double x = e.getX();   // x-coordinate of mouse.
        double y = e.getY();   // y-coordinate of mouse.


        boolean isEnoughDistance = (Math.abs(prevX - x)  < 5 && Math.abs(prevY - y) < 5);
        if(isEnoughDistance){
            return;
        }

        prevX = x;
        prevY = y;

        if ( e.isShiftDown() ) {
            g.setFill( Color.BLUE );
            g.fillOval( x - 30, y - 15, 60, 30 );
            g.strokeOval( x - 30, y - 15, 60, 30 );
        }
        else {
            g.setFill( Color.RED );
            g.fillRect( x - 30, y - 15, 60, 30 );
            g.strokeRect( x - 30, y - 15, 60, 30 );
        }

    } // end mouseDragged()

    private void mouseReleased(MouseEvent e) {
        dragging = false;
    }


}
