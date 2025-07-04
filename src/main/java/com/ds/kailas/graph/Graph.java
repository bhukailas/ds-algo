package com.ds.kailas.graph;

public interface Graph {

    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int degree(int v);
}
