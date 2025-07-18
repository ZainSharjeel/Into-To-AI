import java.util.*;
public class NQueensProblem {
    // Greedy Best First Search
    public static Node greedyBestFirstSearch(State startState) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        frontier.add(new Node(startState, null, 0, startState.heuristic()));
        int statesExplored = 0;

        Set<State> explored = new HashSet<>();

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (!explored.contains(currentNode.state)) {
                statesExplored++;
                explored.add(currentNode.state);
            }
            if (currentNode.state.isGoal()) {
                System.out.println("States explored: " + statesExplored);
                return currentNode;
            }
            for (State successor : currentNode.state.generateSuccessors()) {
                if (!explored.contains(successor)) {
                    frontier.add(new Node(successor, currentNode, currentNode.g + 1, successor.heuristic()));
                }
            }
        }
        System.out.println("States explored: " + statesExplored);
        return null;
    }

    // A*
    public static Node aStar(State startState) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        frontier.add(new Node(startState, null, 0, startState.heuristic()));
        int statesExplored = 0;

        Set<State> explored = new HashSet<>();

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            if (!explored.contains(currentNode.state)) {
                statesExplored++;
                explored.add(currentNode.state);
            }
            if (currentNode.state.isGoal()) {
                System.out.println("States explored: " + statesExplored);
                return currentNode;
            }
            for (State successor : currentNode.state.generateSuccessors()) {
                if (!explored.contains(successor)) {
                    frontier.add(new Node(successor, currentNode, currentNode.g + 1, successor.heuristic()));
                }
            }
        }
        System.out.println("States explored: " + statesExplored);
        return null;
    }

    public static void printSolution(Node goalNode) {
        if (goalNode == null) {
            System.out.println("No solution found.");
            return;
        }
        List<State> path = new ArrayList<>();
        Node currentNode = goalNode;
        while (currentNode != null) {
            path.add(0, currentNode.state);
            currentNode = currentNode.parent;
        }
        System.out.println("Solution path:");
        for (State state : path) {
            printBoard(state.board);
            System.out.println();
        }
    }

    public static void printBoard(int[] board) {
        int n = board.length;
        for (int row : board) {
            for (int col = 0; col < n; col++) {
                if (col == row) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}