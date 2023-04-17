package com.gfg.dsa.graph;

import java.util.ArrayList;

public class DepthFirstSearch {

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

        depthFirstSearch(adj,5, 0);
    }

    private static void depthFirstSearch(ArrayList<ArrayList<Integer>> adj, int vertices, int source) {
        boolean[] visited = new boolean[vertices];
        depthFirstSearchRec(adj, source, visited);
    }

    //pre order traversal = root, left, right
    private static void depthFirstSearchRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {
        visited[source]= true;
        System.out.print(source+" ");//printing root
        for(int vertex : adj.get(source)){
            if(!visited[vertex]){//if a node has not been visited then call DFS on that
                depthFirstSearchRec(adj, vertex, visited);//because we keep recursing, we go deep till we find the leftmost node
            }
        }
    }
}
