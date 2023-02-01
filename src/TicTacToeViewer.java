import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private Image[] playerImages;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final String[] axis = {"0", "1", "2"};
    private TicTacToe t;
    private Square[][] board;

    public TicTacToeViewer(TicTacToe t, Square[][] board) {
        this.t = t;
        playerImages = new Image[2];
        playerImages[0] = new ImageIcon("Resources/imageX.png").getImage();
        playerImages[1] = new ImageIcon("Resources/imageO.png").getImage();

       this.board = board;

        // Setting up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return playerImages;
    }

    public void paint(Graphics g) {
        // TODO: Write the paint method.
        // draw board
        for (int i = 200; i < 550; i+=150) {
            for (int j = 200; j < 550; j+= 150) {
                g.drawRect(i,j, 150, 150);
            }
        }
        // draw axis
        for (int i = 0; i < 3; i++) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.drawString(axis[i], 120, 250 + 170 * i);
            g.drawString(axis[i], 250 + 170 * i, 150);
        }

        // draw players
        for (Square[] row: board) {
            for (Square s: row) {
                s.draw(g);
            }
        }

        // display winning method
        if (t.getGameOver() == true) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            if (t.getWinner() == TicTacToe.X_MARKER)
                g.drawString("Player X Wins!", 600, 750);
            else if (t.getWinner() == TicTacToe.O_MARKER)
                g.drawString("Player O Wins!", 600, 750);
            else
                g.drawString("It's a Tie!", 600, 750);
        }
    }
}
