package com.gfg.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//directed acyclic graph, nodes as jobs and directed edges as dependency
public class TopologicalSorting {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u){
//        adj.get(u).add(v);
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

        System.out.println("The following is a Topological Sort");
        topologicalSort(adj, v);
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int vertices) {
        //create indegree array
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for(int x : adj.get(i)){//for each adjacent node of the vertex
                inDegree[x]++;//as many times this node x is adjacent to other nodes(here adjacent means there is an incoming edge), this will get incremented
            }
        }

        Queue<Integer> q = new LinkedList<>();
        //add all 0 indegree vertices to q by default - these nodes have no dependency so can be printed immediately
        for (int i = 0; i < vertices; i++) {
            if(inDegree[i]==0)
                q.add(i);
        }

        //now do BFS
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            for(int v : adj.get(u)){
                --inDegree[v];//as you visit the adjacent node, reduce its indegree by 1
                if(inDegree[v]==0)//now check if it has reached 0, if yes add to the queue to be printed
                    q.add(v);
            }
        }
    }

    /*
    Algorithm
    Store indegree of every vertex
    create a queue
    Add all 0 indegree vertices to the q
    while q is not empty
        pop the top of the queue - call it u
        print u
        for every adjacenet element v of u
            reduce indegree by 1(this means the parent node job is complete, so the dependency is reduced by 1)
            if indegree of v becomes 0, add v to queue --- this means there are no dependency and all jobs it was dependent are finished
     */


}
