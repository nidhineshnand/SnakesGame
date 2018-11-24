import java.util.ArrayList;

import static java.util.Optional.empty;

public class Snake {
    ArrayList<SnakeBlock> snake = new ArrayList<>();
    int _boxSize;
    boolean _walls;
    Directions _directions;

    Snake(int xCoor, int yCoor, int boxSize, boolean walls){
        ArrayList<Directions> directions = new ArrayList<>();
        addBlock(xCoor, yCoor, boxSize, walls, directions);
        _boxSize = boxSize;
        _walls = walls;

    }

    public void addBlock(int xCoor, int yCoor, int boxSize, boolean walls, ArrayList<Directions> directions) {

        if(snake.isEmpty()){
            directions.add(_directions);
            SnakeBlock block = new SnakeBlock(walls, boxSize, xCoor, yCoor, directions);
            snake.add(block);
        } else{
            SnakeBlock previousBlock = snake.get(snake.size());
            ArrayList<Directions> directions1 =  new ArrayList<>();
            directions1 = previousBlock.get_directions();
            //Making sure that the new block is added at the right place
            switch (directions1.get(0)) {
                case RIGHT:
                    SnakeBlock block = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate() - 10, previousBlock.get_yCoordinate(), directions1);
                    snake.add(block);
                    block.set_saveLength(snake.size());
                    break;
                case LEFT:
                    SnakeBlock block1 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate() + 10, previousBlock.get_yCoordinate(), directions1);
                    snake.add(block1);
                    block1.set_saveLength(snake.size());
                    break;
                case DOWN:
                    SnakeBlock block2 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate(), previousBlock.get_yCoordinate() - 10, directions1);
                    snake.add(block2);
                    block2.set_saveLength(snake.size());
                    break;
                case UP:
                    SnakeBlock block3 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate(), previousBlock.get_yCoordinate() + 10, directions1);
                    snake.add(block3);
                    block3.set_saveLength(snake.size());
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

    //Checks if food is eaten by the snake
    public boolean isFoodEaten(int x, int y){
        SnakeBlock firstBlock = snake.get(0);
        if(Math.sqrt(Math.pow(x - firstBlock.get_xCoordinate(), 2) + (Math.pow(y - firstBlock.get_yCoordinate(), 2))) <= 9.8){
            ArrayList<Directions> directions = new ArrayList<>();
            addBlock(0, 0, _boxSize,_walls ,directions);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<SnakeBlock> getSnake() {
        return snake;
    }
}
