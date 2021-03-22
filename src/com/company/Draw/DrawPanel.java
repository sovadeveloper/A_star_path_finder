package com.company.Draw;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawPanel extends JPanel{
    Map map = new Map();
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        try {
            map.Draw(gr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
