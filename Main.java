package ai.lab.pkg1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        // the plan in 2D array
        int[][] plan = { { 0, -1, 1, 1, 1}, 
                         { 1, 1, -1, -1, 1}, 
                         { 1, 1, 1, -1, 2}};
        
        // RootNode and TargetNode finder
        Node RootNode = new Node(0,0);
        Node TargetNode = new Node(0,0);
        for (int i = 0; i < plan.length; i++) {
            for (int j = 0; j < plan[0].length; j++) {
                if (plan[i][j] == 0) {
                    RootNode = new Node(i,j);
                }
                else if (plan[i][j] == 2) {
                    TargetNode = new Node(i,j);
                }
            }
        }
        
        System.out.println("Using BFS algo to find the goal: ");
        BFS(new NodeList(plan), RootNode, TargetNode);
        
        System.out.println("-----------");
        
        System.out.println("Using DFS algo to find the goal: ");
        DFS(new NodeList(plan), RootNode, TargetNode);
    }
   
static void BFS(NodeList nodeList, Node rootNode, Node targetNode){
    
    boolean found = false;  //a flag, set true when the goal is found
    int explored = 1;  //num of explored nodes untill we reach the goal, initialized to 1 cuz we have counted the root as explored
    Queue<Node> q = new LinkedList();  //queue that the BFS uses
    q.add(rootNode);
    
    while (!q.isEmpty()){
        
        Node head = q.peek();  //saving the head of the queue
        
        if (head.equals(targetNode)) { //checks if the head is the goal
            found = true;
            ArrayList<Node> path = new ArrayList();
            System.out.println("found after " + explored + " nodes explored");
            System.out.println("Path to goal is:");
            path.add(head);
            while (head.parent != null){  // traversing back to get the goal path
                path.add(head.parent);
                head = head.parent;
            }
            for (int i = path.size()-1; i >= 0; i--) {
                System.out.println(path.get(i));
            }
            break;
        }
        else{ //if the head is not the goal then we explore more
            explored += 1;
            q.remove();
            ArrayList<Node> neigh = nodeList.Neigh(head); //getting the neighbors of the head
            for (int i = 0; i < neigh.size(); i++) {
                if (!neigh.get(i).equals(head.parent)) { //making sure we dont revisit the parent of the head
                    q.add(neigh.get(i));
                }
            }
        }
    }
    if (found == false) { //if found flag is still false after the q is empty that means we didnt reach the goal
            System.out.println("FAILURE");
    }
}

static void DFS(NodeList nodeList, Node rootNode, Node targetNode){
    
    boolean found = false;  //a flag, set true when the goal is found
    int explored = 1;  //num of explored nodes untill we reach the goal, initialized to 1 cuz we have counted the root as explored
    Stack<Node> stk = new Stack<>(); //stack that the dfs uses
    ArrayList visited = new ArrayList(); //added a visited array to avoid getting stuck in infinite loops
    stk.add(rootNode);
    
    while (!stk.isEmpty()){
        
        Node head = stk.peek();  //saving the head of the stack
        
        if (head.equals(targetNode)) { //checks if the head is the goal
            found = true;
            ArrayList<Node> path = new ArrayList();
            System.out.println("found after " + explored + " nodes explored");
            System.out.println("Path to goal is:");
            path.add(head);
            while (head.parent != null){  // traversing back to get the goal path
                path.add(head.parent);
                head = head.parent;
            }
            for (int i = path.size()-1; i >= 0; i--) {
                System.out.println(path.get(i));
            }
            break;
        }
        else{ //if the head is not the goal then we explore more
            explored += 1;
            stk.pop();
            ArrayList<Node> neigh = nodeList.Neigh(head); //getting the neighbors of the head
            for (int i = neigh.size()-1; i >= 0; i--) {
                if ((!neigh.get(i).equals(head.parent))) { //making sure we dont revisit the parent of the head
                    if (!visited.contains(neigh.get(i))) {
                        stk.add(neigh.get(i));
                        visited.add(neigh.get(i));
                    }
                }
            }
        }
    }
    if (found == false) { //if found flag is still false after the stk is empty that means we didnt reach the goal
            System.out.println("FAILURE");
    }
}
}
