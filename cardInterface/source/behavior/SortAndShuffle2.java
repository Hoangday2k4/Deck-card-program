package lab11.baitap.bai3.cardInterface.source.behavior;

import lab11.baitap.bai3.card.Card;
import lab11.baitap.bai3.card.ShuffleCard;
import lab11.baitap.bai3.card.SortCard;
import lab11.baitap.bai3.cardInterface.source.display.main.Panel;
import lab11.baitap.bai3.cardInterface.source.display.tile.TileManager;

import java.util.Arrays;

public class SortAndShuffle2 {
    public Panel panel = new Panel();
    public TileManager tile = new TileManager(panel);

    public void sort(Card[][] cards) {
        Card[] temp = convert1DArray(cards);
        SortCard sortCard = new SortCard();
        sortCard.sort(temp);
        cards = copyOfArray(convert2DArray(temp));
    }

    public void shuffle(Card[][] cards) {
        ShuffleCard shuffleCard = new ShuffleCard();
        shuffleCard.shuffle(cards);
    }

    private Card[] convert1DArray(Card[][] array) {
        Card[] newArr = new Card[array.length * array[0].length];
        int t = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                newArr[t] = array[i][j];
                t++;
            }
        }
        return newArr;
    }

    private Card[][] convert2DArray(Card[] array) {
        Card[][] newArr = new Card[4][13];
        int t = 0;
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                newArr[i][j] = array[t];
                t++;
            }
        }
        return newArr;
    }

    private Card[][] copyOfArray(Card[][] array)  {
        Card[][] copyArray = new Card[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return copyArray;
    }
}
