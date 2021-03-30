package com.company.Func;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Point> incident;
    public int typeOfCell;
    public int x;
    public int y;
    public int weight = 0;
    public int evristicWeight = 0;
    public Node cellfrom;


    public Node() {
        incident = new ArrayList<>();
    }

    public Node(List<Point> incident, int typeOfCell, int x, int y) {
        this();
        this.incident = incident;
        this.typeOfCell = typeOfCell;
        this.x = x;
        this.y = y;
    }



    public void setTypeOfCell(int typeOfCell) {
        this.typeOfCell = typeOfCell;
    }

    public int getTypeOfCell() {
        return typeOfCell;
    }
}
