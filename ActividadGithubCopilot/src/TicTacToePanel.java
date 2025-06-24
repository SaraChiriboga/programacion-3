// TicTacToePanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToePanel extends JPanel {
    private final int MARGIN = 20;
    private final JButton[][] buttons = new JButton[3][3];
    private final TicTacToeGame game = new TicTacToeGame();
    private final JLabel statusLabel = new JLabel("Turn: X");

    public TicTacToePanel() {
        setLayout(new BorderLayout());
        // Set preferred size for the panel to ensure buttons are large enough
        setPreferredSize(new Dimension(400, 500));
        setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        JPanel grid = new JPanel(new GridLayout(3, 3, 10, 10));
        Font font = new Font("Arial", Font.BOLD, 48);

        // Crear botones para el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFont(font);
                btn.setFocusPainted(false);
                btn.setBackground(new Color(240, 240, 255));
                int row = i, col = j;
                btn.addActionListener(e -> handleMove(row, col));
                buttons[i][j] = btn;
                grid.add(btn);
            }
        }

        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(statusLabel, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);

        JButton resetBtn = new JButton("Reiniciar");
        resetBtn.addActionListener(e -> resetGame());
        add(resetBtn, BorderLayout.SOUTH);
    }

    // Maneja el movimiento del jugador
    private void handleMove(int row, int col) {
        if (game.makeMove(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
            if (game.checkWin()) {
                statusLabel.setText("¡Ganó " + game.getCurrentPlayer() + "!");
                disableBoard();
            } else if (game.isDraw()) {
                statusLabel.setText("¡Empate!");
            } else {
                game.switchPlayer();
                statusLabel.setText("Turn: " + game.getCurrentPlayer());
            }
        }
    }

    // Deshabilita el tablero al terminar el juego
    private void disableBoard() {
        for (JButton[] row : buttons)
            for (JButton btn : row)
                btn.setEnabled(false);
    }

    // Reinicia el juego
    private void resetGame() {
        game.reset();
        for (JButton[] row : buttons)
            for (JButton btn : row) {
                btn.setText("");
                btn.setEnabled(true);
            }
        statusLabel.setText("Turn: X");
    }
}
