import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;

public class Main extends Application {
    Snake snake = new Snake(true, 600);
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
        Scene scene = new Scene(root, boxHeight, boxHeight + 200, Color.WHITE);

        //Creating buttons that will manage snakes
        HBox bottomButtons = new HBox();
        //Setting start button to reset the game
        Button start = new Button("Start");
        Button wall = new Button("Walls");

        snake.move(direction);
        Rectangle r = new Rectangle();
        r.setX(snake.get_xCoordinate());
        r.setY(snake.get_yCoordinate());
        r.setWidth(10);
        r.setHeight(10);

        root.getChildren().add(r);
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
}