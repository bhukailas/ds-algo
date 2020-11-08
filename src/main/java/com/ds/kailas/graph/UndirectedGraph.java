package com.ds.kailas.graph;

import com.ds.kailas.bag.Bag;
import com.ds.kailas.common.In;

import java.util.NoSuchElementException;

public class UndirectedGraph implements Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public UndirectedGraph(int V) {
        if(V < 0) throw new IllegalArgumentException("invalid number of vertices");
        this.V = V;
        this.adj = (Bag<Integer>[]) new Bag[V];

        for(int v=0; v<V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public UndirectedGraph(In in) {
        if(in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            if(V <0) throw new IllegalArgumentException("number of vertices in Grpah must be non negative");
            adj = (Bag<Integer>[]) new Bag[V];
            for(int v=0; v<V; v++) {
                adj[v] = new Bag<>();
            }
            int E = in.readInt();
            if(E <0) throw new IllegalArgumentException("NUMBER OF EDGES IN GRAPH must be positive");

            for(int i=0; i< E; i++) {
                int v = in.readInt();
                int w = in.readInt();

                validateVertex(v);
                validateVertex(w);

                addEdge(v, w);
            }
        } catch (NoSuchElementException nee) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", nee);
        }
    }

    private void validateVertex(int v) {
        if(v < 0 && v >= V)
            throw new IllegalArgumentException("vertex "+ v +" is not between 0 and "+(V-1));
    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }

    @Override
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    @Override
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }
}
