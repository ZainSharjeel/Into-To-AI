import java.util.ArrayList;

public class Node {
    public int id;
    public String data;
    public ArrayList<Node> children = new ArrayList<Node> ();

    public Node ( int id , String data){
        this.id=id;
        this.data=data;
    }
}
