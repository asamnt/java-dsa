package com.gfg.dsa.graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph {

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
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]){//if a vertex is not visited, then call DFS recursive function on it to check if there is cycle - it will return true or false
                if(detectCycleRec(adj, i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycleRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent) {
        visited[i]= true;
        for(int vertex: adj.get(i)){
            if(!visited[vertex]){//if a vertex is not visited then put it in recursive call and get its output
                //if the o/p is true that is if this vertex does not have a cycle beneath it, we can return true
                if(detectCycleRec(adj, vertex, visited, i)){
                    return true;
                }
            }else if (vertex!=parent) {
                //if a vertex has been visited previously and now it is again being visited but is not the parent of the current vertex, then it is a cycle
                return true;
            }
        }
        return false;
    }



}
