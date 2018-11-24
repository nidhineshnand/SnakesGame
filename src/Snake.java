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

    //Changes the coordinates of each block so it is reflected in the move
    public void move(Directions direction){
        for(SnakeBlock block : snake){
            block.move(direction);
        }
    }
}
