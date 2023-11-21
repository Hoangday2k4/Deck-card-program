package lab11.baitap.bai3.cardInterface.source.display.main;

import lab11.baitap.bai3.card.Card;
import lab11.baitap.bai3.cardInterface.source.display.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    // SCREEN SETTING
    public final int TILESIZE = 100;
    public final int MAXSCREEN_COL = 13;
    public final int MAXSCREEN_ROW = 4;
    public final int SCREEN_WIDTH = TILESIZE * MAXSCREEN_COL;
    public final int SCREEN_HEIGHT = TILESIZE * MAXSCREEN_ROW * 14 / 10;

    Thread panelThread;

    TileManager tileManager = new TileManager(this);

    public Panel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void updateData(Card[][] array) {
        System.out.println("update:");
        tileManager.update(array);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2);
        g2.dispose();
    }


    public void startPanelThread() {
        panelThread = new Thread(this);
        panelThread.start();
    }

    @Override
    public void run() {
        while(panelThread != null) {
//            System.out.println("The panel loop is running:");

        }
    }
}

