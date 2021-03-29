package com.company.Func.testAstar;

public class PathNode {
    public int positionX;
    public int positionY;
    public int g;
    public PathNode CameFrom;
    public int h;
    public int f;

    public PathNode() {
    }

    public PathNode(Node positionX, Node positionY, int g, PathNode cameFrom, int h) {
        this.positionX = positionX.getX();
        this.positionY = positionY.getY();
        this.g = g;
        this.CameFrom = cameFrom;
        this.h = h;
    }

    public Node getPosition() {
        return position;
    }

    public void setPosition(Node position) {
        this.position = position;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public PathNode getCameFrom() {
        return CameFrom;
    }

    public void setCameFrom(PathNode cameFrom) {
        CameFrom = cameFrom;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return this.g + this.h;
    }

    public void setF(int f) {
        this.f = f;
    }
}
