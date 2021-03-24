package com.company.Func;

import java.util.PriorityQueue;
import java.util.Queue;

public class A_Star {
    Graph graph = new Graph();
    public double f;
    public double g;
    public int h;
    public int D = 1;
    int n = 12;
    int m = 6;
    public String[] path = {};
    public Node start = graph.getGraph().get("X00");
    public Node goal = graph.getGraph().get("X115");
    Queue frontier = new PriorityQueue();

    public int heuristic(Node node){
        int dx = Math.abs(node.x - goal.x);
        int dy = Math.abs(node.y - goal.y);
        return  h = D * (dx + dy);
    }

    public void search_path() {

    }
}
