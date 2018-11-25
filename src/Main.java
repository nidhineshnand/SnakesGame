import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
    Boolean walls = false;
    Snake snakeBody = new Snake( 10, 10,600, walls);
    Directions direction;
    boolean dirChange;
    int points= 0;
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
        //VBox to colour canvas
        VBox canvasBackground = new VBox();
        canvasBackground.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        //Canvas for drawing
        Canvas canvas = new Canvas(600, 600);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        canvasBackground.getChildren().add(canvas);

        //Creating buttons that will manage snakes
        HBox bottomButtons = new HBox(20);
        //Setting start button to reset the game
        Button start = new Button("Reset");
        start.setOnAction(event -> {
            points = 0;
            snakeBody = new Snake(10, 10,600, walls);
        });
        Button wall = new Button("Walls");
        wall.setOnAction(e -> {
            walls = !walls;
            //Changing button colour to signify that walls have been turned on
            if(walls){
                wall.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
            } else {
                wall.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            }
        });
        Label score = new Label("Points: 0");

        bottomButtons.getChildren().addAll(start, wall, score);
        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(canvasBackground, bottomButtons);
        root.getChildren().add(mainContainer);

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                //Moving snakeBody by checking if the food is eaten
                Boolean eaten = snakeBody.isFoodEaten(food.get_xCoordinate(), food.get_yCoordinate());
                if(eaten){
                    food.changeFoodCoor();
                    points = points + 10;
                    score.setText("Points:" + points);
                }
                gc.clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
                if(snakeBody.move(direction) || !walls){
                    for(SnakeBlock snake : snakeBody.getSnake()) {
                        drawSnake(gc, snake);
                    }
                } else {
                    start.fire();
                    points = 0;
                }
                gc.save();
                drawFood(gc);
            }
        }.start();


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setSnakeDir(Scene scene){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
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