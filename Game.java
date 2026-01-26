import java.util.Random;

public class Game {
    private int smallestNumber;
    private int largestNumber;
    private int secretNumber;
    private int attempts;

    public Game(int min, int max) {
        setRange(min, max);
        resetNumberGame();
    }

    public void setRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El mínimo debe ser menor que el máximo.");
        }
        this.smallestNumber = min;
        this.largestNumber = max;
    }

    public void resetNumberGame() {
        Random random = new Random();
        secretNumber = random.nextInt(largestNumber - smallestNumber + 1) + smallestNumber;
        attempts = 0;
    }

    public String checkNumber(int userNumber) {
        attempts++;

        if (userNumber < secretNumber) {
            return "El número es mayor.";
        }
        if (userNumber > secretNumber) {
            return "El número es menor.";
        }
        return "Correcto! Intentos: " + attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getSmallestNumber() {
        return smallestNumber;
    }

    public int getLargestNumber() {
        return largestNumber;
    }

}
