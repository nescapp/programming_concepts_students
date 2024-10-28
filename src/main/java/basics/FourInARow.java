package basics;


import java.util.Arrays;

/**
 * A class that represents a game of Four in a Row.
 * The game is played on a 6x7 board.
 * A player wins when he has 4 pieces in a row, column or diagonal.
 *
 * ForInARow is a two-player connection rack game, in which the players choose a color and
 * then take turns dropping colored tokens into a six-row, seven-column vertically suspended grid.
 * The pieces fall straight down, occupying the lowest available space within the column.
 *
 * The objective of the game is to be the first to form a horizontal,
 * vertical, or diagonal line of four of one's own tokens.
 *
 * Your taks is to model the game and implement the method hasWon(char player) that returns true.
 * if the player has won the game.
 * We advise you to model the state of the game with an internal 2D array of char.
 */
public class FourInARow {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    private static final char EMPTY = '-';
    private static final char[] PLAYERS = {'X', 'O'};

     // add your own instance variables here
    private static char[][] board = new char[ROWS][COLUMNS];

    // Constructor
    public FourInARow() {
         // add your own code here
        for (int i = 0; i < ROWS; i++) {
            Arrays.fill(board[i], EMPTY);
        }
    }

    public String toString() {
        // add your own code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isValidPlayer(char player) {
        // checking player validity
        boolean validPlayer = false;
        for (char sureValidPlayer: PLAYERS) {
            if (sureValidPlayer == player) {
                validPlayer = true;
                break;
            }
        }
        return validPlayer;
    }

    /**
     * Play a piece in column j for the given player.
     * @param j the column index
     * @param player the player (X or O)
     * @throws IllegalArgumentException if j is not a valid column index or if the column is full or if the player is not X or O
     */
    public void play(int j, char player) {

        // checking j
        if (j> COLUMNS) {
            throw new IllegalArgumentException("Invalid column index");
        }

        if (board[0][j] != EMPTY) {
            throw new IllegalArgumentException("Column is full");
        }

        // checking player validity
        if (!isValidPlayer(player)) {
            throw new IllegalArgumentException("Invalid player");
        }

        // play
        int emptyRow = ROWS-1;
        while (board[emptyRow][j] != EMPTY && emptyRow>0) {
            emptyRow--;
        }
        board[emptyRow][j] = player;
    }


    /**
     * Returns true if the player has won the game.
     * @param player the player (X or O)
     * @return true if the player has won the game
     * @throws IllegalArgumentException if the player is not X or O
     */
    public boolean hasWon(char player) {
        // checking player validity
        if (!isValidPlayer(player)) {
            throw new IllegalArgumentException("Invalid player");
        }

        // horizontal
        for (int i = 0; i < ROWS; i++) {
            int counterForRows = 0;
            for (int j = 1; j < COLUMNS; j++) {
                if (board[i][j] == player && board[i][j-1] == player) {
                    counterForRows++;
                    if (counterForRows>=3) {
                        return true;
                    }
                } else {
                    counterForRows = 0;
                }
            }
        }

        //vertical
        for (int j = 0; j < COLUMNS; j++) {
            int counterForColumns = 0;
            for (int i = 1; i < ROWS; i++) {
                if (board[i][j] == player && board[i-1][j] == player) {
                    counterForColumns++;
                    if (counterForColumns >= 3) {
                        return true;
                    }
                } else {
                    counterForColumns = 0;
                }
            }
        }

        //diagonal (lost sanity here)
        for (int i = 1; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == player) {
                    // down right diagonal
                    if (j+1 < COLUMNS && i+1 < ROWS && board[i+1][j+1] == player) {
                        if (j+2 < COLUMNS && i+2 < ROWS && board[i+2][j+2] == player) {
                            if (j+3 < COLUMNS && i+3 < ROWS && board[i+3][j+3] == player) {
                                return true;
                            }
                        }
                    }
                    // down left diagonal
                    if (j-1 >= 0 && i+1 < ROWS && board[i+1][j-1] == player) {
                        if (j-2 >= 0 && i+2 < ROWS && board[i+2][j-2] == player) {
                            if (j-3 >= 0 && i+3 < ROWS && board[i+3][j-3] == player) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
