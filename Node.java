package ai.lab.pkg1;

public class Node {
    //Node class saves the x cordinate and y cordinate of the node, and also saves the parent of the node
    int x;
    int y;
    Node parent = null;

    //constructer
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //Set the parent
    public void setParent(Node p){
        this.parent = p;
    }

    //equals method to compare between nodes
    @Override
    public boolean equals(Object obj) {

        Node objj = new Node(0,0);
        if (obj instanceof  Node) {
            objj = (Node)obj;
        }

        if ((this.getX() == objj.getX()) && (this.getY() == objj.getY())){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }

    //toString fucnction for printing
    @Override
    public String toString() {
        return "Node(" + this.x + ", " + this.y + ")";
    }
}
