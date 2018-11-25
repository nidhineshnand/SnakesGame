import java.util.ArrayList;


public class Snake {
    ArrayList<SnakeBlock> snake = new ArrayList<>();
    int _boxSize;
    boolean _walls;
    ArrayList<Directions> moves = new ArrayList<>();

    Snake(int xCoor, int yCoor, int boxSize, boolean walls){
        ArrayList<Directions> directions = new ArrayList<>();
        addBlock(xCoor, yCoor, boxSize, walls, directions);
        _boxSize = boxSize;
        _walls = walls;

    }

    public void addBlock(int xCoor, int yCoor, int boxSize, boolean walls, ArrayList<Directions> directions) {

        if(snake.isEmpty()){
            moves.add(Directions.RIGHT);
            SnakeBlock block = new SnakeBlock(walls, boxSize, xCoor, yCoor);
            snake.add(block);
        } else{
            SnakeBlock previousBlock = snake.get(snake.size());
            //Making sure that the new block is added at the right place
            switch (moves.get(previousBlock.get_saveLength() - 1)) {
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

        moves.remove(0);


    }

    //Changes the coordinates of each block so it is reflected in the move
    public void move (Directions direction){
        moves.add(direction);
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
