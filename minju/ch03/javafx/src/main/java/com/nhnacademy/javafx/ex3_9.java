package com.nhnacademy.javafx;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ex3_9 extends Application {
    public void drawFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height);

        int cycleFrameNumber = frameNumber % 300;
        g.setFill(Color.RED);
        g.fillRect(cycleFrameNumber, 0, 20, 20);

        cycleFrameNumber = frameNumber % 150;
        g.setFill(Color.BLUE);
        g.fillRect(cycleFrameNumber * 2, 20, 20, 20);

        cycleFrameNumber = frameNumber % 100;
        g.setFill(Color.YELLOW);
        g.fillRect(cycleFrameNumber * 3, 40, 20, 20);

        int oscillationFrameNumber = frameNumber % 600;
        if (oscillationFrameNumber > 300) {
            oscillationFrameNumber = 600 - oscillationFrameNumber;
        }
        g.setFill(Color.RED);
        g.fillRect(oscillationFrameNumber, 60, 20, 20);

        oscillationFrameNumber = frameNumber % 300;
        if (oscillationFrameNumber > 150) {
            oscillationFrameNumber = 300 - oscillationFrameNumber;
        }
        g.setFill(Color.BLUE);
        g.fillRect(oscillationFrameNumber * 2, 80, 20, 20);

        oscillationFrameNumber = frameNumber % 200;
        if (oscillationFrameNumber > 100) {
            oscillationFrameNumber = 200 - oscillationFrameNumber;
        }
        g.setFill(Color.YELLOW);
        g.fillRect(oscillationFrameNumber * 3, 100, 20, 20);
    }

    public void start(Stage stage) {
        int width = 320;
        int height = 120;
        Canvas canvas = new Canvas(width, height);
        drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Animation"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;

            public void handle(long now) {
                if (startTime < 0) {
                    startTime = previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
                } else if (now - previousTime > 0.95e9 / 60) {
                    // The test in the else-if is to make sure that drawFrame() is
                    // called about once every 1/60 second.  It is required since
                    // handle() can be called by the system more often than that.
                    frameNum++;
                    drawFrame(canvas.getGraphicsContext2D(), frameNum, (now - startTime) / 1e9, width, height);
                    previousTime = now;
                }
            }
        };
        anim.start();
    }

    public static void main(String[] args) {
        launch();
    }

}
