package com.company.Func;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Graph {
    private HashMap<Point, Node> graph = new HashMap<>();
    Random rnd = new Random();
    int sizeNode = 126;
    Point goal = new Point(11, 5);


    public void SetNames() {
        int n = 12;
        int m = 6;
        int numOfTeleports = 1;

        //Заполнение графа
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int typeOfCell = 0;
                Point name = new Point(i, j);
                if (name.equals(new Point(0, 0))) {
                    typeOfCell = 4;
                }
                if (name.equals(new Point(11, 5))) {
                    typeOfCell = 5;
                }
                ArrayList<Point> incident = new ArrayList<>();
                if (i - 1 >= 0) {
                    incident.add(new Point(i - 1, j));
                }
                if (i + 1 < n) {
                    incident.add(new Point(i + 1, j));
                }
                if (j - 1 >= 0) {
                    incident.add(new Point(i, j - 1));
                }
                if (j + 1 < m) {
                    incident.add(new Point(i, j + 1));
                }
                graph.put(name, new Node(incident, typeOfCell, i, j));
            }
        }
        createTp(numOfTeleports);
        createStones(5);
        findPath();
    }

    Node active;
    List<Node> open = new ArrayList<>();
    List<Node> close  = new ArrayList<>();
    List<Node> finalPath = new ArrayList<>();

    private void findPath() {
        active = graph.get(new Point(0,0));
        open.addAll(convertPointToNode(active.incident));
        for(Node item:open){
            item.weight = active.weight+10;
            item.heuristicWeight = heuristic(item);
            item.cellFrom = active;
        }
        close.add(active);


        while(open.size() > 0){
            Node currentNode = null;
            for(Node node: open){
                if(currentNode.f > node.f){
                    currentNode = node;
                }
            }
            if((currentNode.x == goal.x) && (currentNode.y == goal.y)){
                return;// Здесь как-то маршрут надо вернуть, так как рассматриваемая точка оказалась конечной
            }
            close.add(currentNode);
            //насчет следующеей строки не уверен, но надо скорее всего обновлять open-лист новыми соседями новой рассматр. точки
            open.addAll(convertPointToNode(currentNode.incident));
            //как уже писал, насчет верхней строки не уверен
            open.remove(currentNode);
            for(Node neighbour: convertPointToNode(currentNode.incident)){
                for(Node node: close){
                    if((node.x == neighbour.x) && (node.y == neighbour.y)){
                        continue;
                    }
                }
                Node openNode = open.get(0);
                if(openNode == null){
                    open.add(neighbour);
                }else{
                    openNode.cellFrom = currentNode;
                    openNode.weight = neighbour.weight;
                }
            }
        }
        return; // Не дает вернуть null, так как метод void, надо чтобы метод возвращад List<Node> либо List<Point>
    }

    private int heuristic(Node item) {
        return Math.abs(item.x - goal.x) + Math.abs(item.y - goal.y);
    }

    private List<Node> convertPointToNode(List<Point> list){
        List<Node> list2 = new ArrayList<>();
        for(Point item:list){
            list2.add(graph.get(item));
        }
        return list2;
    }

    private void deleteIncidentStones(){
        for(Node item:graph.values()){
            item.incident.removeIf(i -> graph.get(i).typeOfCell == 1);
        }
    }

    private void createStones(int countStones) {
        for (int k = 0; k < countStones; k++) {
            int i = rnd.nextInt(12);
            int j = rnd.nextInt(5);
            while (graph.get(new Point(i, j)).typeOfCell != 0) {
                i = rnd.nextInt(12);
                j = rnd.nextInt(5);
            }
            graph.get(new Point(i, j)).typeOfCell = 1;
        }
        deleteIncidentStones();
    }

    //Положение телепортов (супер-костыль :D)
    private void createTp(int countTp) {
        for (int k = 0; k < countTp; k++) {
            int tPl2i = rnd.nextInt(12);
            int tPl2j = rnd.nextInt(5);
            while (graph.get(new Point(tPl2i, tPl2j)).typeOfCell != 0) {
                tPl2i = rnd.nextInt(12);
                tPl2j = rnd.nextInt(5);
            }
            graph.get(new Point(tPl2i, tPl2j)).typeOfCell = 3;
            int tPl1i = rnd.nextInt(12);
            int tPl1j = rnd.nextInt(5);
            while (graph.get(new Point(tPl1i, tPl1j)).typeOfCell != 0) {
                tPl1i = rnd.nextInt(12);
                tPl1j = rnd.nextInt(5);
            }
            graph.get(new Point(tPl1i, tPl1j)).typeOfCell = 2;
            graph.get(new Point(tPl1i, tPl1j)).incident.add(new Point(tPl2i, tPl2j));
        }
    }

    public HashMap<Point, Node> getGraph() {
        return graph;
    }

    public void setGraph(HashMap<Point, Node> graph) {
        this.graph = graph;
    }
}