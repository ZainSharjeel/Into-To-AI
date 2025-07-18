public class Main {
    public static void main(String[] args) {
        int[] startBoard = {1, 0, 2, 1}; // Initial state
        State startState = new State(startBoard);

        System.out.println("Greedy Best First Search:");
        Node greedyBestFirstSearchResult = NQueensProblem.greedyBestFirstSearch(startState);
        NQueensProblem.printSolution(greedyBestFirstSearchResult);

        System.out.println("\nA*:");
        Node aStarResult = NQueensProblem.aStar(startState);
        NQueensProblem.printSolution(aStarResult);
    }
}