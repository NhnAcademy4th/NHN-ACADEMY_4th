package com.exercise.ch06;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ex06_6 extends Application {

    public static void main(String[] args) {
        launch();
    }

    private AnimationTimer timer;
    private final int width = 640, height = 480;

    private Boat boat;
    private Bomb bomb;
    private Submarine sub;
    private Canvas canvas;
    private Stage stage;

    private int hit = 0;
    private int miss = 0;

    @Override
    public void start(Stage stage) throws Exception {
        boat = new Boat();
        sub = new Submarine();
        bomb = new Bomb();

        canvas = new Canvas(width, height);

        this.stage = stage;

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sub Killer -- Use arrow keys to play!");
        stage.setResizable(false);

        scene.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();
            if (code == KeyCode.LEFT) {
                boat.centerX -= 15;
            } else if (code == KeyCode.RIGHT) {
                boat.centerX += 15;
            } else if (code == KeyCode.DOWN) {
                if (bomb.isFalling == false) {
                    bomb.isFalling = true;
                }
            }
        });

        stage.focusedProperty().addListener((obj, oldVal, newVal) -> {
            if (newVal) {
                timer.start();
            } else {
                timer.stop();
            }
            draw();
        });

        timer = new AnimationTimer() {
            long previousFrameTime;

            @Override
            public void handle(long time) {
                if (time - previousFrameTime > 0.99e9 / 60) {
                    boat.updateForNewFrame();
                    bomb.updateForNewFrame();
                    sub.updateForNewFrame();
                    draw();
                    previousFrameTime = time;
                }
            }
        };

        stage.show();
        timer.start();
    }

    public void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();

        g.setFill(Color.rgb(150, 200, 50));
        g.fillRect(0, 0, width, height);

        if (stage.isFocused()) {
            g.setStroke(Color.CYAN);
        } else {
            g.setFill(Color.BLACK);
            g.fillText("(ANIMATION PAUSED)", 100, 30);
            g.setStroke(Color.DARKGRAY);
        }

        g.setFill(Color.BLACK);
        g.fillText("hit : " + hit, 20, 30);
        g.fillText("miss : " + miss, 20, 60);

        g.setLineWidth(3);
        g.strokeRect(1.5, 1.5, width - 3, height - 3);

        boat.draw(g);
        sub.draw(g);
        bomb.draw(g);
    }


    private class Boat {
        int centerX, centerY;

        Boat() {
            centerX = width / 2;
            centerY = 80;
        }

        void updateForNewFrame() {
            if (centerX < 0) {
                centerX = 0;
            } else if (centerX > width) {
                centerX = width;
            }
        }

        void draw(GraphicsContext g) {
            g.setFill(Color.BLUE);
            g.fillRoundRect(centerX - 40, centerY - 20, 80, 40, 20, 20);
        }
    }

    private class Bomb {
        int centerX, centerY;
        boolean isFalling;

        Bomb() {
            isFalling = false;
        }

        void updateForNewFrame() {
            if (isFalling) {
                if (centerY > height) {
                    miss++;
                    isFalling = false;
                } else if (Math.abs(centerX - sub.centerX) <= 36 &&
                        Math.abs(centerY - sub.centerY) <= 21) {
                    hit++;
                    sub.isExploding = true;
                    sub.explosionFrameNumber = 1;
                    isFalling = false;
                } else {
                    centerY += 6;
                }
            }
        }

        void draw(GraphicsContext g) {
            if (!isFalling) {
                centerX = boat.centerX;
                centerY = boat.centerY + 23;
            }
            g.setFill(Color.RED);
            g.fillOval(centerX - 8, centerY - 8, 16, 16);
        }
    }

    private class Submarine {
        int centerX, centerY;
        boolean isMovingLeft;
        boolean isExploding;
        int explosionFrameNumber;


        Submarine() {
            centerX = (int) (width * Math.random());
            centerY = height - 40;
            isExploding = false;
            isMovingLeft = (Math.random() < 0.5);
        }

        void updateForNewFrame() {
            if (isExploding) {
                explosionFrameNumber++;
                if (explosionFrameNumber == 25) {
                    centerX = (int) (width * Math.random());
                    centerY = height - 40;
                    isExploding = false;
                    isMovingLeft = (Math.random() < 0.5);
                }
            } else {
                if (Math.random() < 0.02) {
                    isMovingLeft = !isMovingLeft;
                }
                if (isMovingLeft) {
                    centerX -= 3;
                    if (centerX <= 0) {
                        centerX = 0;
                        isMovingLeft = false;
                    }
                } else {
                    centerX += 3;
                    if (centerX > width) {
                        centerX = width;
                        isMovingLeft = true;
                    }
                }
            }
        }

        void draw(GraphicsContext g) {
            g.setFill(Color.BLACK);
            g.fillOval(centerX - 30, centerY - 15, 60, 30);
            if (isExploding) {
                g.setFill(Color.YELLOW);
                g.fillOval(centerX - 3 * explosionFrameNumber,
                        centerY - 1.5 * explosionFrameNumber,
                        6 * explosionFrameNumber,
                        3 * explosionFrameNumber);
                g.setFill(Color.RED);
                g.fillOval(centerX - 1.5 * explosionFrameNumber,
                        centerY - explosionFrameNumber / 2,
                        3 * explosionFrameNumber,
                        explosionFrameNumber);

            }
        }
    }
}

