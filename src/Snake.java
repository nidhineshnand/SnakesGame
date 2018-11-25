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
            SnakeBlock block = new SnakeBlock(boxSize, xCoor, yCoor);
            snake.add(block);
        } else{
            int right = 0;
            int left = 0;
            int up = 0;
            int down = 0;
            //Making sure that the new block is added at the right place by looking at the last 10 moves of the last
            //block in the snake body
            for(Directions dir : moves.subList(moves.size() - 10, moves.size())){
                switch (dir) {
                    case RIGHT:
                        right++;
                        break;
                    case LEFT:
                        left++;
                        break;
                    case DOWN:
                        down++;
                        break;
                    case UP:
                        up++;
                        break;
                }
            }
            SnakeBlock lastBlock = snake.get(snake.size()-1);
            SnakeBlock block = new SnakeBlock( boxSize, lastBlock.get_xCoordinate() + (left - right), lastBlock.get_yCoordinate() + (up - down));
            snake.add(block);

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
        if(moves.size() > snake.size()*10) {
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
