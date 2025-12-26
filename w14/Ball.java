import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {

    private int xSpeed;
    private int ySpeed;
    private final int baseSpeed = 4;
    private final Random rng = new Random();

    public Ball(int x, int y, int d) {
        super(x, y, d, d);
        randomizeDirection();
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
    }

    public void bounceX() {
        xSpeed = -xSpeed;
    }

    public void bounceY() {
        ySpeed = -ySpeed;
    }

    public void accelerate() {
        if (xSpeed > 0)
            xSpeed++;
        else
            xSpeed--;

        if (ySpeed > 0)
            ySpeed++;
        else
            ySpeed--;
    }

    private void randomizeDirection() {
        xSpeed = rng.nextBoolean() ? baseSpeed : -baseSpeed;
        ySpeed = rng.nextBoolean() ? baseSpeed : -baseSpeed;
    }

    public void resetSpeed() {
        randomizeDirection();
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }
}