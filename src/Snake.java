public class Snake {
    int _length;
    int _xCoordinate;
    int _yCoordinate;
    boolean _walls;
    int _boxSize;
    boolean wallHit =  false;

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
}
