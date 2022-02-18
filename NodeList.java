package ai.lab.pkg1;

import java.util.*;

public class NodeList {
    //NodeList class takes a 2D array plan and converts it into ArrayList of class Node
    int[][] plan;
    ArrayList<Node> nodes = new ArrayList<Node>();

    public NodeList(int[][] plan) {
        this.plan = plan;
        for (int i = 0; i < plan.length; i++) {
            for (int j = 0; j < plan[0].length; j++) {
                Node node = new Node(i,j);
                nodes.add(node);
            }
        }
    }

    //returns an arraylist with all the neighbors of a certain node and its parent
    public ArrayList<Node> Neigh(Node n){

        ArrayList<Node> NeighList = new ArrayList<Node>();

        if (plan[n.x][n.y] == -1) {
            System.out.println("this node is a (-1) node, you cant be here");
            return null;
        }
        //left neigh
        if ((n.y) != (0)) {
            if (plan[n.x][n.y-1] != -1) {
                Node temp = new Node(n.x, n.y-1);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //right neigh
        if ((n.y) != (plan[0].length - 1)) {
            if (plan[n.x][n.y+1] != -1) {
                Node temp = new Node(n.x, n.y+1);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //up neigh
        if ((n.x) != (0)) {
            if (plan[n.x-1][n.y] != -1) {
                Node temp = new Node(n.x-1, n.y);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //down neigh
        if ((n.x) != (plan.length - 1)) {
            if (plan[n.x+1][n.y] != -1) {
                Node temp = new Node(n.x+1, n.y);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //up right neigh
        if (((n.x) != (0)) && ((n.y) != (plan[0].length - 1))) {
            if (plan[n.x-1][n.y+1] != -1) {
                Node temp = new Node(n.x-1, n.y+1);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //down right neigh
        if (((n.x) != (plan.length - 1)) && ((n.y) != (plan[0].length - 1))) {
            if (plan[n.x+1][n.y+1] != -1) {
                Node temp = new Node(n.x+1, n.y+1);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //up left neigh
        if (((n.x) != (0)) && ((n.y) != (0))) {
            if (plan[n.x-1][n.y-1] != -1) {
                Node temp = new Node(n.x-1, n.y-1);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        //down left neigh
        if (((n.x) != (plan.length - 1)) && ((n.y) != (0))) {
            if (plan[n.x+1][n.y-1] != -1) {
                Node temp = new Node(n.x+1, n.y-1);
                temp.setParent(n);
                NeighList.add(temp);
            }
        }
        return NeighList;
    }

    //returns an arraylist of the cost of all the neighbors of a certain node
    public ArrayList<Float> k(Node n){

        ArrayList<Float> cost = new ArrayList<>();
        ArrayList<Node> nlist = Neigh(n);
        int x = n.getX();
        int y = n.getY();

        for (int i = 0; i < nlist.size(); i++) {
            if ((x == (nlist.get(i).x)+1 && y == (nlist.get(i).y)) ||
                (x == (nlist.get(i).x)-1 && y == (nlist.get(i).y)) ||
                (y == (nlist.get(i).y)+1 && x == (nlist.get(i).x)) ||
                (y == (nlist.get(i).y)-1 && x == (nlist.get(i).x))) {
                cost.add(1.0f);//horizontal move cost
            }
            else{
                cost.add(1.41f);//diagonal move cost
            }
        }
        return cost;
    }
}
