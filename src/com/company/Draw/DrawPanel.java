package com.company.Draw;

import com.company.Func.Graph;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawPanel extends JPanel{
    Map map = new Map();
    Graph graph = new Graph();
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        try {
            map.Draw(gr);
            graph.Draw(gr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
