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
                int typeOfCell = 0;
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
        createTp(numOfTeleports);
        createStones(5);
    }

    private void createStones(int countStones) {
        for (int k = 0; k < countStones; k++) {
            int i = rnd.nextInt(12);
            int j = rnd.nextInt(5);
            while (graph.get(genName(i, j)).typeOfCell != 0) {
                i = rnd.nextInt(12);
                j = rnd.nextInt(5);
            }
            graph.get(genName(i, j)).typeOfCell = 1;
        }
    }

    //Положение телепортов (супер-костыль :D)
    //TODO: согласен, это был костыльный метод
    // небольшой комментарий: так как телепорт не работает в две стороны то он должен быть реализован
    // через ориентированный граф, то есть должна быть ссылка у телепорта входа, на выход, но у выхода
    // не должна быть ссылка на вход
    private void createTp(int countTp) {
        for (int k = 0; k < countTp; k++) {
            int tPl2i = rnd.nextInt(12);
            int tPl2j = rnd.nextInt(5);
            while (graph.get(genName(tPl2i, tPl2j)).typeOfCell != 0) {
                tPl2i = rnd.nextInt(12);
                tPl2j = rnd.nextInt(5);
            }
            graph.get(genName(tPl2i, tPl2j)).typeOfCell = 3;
            int tPl1i = rnd.nextInt(12);
            int tPl1j = rnd.nextInt(5);
            while (graph.get(genName(tPl1i, tPl1j)).typeOfCell != 0) {
                tPl1i = rnd.nextInt(12);
                tPl1j = rnd.nextInt(5);
            }
            graph.get(genName(tPl1i, tPl1j)).typeOfCell = 2;
            graph.get(genName(tPl1i, tPl1j)).incident.add(genName(tPl2i, tPl2j));
        }
    }

    private String genName(int i, int j) {
        return "X" + i + j;
    }

    public HashMap<String, Node> getGraph() {
        return graph;
    }

    public void setGraph(HashMap<String, Node> graph) {
        this.graph = graph;
    }
}