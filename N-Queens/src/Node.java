class Node {
    State state;
    Node parent;
    int g; // Cost so far
    int f; // Evaluation function value (g + h)

    public Node(State state, Node parent, int g, int f) {
        this.state = state;
        this.parent = parent;
        this.g = g;
        this.f = f;
    }
}