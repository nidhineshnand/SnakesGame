import java.util.ArrayList;

import static java.util.Optional.empty;

public class Snake {
    ArrayList<SnakeBlock> snake = new ArrayList<>();

    Snake(int xCoor, int yCoor, int boxSize, boolean walls){
        ArrayList<Directions> directions = new ArrayList<>();
        addBlock(xCoor, yCoor, boxSize, walls, directions);
    }

    public void addBlock(int xCoor, int yCoor, int boxSize, boolean walls, ArrayList<Directions> directions) {

        if(directions.isEmpty()){
            SnakeBlock block = new SnakeBlock(walls, boxSize, xCoor, yCoor, directions);
            snake.add(block);
        } else {
        SnakeBlock previousBlock = snake.get(snake.size() - 1);
        //Making sure that the new block is added at the right place
        switch (previousBlock.get_directions().get(0)) {
            case RIGHT:
                SnakeBlock block = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate() - 10, previousBlock.get_yCoordinate(), previousBlock.get_directions());
                snake.add(block);
                break;
            case LEFT:
                SnakeBlock block1 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate() + 10, previousBlock.get_yCoordinate(), previousBlock.get_directions());
                snake.add(block1);
                break;
            case DOWN:
                SnakeBlock block2 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate(), previousBlock.get_yCoordinate() - 10, previousBlock.get_directions());
                snake.add(block2);
                break;
            case UP:
                SnakeBlock block3 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate(), previousBlock.get_yCoordinate() + 10, previousBlock.get_directions());
                snake.add(block3);
                break;
        }
        }

        }

        //Changes the coordinates of each block so it is reflected in the move
        public void move (Directions direction){
            for (SnakeBlock block : snake) {
                block.move(direction);
            }
        }
}
