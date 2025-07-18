import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private JLabel infoLabel;
    private JLabel scoreLabel;
    private JCheckBox aiCheckBox;
    private boolean isPlayerX = true;
    private boolean gameActive = true;
    private int[] board = new int[9];
    private static final int EMPTY = -1;
    private static final int X = 1;
    private static final int O = 0;
    private Random random = new Random();
    private int scoreX = 0;
    private int scoreO = 0;
    private int scoreDraw = 0;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initBoard();
        initUI();
        setVisible(true);
        JOptionPane.showMessageDialog(this, "Welcome to Tic Tac Toe Game", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void initUI() {
        JPanel topPanel = new JPanel(new BorderLayout());
        infoLabel = new JLabel("Let's play Tic Tac Toe", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        topPanel.add(infoLabel, BorderLayout.NORTH);

        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(230, 57, 70));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(e -> resetAll());
        topPanel.add(resetButton, BorderLayout.WEST);

        scoreLabel = new JLabel("", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 10));
        updateScoreLabel();
        topPanel.add(scoreLabel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = createButton(i, j);
                boardPanel.add(buttons[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        aiCheckBox = new JCheckBox("Turn on AI");
        aiCheckBox.setFont(new Font("Verdana", Font.PLAIN, 12));
        aiCheckBox.setForeground(new Color(0, 191, 255));
        add(aiCheckBox, BorderLayout.SOUTH);
    }

    private JButton createButton(int row, int col) {
        JButton button = new JButton("");
        button.setFont(new Font("Arial", Font.BOLD, 50));
        button.setFocusPainted(false);
        button.addActionListener(e -> fill(row, col));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE); // Set default foreground color to white
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2));

        // Check if it's X or O based on the current board state
        if (board[row * 3 + col] == X) {
            button.setForeground(new Color(255, 0, 0)); // For X, set color to bright red
        } else if (board[row * 3 + col] == O) {
            button.setForeground(new Color(255, 255, 0)); // For O, set color to bright yellow
        }

        return button;
    }


    private void initBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = EMPTY;
        }
    }

    private void fill(int i, int j) {
        if (!gameActive || board[i * 3 + j] != EMPTY) return;
        board[i * 3 + j] = isPlayerX ? X : O;
        buttons[i][j].setText(isPlayerX ? "X" : "O");
        buttons[i][j].setEnabled(false);
        isPlayerX = !isPlayerX;
        infoLabel.setText(isPlayerX ? "It is X's turn" : "It is O's turn");
        if (checkIfGameEnded()) return;
        if (aiCheckBox.isSelected()) aiMove();
    }

    private void aiMove() {
        int[] move = findBestMove(board, O);
        int moveIndex = -1;
        for (int i = 0; i < 9; i++) {
            if (board[i] != move[i]) {
                moveIndex = i;
                break;
            }
        }
        if (moveIndex != -1) {
            board[moveIndex] = O;
            buttons[moveIndex / 3][moveIndex % 3].setText("O");
            buttons[moveIndex / 3][moveIndex % 3].setEnabled(false);
            isPlayerX = !isPlayerX;
            infoLabel.setText(isPlayerX ? "It is X's turn" : "It is O's turn");
            checkIfGameEnded();
        }
    }

    private boolean checkIfGameEnded() {
        int[] winCombo = hasWon(board);
        if (winCombo != null) {
            String winner = board[winCombo[0]] == X ? "Player X" : "Player O";
            JOptionPane.showMessageDialog(this, winner + " has won!", "Info", JOptionPane.INFORMATION_MESSAGE);
            if (board[winCombo[0]] == X)
                scoreX++;
            else
                scoreO++;
            updateScoreLabel();
            gameActive = false;
            return true;
        }
        if (isDraw(board)) {
            JOptionPane.showMessageDialog(this, "Game is drawn!!", "Info", JOptionPane.INFORMATION_MESSAGE);
            scoreDraw++;
            updateScoreLabel();
            gameActive = false;
            return true;
        }
        return false;
    }


    private void updateScoreLabel() {
        scoreLabel.setText("Score - X: " + scoreX + " O: " + scoreO + " Draw: " + scoreDraw);
    }

    private void resetAll() {
        gameActive = true;
        isPlayerX = true;
        infoLabel.setText("Let's play Tic Tac Toe");
        initBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(new Color(52, 152, 219));
                buttons[i][j].setForeground(Color.WHITE);
            }
        }
        updateScoreLabel();
    }


    private boolean isDraw(int[] board) {
        for (int i : board) {
            if (i == EMPTY) return false;
        }
        return true;
    }

    private int[] hasWon(int[] board) {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] combo : winningCombinations) {
            if (board[combo[0]] == board[combo[1]] && board[combo[1]] == board[combo[2]] && board[combo[0]] != EMPTY) {
                return combo;
            }
        }
        return null;
    }

    private int[] findBestMove(int[] board, int player) {
        int[] bestMove = board.clone();
        int bestScore = (player == X) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            if (board[i] == EMPTY) {
                board[i] = player;
                int score = minimax(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                board[i] = EMPTY;
                if (player == X && score < bestScore) {
                    bestScore = score;
                    bestMove = board.clone();
                    bestMove[i] = player;
                } else if (player == O && score > bestScore) {
                    bestScore = score;
                    bestMove = board.clone();
                    bestMove[i] = player;
                }
            }
        }
        return bestMove;
    }

    private int minimax(int[] board, int depth, boolean isMaximizing, int alpha, int beta) {
        int[] winCombo = hasWon(board);
        if (winCombo != null) return board[winCombo[0]] == O ? 1 : -1;
        if (isDraw(board)) return 0;

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == EMPTY) {
                    board[i] = O;
                    int eval = minimax(board, depth + 1, false, alpha, beta);
                    board[i] = EMPTY;
                    maxEval = Math.max(maxEval, eval);
                    alpha = Math.max(alpha, eval);
                    if (beta <= alpha) break;
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == EMPTY) {
                    board[i] = X;
                    int eval = minimax(board, depth + 1, true, alpha, beta);
                    board[i] = EMPTY;
                    minEval = Math.min(minEval, eval);
                    beta = Math.min(beta, eval);
                    if (beta <= alpha) break;
                }
            }
            return minEval;
        }
    }
}
