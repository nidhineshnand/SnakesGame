public class Snake {
    int _length = 3;
    int _xCoordinate;
    int _yCoordinate;
    boolean _walls;
    int _boxSize;
    boolean wallHit =  false;
    int points;

    Snake(boolean walls, int boxSize){
        _walls = walls;
        _boxSize = boxSize;

    }

    //Adds a value to the length of the snake
    public void addOne(){
        _length++;
    }

    //Moves the snake 1 step at a time
    public void move(Directions direction){
        //Setting up snake movement
        switch(direction){
            case UP: _yCoordinate++;
                break;
            case DOWN: _yCoordinate--;
                break;
            case LEFT: _xCoordinate--;
                break;
            case RIGHT: _xCoordinate++;
                break;
        }

        //Checking if wall is passed through
        if(_xCoordinate <= 0){
            _xCoordinate = _boxSize;
            wallHit = true;
        } else if(_xCoordinate > _boxSize){
            _xCoordinate = 0;
            wallHit = true;
        }

        if(_yCoordinate <= 0){
            _yCoordinate = _boxSize;
            wallHit = true;
        } else if(_yCoordinate > _boxSize){
            _yCoordinate = 0;
            wallHit = true;
        }
    }


    //Method checks if one of the wall has been hit
    public boolean hasWallBeenHit(){
        if(!_walls || !wallHit){
            return false;
        } else{
            return true;
        }
    }

    //Method checks if the snake has eaten the food
    public boolean isFoodEaten(int xFood, int yFood){
        if(xFood == _xCoordinate && yFood == _yCoordinate){
            addOne();
            return true;
        } else {
            return false;
        }
    }
}
