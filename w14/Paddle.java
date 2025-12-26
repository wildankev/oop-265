import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {

    public int score = 0;

    private final int playerId;
    private int velocityY = 0;
    private final int moveSpeed = 10;

    public Paddle(int x, int y, int w, int h, int id) {
        super(x, y, w, h);
        this.playerId = id;
    }

    public void update() {
        y += velocityY;
    }

    public void setDirection(int dir) {
        velocityY = dir;
    }

    public void keyPressed(KeyEvent e) {
        if (playerId == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W)
                setDirection(-moveSpeed);
            if (e.getKeyCode() == KeyEvent.VK_S)
                setDirection(moveSpeed);
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                setDirection(-moveSpeed);
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                setDirection(moveSpeed);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (playerId == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
                setDirection(0);
        } else {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                setDirection(0);
        }
    }

    public void render(Graphics g) {
        g.setColor(playerId == 1 ? Color.CYAN : Color.MAGENTA);
        g.fillRect(x, y, width, height);
    }
}