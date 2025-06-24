// TicTacToeGame.java
public class TicTacToeGame {
    private final char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public TicTacToeGame() {
        reset();
    }

    // Intenta realizar un movimiento
    public boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    // Cambia de jugador
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Devuelve el jugador actual
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // Verifica si hay un ganador
    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            // Filas y columnas
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer))
                return true;
        }
        // Diagonales
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Verifica si hay empate
    public boolean isDraw() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ')
                    return false;
        return !checkWin();
    }

    // Reinicia el tablero
    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        currentPlayer = 'X';
    }
}
