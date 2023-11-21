package lab11.baitap.bai3.cardInterface.source.display.tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public boolean collision = false;

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
