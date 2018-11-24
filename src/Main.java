import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
    Snake snakeBody = new Snake( 10, 10,600, false);
    Boolean walls;
    Directions direction;
    boolean dirChange;
    Food food = new Food(600);
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
                //Moving snakeBody by checking if the food is eaten
                Boolean eaten = snakeBody.isFoodEaten(food.get_xCoordinate(), food.get_yCoordinate());
                if(eaten){
                    food.changeFoodCoor();
                }
                gc.clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
                snakeBody.move(direction);
                for(SnakeBlock snake : snakeBody.getSnake()) {
                    drawSnake(gc, snake);
                }
                gc.save();
                drawFood(gc);
            }
        }.start();


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setSnakeDir(Scene scene){
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:   direction = Directions.UP; dirChange = true; break;
                case RIGHT: direction = Directions.RIGHT;dirChange = true; break;
                case DOWN:  direction = Directions.DOWN;dirChange = true; break;
                case LEFT:  direction = Directions.LEFT;dirChange = true; break;
            }
        });
    }

    //Method draws snakeBody on canvas
    private void drawSnake(GraphicsContext gc, SnakeBlock snake) {
            gc.setFill(Color.BLACK);
            gc.fillRect(snake.get_xCoordinate(), snake.get_yCoordinate(), 10, 10);
            gc.setFill(Color.GREEN);
            gc.setStroke(Color.BLUE);

    }

    //Method draws snakeBody on canvas
    private void drawFood(GraphicsContext gc) {
            gc.setFill(Color.GREEN);
            gc.fillRect(food.get_xCoordinate(), food.get_yCoordinate(), 10, 10);
            gc.setFill(Color.GREEN);
            gc.setStroke(Color.BLUE);
    }
}