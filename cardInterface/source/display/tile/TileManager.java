package lab11.baitap.bai3.cardInterface.source.display.tile;

import lab11.baitap.bai3.card.Card;
import lab11.baitap.bai3.cardInterface.source.display.main.Panel;
import lab11.baitap.bai3.cardInterface.source.display.map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class TileManager {
    Panel gp;
    HashMap<String, Tile> tiles;
    public Map mapTileNum;

    public TileManager(Panel gp) {
        this.gp = gp;
        tiles = new HashMap<>();
        mapTileNum = new Map();
        getTileImage();
    }

    public void getTileImage() {
        String tempString;
        Tile tempTiles;
        try {
            String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
            String suit = "hearts";
            for (String rank_Hearts : ranks) {
                tempString = rank_Hearts + "_" + suit;
                tempTiles = new Tile();
                tempTiles.setImage(ImageIO.read(getClass().getResourceAsStream("/cards/s" + rank_Hearts.toLowerCase() + ".png")));
                tiles.put(tempString, tempTiles);
            }

            suit = "diamonds";
            for (String rank_Diamonds : ranks) {
                tempString = rank_Diamonds + "_" + suit;
                tempTiles = new Tile();
                tempTiles.setImage(ImageIO.read(getClass().getResourceAsStream("/cards/l" + rank_Diamonds.toLowerCase() + ".png")));
                tiles.put(tempString, tempTiles);
            }

            suit = "clovers";
            for (String rank_Clovers : ranks) {
                tempString = rank_Clovers + "_" + suit;
                tempTiles = new Tile();
                tempTiles.setImage(ImageIO.read(getClass().getResourceAsStream("/cards/k" + rank_Clovers.toLowerCase() + ".png")));
                tiles.put(tempString, tempTiles);
            }

            suit = "spades";
            for (String rank_Spades : ranks) {
                tempString = rank_Spades + "_" + suit;
                tempTiles = new Tile();
                tempTiles.setImage(ImageIO.read(getClass().getResourceAsStream("/cards/p" + rank_Spades.toLowerCase() + ".png")));
                tiles.put(tempString, tempTiles);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.MAXSCREEN_COL && row < gp.MAXSCREEN_ROW) {
            String tineNum = mapTileNum.dataMap[row][col].toString();

            g2.drawImage(tiles.get(tineNum).image, x, y, 100, 140, null);
            col++;
            x += 100;

            if (col == gp.MAXSCREEN_COL) {
                col = 0;
                x = 0;
                row++;
                y += 140;
            }
        }
    }

    public void update(Card[][] array) {
        this.mapTileNum.updateMap(array);
    }
}