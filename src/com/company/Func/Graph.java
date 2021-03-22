package com.company.Func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Graph {
    private HashMap<String, Node> graph = new HashMap<>();
    Random rnd = new Random();
    int sizeNode = 126;

    public void SetNames() {
        int n = 12;
        int m = 6;
        int numOfTeleports = 1;
        String startCell = "X00";
        String endCell = "X115";

        //Заполнение графа
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int typeOfCell = rnd.nextInt(2);
                String name = "X" + i + j;
                if (name.equals("X00")) {
                    typeOfCell = 4;
                }
                if (name.equals("X115")) {
                    typeOfCell = 5;
                }
                ArrayList<String> incident = new ArrayList<>();
                if (i - 1 >= 0) {
                    incident.add("X" + (i - 1) + j);
                }
                if (i + 1 < n) {
                    incident.add("X" + (i + 1) + j);
                }
                if (j - 1 >= 0) {
                    incident.add("X" + i + (j - 1));
                }
                if (j + 1 < m) {
                    incident.add("X" + i + (j + 1));
                }
                graph.put(name, new Node(incident, typeOfCell, i * sizeNode, j * sizeNode));
            }
        }

        //Положение телепортов (супер-костыль :D)
        for (int k = 0; k < numOfTeleports; k++){
                int typeOfCell;
                int teleport1PartOne = rnd.nextInt(12);
                int teleport1PartTwo = rnd.nextInt(5);
                int teleport2PartOne = rnd.nextInt(12);
                int teleport2PartTwo = rnd.nextInt(5);
                String nameOfCellForTeleport1 = "X" + teleport1PartOne + teleport1PartTwo;
                String nameOfCellForTeleport2 = "X" + teleport2PartOne + teleport2PartTwo;

                if(!nameOfCellForTeleport1.equals(startCell) && !nameOfCellForTeleport1.equals(endCell)){
                    typeOfCell = 2;
                    ArrayList<String> incidentTeleports = new ArrayList<>();
                    incidentTeleports.add(nameOfCellForTeleport2);
                    graph.put(nameOfCellForTeleport1, new Node(incidentTeleports, typeOfCell, teleport1PartOne * sizeNode, teleport1PartTwo * sizeNode));
                }else{
                    nameOfCellForTeleport1 = "X" + 3 + 2;
                    typeOfCell = 2;
                    ArrayList<String> incidentTeleports = new ArrayList<>();
                    incidentTeleports.add(nameOfCellForTeleport2);
                    graph.put(nameOfCellForTeleport1, new Node(incidentTeleports, typeOfCell, teleport1PartOne * sizeNode, teleport1PartTwo * sizeNode));

                }
                if(!nameOfCellForTeleport2.equals(startCell) && !nameOfCellForTeleport2.equals(endCell)){
                    typeOfCell = 3;
                    ArrayList<String> incidentTeleports = new ArrayList<>();
                    incidentTeleports.add(nameOfCellForTeleport1);
                    graph.put(nameOfCellForTeleport2, new Node(incidentTeleports, typeOfCell, teleport2PartOne * sizeNode, teleport2PartTwo * sizeNode));
                }else{
                    nameOfCellForTeleport2 = "X" + 9 + 4;
                    typeOfCell = 3;
                    ArrayList<String> incidentTeleports = new ArrayList<>();
                    incidentTeleports.add(nameOfCellForTeleport1);
                    graph.put(nameOfCellForTeleport2, new Node(incidentTeleports, typeOfCell, teleport2PartOne * sizeNode, teleport2PartTwo * sizeNode));
                }
            }
    }

    public HashMap<String, Node> getGraph() {
        return graph;
    }

    public void setGraph(HashMap<String, Node> graph) {
        this.graph = graph;
    }
}