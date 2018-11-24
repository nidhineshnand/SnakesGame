import java.util.ArrayList;

public class Snake {
    ArrayList<SnakeBlock> snake = new ArrayList<>();

    Snake(int xCoor, int yCoor, int boxSize, boolean walls){
        ArrayList<Directions> directions = new ArrayList<>();
        addBlock(xCoor, yCoor, boxSize, walls, directions);
    }

    public void addBlock(int xCoor, int yCoor, int boxSize, boolean walls, ArrayList<Directions> directions){
        SnakeBlock block = new SnakeBlock(walls, boxSize, xCoor, yCoor, directions);
        snake.add(block);
    }
}
