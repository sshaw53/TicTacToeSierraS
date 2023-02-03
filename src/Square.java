/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */
import java.awt.*;

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToeViewer board;
    private Image playerX, playerO;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer board) {
        this.board = board;
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        // Initializing images in Square
//        playerX = board.getImages()[0];
//        playerO = board.getImages()[1];
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        // check if winning
        if (this.isWinningSquare == true) {
            g.setColor(Color.GREEN);
            g.fillRect(col * 150 + 200, row * 150 + 200, 150, 150);
        }
        // draw character based on the marker
        if (marker.equals(TicTacToe.X_MARKER))
            g.drawImage(board.getImages()[0], col * 150 + 200, row * 150 + 200, 150, 150, board);
        else if (marker.equals(TicTacToe.O_MARKER))
            g.drawImage(board.getImages()[1], col * 150 + 200, row * 150 + 200, 150, 150, board);
    }
}
