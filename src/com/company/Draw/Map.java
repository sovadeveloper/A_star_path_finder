package com.company.Draw;

import com.company.Func.Graph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Map implements Drawable{
    int sizeNode = 126;
    Graph graph = new Graph();

    public Map() {
        graph.SetNames();
    }

    @Override
    public void Draw(Graphics2D g) throws IOException {
        DrawMap(g);
    }

    private void DrawMap(Graphics2D g) throws IOException {
        int n = 12;
        int m = 6;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                String name = "X" + i + j;
                //TODO: путь лучше делать относительным а не абсолютным
                BufferedImage grass = ImageIO.read(new File("src/img/grass.png"));
                BufferedImage stone = ImageIO.read(new File("src/img/stone.png"));
                BufferedImage teleportIn = ImageIO.read(new File("src/img/teleport.png"));
                BufferedImage teleportOut = ImageIO.read(new File("src/img/teleport.png"));
                BufferedImage start = ImageIO.read(new File("src/img/start.png"));
                BufferedImage finish = ImageIO.read(new File("src/img/finish.png"));
                BufferedImage arrow_left = ImageIO.read(new File("src/img/arrows/left.png"));
                BufferedImage arrow_up = ImageIO.read(new File("src/img/arrows/up.png"));
                BufferedImage arrow_right = ImageIO.read(new File("src/img/arrows/right.png"));
                BufferedImage arrow_down = ImageIO.read(new File("src/img/arrows/down.png"));
                switch (graph.getGraph().get(name).getTypeOfCell()){
                    case 0:
                        g.drawImage(grass, i*sizeNode, j*sizeNode, null);
                        break;
                    case 1:
                        g.drawImage(stone, i*sizeNode, j*sizeNode, null);
                        break;
                    case 2:
                        g.drawImage(teleportIn, i*sizeNode, j*sizeNode, null);
                        break;
                    case 3:
                        g.drawImage(teleportOut, i*sizeNode, j*sizeNode, null);
                        break;
                    case 4:
                        g.drawImage(start, i*sizeNode, j*sizeNode, null);
                        break;
                    case 5:
                        g.drawImage(finish, i*sizeNode, j*sizeNode, null);
                        break;
                }
            }
        }
    }
}
