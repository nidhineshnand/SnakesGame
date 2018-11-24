import java.util.Random;

public class Food {
    private int _xCoordinate;
    private int _yCoordinate;
    private int _boxSize;

    Food(int boxSize){
        _boxSize = boxSize;
    }

    //Method gets random coordinate for the food
    public int getFoodCoor(){
        Random rand = new Random();
        return rand.nextInt(_boxSize);
    }
}
