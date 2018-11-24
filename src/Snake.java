import java.util.ArrayList;

public class Snake {
    ArrayList<SnakeBlock> snake = new ArrayList<>();

    Snake(int xCoor, int yCoor, int boxSize, boolean walls){
        startSnake(xCoor, yCoor, boxSize, walls);
    }

    public void addBlock(){

    }

    private void startSnake(int xCoor, int yCoor, int boxSize, boolean walls){
        SnakeBlock block1 = new SnakeBlock(walls, boxSize, xCoor, yCoor);
        snake.add(block1);
    }
}
