import java.util.ArrayList;


public class Snake {
    ArrayList<SnakeBlock> snake = new ArrayList<>();
    int _boxSize;
    boolean _walls;
    ArrayList<Directions> moves = new ArrayList<>();

    Snake(int xCoor, int yCoor, int boxSize, boolean walls){
        addBlock(xCoor, yCoor, boxSize, walls);
        _boxSize = boxSize;
        _walls = walls;

    }

    public void addBlock(int xCoor, int yCoor, int boxSize, boolean walls) {

        if(snake.isEmpty()){
            moves.add(Directions.RIGHT);
            SnakeBlock block = new SnakeBlock(walls, boxSize, xCoor, yCoor);
            snake.add(block);
        } else{
            SnakeBlock previousBlock = snake.get(snake.size() - 1);
            //Making sure that the new block is added at the right place
            switch (moves.get(moves.size() - 1)) {
                case RIGHT:
                    SnakeBlock block = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate() - 10, previousBlock.get_yCoordinate());
                    snake.add(block);
                    break;
                case LEFT:
                    SnakeBlock block1 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate() + 10, previousBlock.get_yCoordinate());
                    snake.add(block1);
                    break;
                case DOWN:
                    SnakeBlock block2 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate(), previousBlock.get_yCoordinate() - 10);
                    snake.add(block2);
                    break;
                case UP:
                    SnakeBlock block3 = new SnakeBlock(walls, boxSize, previousBlock.get_xCoordinate(), previousBlock.get_yCoordinate() + 10);
                    snake.add(block3);
                    break;
            }
        }


    }

    //Changes the coordinates of each block so it is reflected in the move
    public void move (Directions direction){
        moves.add(0, direction);
        int counter = 0;
        for (SnakeBlock block : snake) {
            block.move(moves.get(counter*10));
            counter++;
        }
        if(moves.size() > snake.size()*10 + 1) {
            moves.remove(moves.size() - 1);
        }
    }

    //Checks if food is eaten by the snake
    public boolean isFoodEaten(int x, int y){
        SnakeBlock firstBlock = snake.get(0);
        if(Math.sqrt(Math.pow(x - firstBlock.get_xCoordinate(), 2) + (Math.pow(y - firstBlock.get_yCoordinate(), 2))) <= 9.8){
            addBlock(0, 0, _boxSize,_walls );
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<SnakeBlock> getSnake() {
        return snake;
    }
}
