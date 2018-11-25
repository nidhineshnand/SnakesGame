import java.util.ArrayList;

public class SnakeBlock {
    private int _xCoordinate;
    private int _yCoordinate;
    private boolean _walls;
    private int _boxSize;
    private int _saveLength;
    private boolean wallHit = false;
    private ArrayList<Directions> moves;

    SnakeBlock(boolean walls, int boxSize, int xCoordinate, int yCoordinate) {
        _walls = walls;
        _boxSize = boxSize;
        _xCoordinate = xCoordinate;
        _yCoordinate = yCoordinate;

    }

    //Moves the snakeBody 1 step at a time
    public void move(Directions direction) {

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

    }


    //Method checks if one of the wall has been hit
    public boolean hasWallBeenHit() {
        if (!_walls || !wallHit) {
            return false;
        } else {
            return true;
        }
    }


    public int get_xCoordinate() {
        return _xCoordinate;
    }

    public int get_yCoordinate() {
        return _yCoordinate;
    }

    public ArrayList<Directions> get_directions() {
        return moves;
    }

    public int get_saveLength(){
        return _saveLength;
    }
}
