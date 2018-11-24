import java.util.ArrayList;

public class SnakeBlock {
    private int _xCoordinate;
    private int _yCoordinate;
    private boolean _walls;
    private int _boxSize;
    private boolean wallHit =  false;
    private ArrayList<Directions> _directions = new ArrayList<>();

    SnakeBlock(boolean walls, int boxSize, int xCoordinate, int yCoordinate, ArrayList<Directions> directions){
        _walls = walls;
        _boxSize = boxSize;
        _xCoordinate = xCoordinate;
        _yCoordinate = yCoordinate;
        _directions = directions;

    }

    //Moves the snakeBody 1 step at a time
    public void move(Directions direction){
        //Adding directions to arraylist and only using the first direction
        _directions.add(direction);
        direction = _directions.get(0);

        //For initial directions call. SnakeBlock always starts with going right
        if (direction == null) {
            direction = Directions.RIGHT;
        }
        //Setting up snakeBody movement
        switch (direction) {
            case UP:
                _yCoordinate--;
                break;
            case DOWN:
                _yCoordinate++;
                break;
            case LEFT:
                _xCoordinate--;
                break;
            case RIGHT:
                _xCoordinate++;
                break;
        }

        //Checking if wall is passed through
        if (_xCoordinate <= 0) {
            _xCoordinate = _boxSize;
            wallHit = true;
        } else if (_xCoordinate > _boxSize) {
            _xCoordinate = 0;
            wallHit = true;
        }

        if (_yCoordinate <= 0) {
            _yCoordinate = _boxSize;
            wallHit = true;
        } else if (_yCoordinate > _boxSize) {
            _yCoordinate = 0;
            wallHit = true;
        }

        //Removing the oldest direction that is used
        _directions.remove(0);
    }




    //Method checks if one of the wall has been hit
    public boolean hasWallBeenHit(){
        if(!_walls || !wallHit){
            return false;
        } else{
            return true;
        }
    }

    //Method checks if the snakeBody has eaten the food
    public boolean isFoodEaten(int xFood, int yFood){
        if(xFood == _xCoordinate && yFood == _yCoordinate){
            return true;
        } else {
            return false;
        }
    }

    public int get_xCoordinate() {
        return _xCoordinate;
    }

    public int get_yCoordinate() {
        return _yCoordinate;
    }

    public ArrayList<Directions> get_directions() {
        return _directions;
    }
}
