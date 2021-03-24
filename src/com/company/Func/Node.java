package com.company.Func;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<String> incident;
    public int typeOfCell;
    public int x;
    public int y;
    public int cost;

    public Node() {
        incident = new ArrayList<>();
    }

    public Node(List<String> incident, int typeOfCell, int x, int y) {
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
