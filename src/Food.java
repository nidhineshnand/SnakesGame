import java.util.Random;

public class Food {
    private int _xCoordinate;
    private int _yCoordinate;
    private int _boxSize;

    Food(int boxSize){
        _boxSize = boxSize;
        changeFoodCoor();
    }

    //Method gets random coordinate for the food
    public void changeFoodCoor(){
        Random rand = new Random();
        _xCoordinate = rand.nextInt(_boxSize);
        Random rand1 = new Random();
        _yCoordinate = rand1.nextInt(_boxSize);
    }

    public int get_xCoordinate() {
        return _xCoordinate;
    }

    public int get_yCoordinate() {
        return _yCoordinate;
    }
}
