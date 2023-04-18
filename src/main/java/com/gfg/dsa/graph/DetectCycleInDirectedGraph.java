package com.gfg.dsa.graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,3,4);

        System.out.println(detectCycle(adj,5));
    }

    //we use DFS
    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]){//if a vertex is not visited, then call DFS recursive function on it to check if there is cycle - it will return true or false
                if(detectCycleRec(adj, i, visited, -1,recursionStack)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycleRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent,boolean[] recursionStack) {
        visited[i]= true;
        recursionStack[i]=true;//add the node to recursion stack
        for(int vertex: adj.get(i)){//for every adjacent node of i
            if(!visited[vertex]){//if a vertex is not visited then put it in recursive call and get its output
                //if the o/p is true that is if this vertex does not have a cycle beneath it, we can return true
                if(detectCycleRec(adj, vertex, visited, i,recursionStack)){
                    return true;
                }
            }else if (recursionStack[vertex]) {
                //if a vertex has been visited previously and is still part of the recursion stack then it means a cycle exists
                return true;
            }
        }
        //once out of the for loop, remove the vertex from recursion stack
        recursionStack[i]=false;
        return false;
    }

}
