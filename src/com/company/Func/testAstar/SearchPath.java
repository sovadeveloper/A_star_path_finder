package com.company.Func.testAstar;

import java.util.*;

public class SearchPath {
    public List<Node> findPath(int[][] map, Node start, Node goal){
        List<PathNode> openedList = new ArrayList();
        List<PathNode> closed = new ArrayList<>();

        PathNode startNode = new PathNode(start, 0, null, heuristic(start, goal));
        openedList.add(startNode);

        int f_iter = 999999;
        PathNode currentNode = null;
        while(openedList.size() > 0){
            for(int i = 0; i < openedList.size(); i++){
                if(openedList.get(i).getF() < f_iter){
                    f_iter = openedList.get(i).getF();
                    currentNode = openedList.get(i);
                }
            }
            if(currentNode.getPosition() == goal){
                return GetPathForNode(currentNode);
            }
            openedList.remove(currentNode);
            closed.add(currentNode);
            for(PathNode neighbour: GetNeighbours(currentNode, goal, map)){
                //Застопорился...((((((((((((((((((((((((((((((((
                for(int i = 0; i < closed.size(); i++){
                    if((neighbour.getPosition() > 0) || (closed.get(i).getPosition() > 0)){

                    }
                }
            }
        }



        return null;
    }

    public int heuristic(Node from, Node to){
        return Math.abs(from.getX() - to.getX()) + Math.abs(from.getY() - to.getY());
    }

    public List<Node> GetPathForNode(PathNode pathNode){
        List<Node> result = new ArrayList<Node>();
        PathNode currentNode = pathNode;
        while (currentNode != null){
            result.add(currentNode.getPosition());
            currentNode = currentNode.getCameFrom();
        }
        reverseList(result);
        return result;
    }

    public List<Node> reverseList(List<Node> arrList) {
        List<Node> revList = new ArrayList<Node>();

        for (int i = arrList.size() - 1; i >= 0; i--) {
            revList.add(arrList.get(i));
        }
        return revList;
    }

    public List<PathNode> GetNeighbours(PathNode pathNode, Node goal, int[][] map){
        List<PathNode> result = new ArrayList();

        Node[] neighboursNodes = new Node[4];
        neighboursNodes[0] = new Node(pathNode.position.getX() + 1, pathNode.position.getY());
        neighboursNodes[1] = new Node(pathNode.position.getX() - 1, pathNode.position.getY());
        neighboursNodes[2] = new Node(pathNode.position.getX(), pathNode.position.getY() + 1);
        neighboursNodes[3] = new Node(pathNode.position.getX(), pathNode.position.getY() - 1);

        for(Node point: neighboursNodes){
            if(point.getX() < 0 || point.getX() >= map.length){
                continue;
            }
            if(point.getY() < 0 || point.getY() >= map.length){
                continue;
            }
            if(map[point.getX()][point.getY()] != 0 && map[point.getX()][point.getY()] != 1){
                continue;
            }
            PathNode neighbourNode = new PathNode(point, pathNode.getG() + GetDistanceBetweenNeighbours(),pathNode, heuristic(point, goal));
            result.add(neighbourNode);
        }
        return result;
    }

    private static int GetDistanceBetweenNeighbours()
    {
        return 1;
    }
}
