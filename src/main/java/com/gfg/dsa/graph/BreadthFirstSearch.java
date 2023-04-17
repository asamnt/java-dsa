package com.gfg.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

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

        breadthFirstSearch(adj,5, 0);
    }

    //level order traversal but maintain array visited to not add the same node again
    public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int vertices, int source){
        boolean[] visited = new boolean[vertices+1];//we maintain this array to make sure we dont revisit a visited node
        Queue<Integer> q = new LinkedList<Integer>();
        visited[source] = true;
        q.add(source);
        while(!q.isEmpty()){//just like level order traversal, we pop each node from the queue and then add its children to queue
            int u = q.poll();
            System.out.print(u+" ");
            for (int v : adj.get(u)){//we take out the arraylist at the first index of the array list and iterate through it to visit the adjacent neighbours
                if(!visited[v]){//if the neighbour has been visited then we dont add it to the queue as it would be already present or processed
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
