import java.util.Random;

public class Randomizer {
    private static final Random rand = new Random();

    public static int nextInt(int max) {
        return rand.nextInt(max);
    }

    public static double nextDouble() {
        return rand.nextDouble();
    }
}