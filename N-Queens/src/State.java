import java.util.*;

class State {
    int[] board;

    public State(int[] board) {
        this.board = Arrays.copyOf(board, board.length);
    }

    // Heuristic function: number of queens attacking each other
    public int heuristic() {
        int h = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = i + 1; j < board.length; j++) {
                if (board[i] == board[j] || Math.abs(board[i] - board[j]) == Math.abs(i - j)) {
                    h++;
                    break;
                }
            }
        }
        return h;
    }


    public List<State> generateSuccessors() {
        List<State> successors = new ArrayList<>();
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[col] != row) {
                    int[] successorBoard = Arrays.copyOf(board, board.length);
                    successorBoard[col] = row;
                    successors.add(new State(successorBoard));
                }
            }
        }
        return successors;
    }

    public boolean isGoal() {
        return heuristic() == 0;
    }
}