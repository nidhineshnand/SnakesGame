import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class Main extends Application {
    Snake snake = new Snake(true, 600, 10, 10   );
    Boolean walls;
    Directions direction;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("");
        Group root = new Group();
        int boxHeight = 600;
        Scene scene = new Scene(root, boxHeight, boxHeight + 100, Color.WHITE);

        //Making sure that arrow keys change directions
        setSnakeDir(scene);
        //Canvas for drawing
        Canvas canvas = new Canvas(600, 600);
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        //Creating buttons that will manage snakes
        HBox bottomButtons = new HBox();
        //Setting start button to reset the game
        Button start = new Button("Start");
        Button wall = new Button("Walls");
        root.getChildren().add(canvas);

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                //Moving snake
                snake.move(direction);
                gc.clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
                drawSnake(gc);
            }
        }.start();


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setSnakeDir(Scene scene){
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:   direction = Directions.UP; break;
                case RIGHT: direction = Directions.RIGHT; break;
                case DOWN:  direction = Directions.DOWN; break;
                case LEFT:  direction = Directions.LEFT; break;
            }
        });
    }

    //Method draws snake on canvas
    private void drawSnake(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(snake.get_xCoordinate(), snake.get_yCoordinate(), 10, 10);
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);

    }
}