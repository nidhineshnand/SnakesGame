public class Snake {
    int _length;
    int _xCoordinate;
    int _yCoordinate;
    boolean _walls;
    int _boxSize;

    Snake(boolean walls, int boxSize){
        _walls = walls;
        _boxSize = boxSize;

    }

    //Gets the length of the snake for drawing
    public int get_length() {
        return _length;
    }

    //Adds a value to the length of the snake
    public void addOne(){
        _length++;
    }

    //Moves the snake 1 step at a time
    public void move(){}
}
