import java.awt.*;

public class Score {

    private final Paddle p1;
    private final Paddle p2;
    private final int MAX_SCORE = 5;

    public Score(Paddle p1, Paddle p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 48));

        g.drawLine(500, 0, 500, 600);

        g.drawString(String.valueOf(p1.score), 450, 60);
        g.drawString(String.valueOf(p2.score), 540, 60);

        g.setFont(new Font("Consolas", Font.BOLD, 30));

        if (p1.score == MAX_SCORE - 1 && p2.score < MAX_SCORE - 1) {
            g.drawString("MATCH POINT PLAYER 1!", 300, 120);
        } else if (p2.score == MAX_SCORE - 1 && p1.score < MAX_SCORE - 1) {
            g.drawString("MATCH POINT PLAYER 2!", 300, 120);
        }
    }
}