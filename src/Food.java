import java.util.Random;

public class Food {
    private int _xCoordinate;
    private int _yCoordinate;
    private int _boxSize;

    Food(int boxSize){
        _boxSize = boxSize;
    }

    //Method gets random coordinate for the food
    public void changeFoodCoor(){
        Random rand = new Random();
        _xCoordinate = rand.nextInt(_boxSize);
        Random rand1 = new Random();
        _yCoordinate = rand1.nextInt(_boxSize);
    }
}
