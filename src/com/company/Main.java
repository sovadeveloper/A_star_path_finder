package com.company;

import com.company.Draw.MainWindow;
import com.company.Func.Graph;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mw.setSize(1920, 1080);
        mw.setVisible(true);
    }
}
