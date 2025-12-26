package w14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = 600;
    private static final Dimension SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    private static final int BALL_SIZE = 20;
    private static final int PADDLE_W = 25;
    private static final int PADDLE_H = 100;

    private static final int MAX_SCORE = 5; // ➜ Batas skor

    private Paddle p1, p2;
    private Ball ball;
    private Score score;
    private Thread loopThread;
    private boolean gameOver = false;

    public GamePanel() {
        setPreferredSize(SIZE);
        setFocusable(true);
        addKeyListener(new KeyHandler());
        setBackground(Color.BLACK);

        initObjects();

        loopThread = new Thread(this);
        loopThread.start();
    }

    private void initObjects() {
        p1 = new Paddle(0, GAME_HEIGHT / 2 - PADDLE_H / 2, PADDLE_W, PADDLE_H, 1);
        p2 = new Paddle(GAME_WIDTH - PADDLE_W, GAME_HEIGHT / 2 - PADDLE_H / 2, PADDLE_W, PADDLE_H, 2);

        ball = new Ball(GAME_WIDTH / 2 - BALL_SIZE / 2, GAME_HEIGHT / 2 - BALL_SIZE / 2, BALL_SIZE);

        score = new Score(p1, p2);
    }

    @Override
    public void run() {
        final int targetFPS = 60;
        final double nsPerTick = 1_000_000_000.0 / targetFPS;

        double delta = 0;
        long last = System.nanoTime();

        while (true) {
            long now = System.nanoTime();
            delta += (now - last) / nsPerTick;
            last = now;

            if (delta >= 1) {
                if (!gameOver)
                    updateGame();
                repaint();
                delta--;
            }
        }
    }

    private void updateGame() {
        p1.update();
        p2.update();
        ball.update();

        checkCollisions();
    }

    private void checkCollisions() {

        if (ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_SIZE)
            ball.bounceY();

        if (ball.intersects(p1)) {
            ball.bounceX();
            ball.accelerate();
        }

        if (ball.intersects(p2)) {
            ball.bounceX();
            ball.accelerate();
        }

        if (p1.y < 0)
            p1.y = 0;
        if (p1.y > GAME_HEIGHT - PADDLE_H)
            p1.y = GAME_HEIGHT - PADDLE_H;

        if (p2.y < 0)
            p2.y = 0;
        if (p2.y > GAME_HEIGHT - PADDLE_H)
            p2.y = GAME_HEIGHT - PADDLE_H;

        if (ball.x <= 0) {
            p2.score++;
            checkWinner();
            resetBall();
        }

        if (ball.x >= GAME_WIDTH - BALL_SIZE) {
            p1.score++;
            checkWinner();
            resetBall();
        }
    }

    private void checkWinner() {
        if (p1.score >= MAX_SCORE || p2.score >= MAX_SCORE) {
            gameOver = true;
        }
    }

    private void resetBall() {
        ball.x = GAME_WIDTH / 2 - BALL_SIZE / 2;
        ball.y = GAME_HEIGHT / 2 - BALL_SIZE / 2;
        ball.resetSpeed();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        p1.render(g);
        p2.render(g);
        ball.render(g);
        score.draw(g);

        if (gameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 60));

            String text;
            if (p1.score >= MAX_SCORE)
                text = "PLAYER 1 WINS!";
            else
                text = "PLAYER 2 WINS!";

            g.drawString(text, GAME_WIDTH / 2 - 250, GAME_HEIGHT / 2);

            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Press R to Restart", GAME_WIDTH / 2 - 150, GAME_HEIGHT / 2 + 50);
        }
    }

    private void restartGame() {
        p1.score = 0;
        p2.score = 0;
        gameOver = false;
        resetBall();
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (gameOver && e.getKeyCode() == KeyEvent.VK_R)
                restartGame(); // ➜ tombol restart
            p1.keyPressed(e);
            p2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            p1.keyReleased(e);
            p2.keyReleased(e);
        }
    }
}