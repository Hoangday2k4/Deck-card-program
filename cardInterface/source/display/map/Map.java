package lab11.baitap.bai3.cardInterface.source.display.map;

import lab11.baitap.bai3.card.Card;

public class Map {
    public Card[][] dataMap;

    public Map() {
        Card[][] array = new Card[4][13];
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= 13; j++) {
                array[array.length - i][j - 1] = new Card(convertRank(j), convertSuit(i));
            }
        }
        dataMap = array;
    }

    public Card[][] getDataMap() {
        return dataMap;
    }

    public void setDataMap(Card[][] dataMap) {
        this.dataMap = dataMap;
    }

    public void updateMap(Card[][] dataMap) {
        this.setDataMap(dataMap);
    }

    public String convertSuit(int i) {
        if (i == 1) {
            return "spades";
        } else if (i == 2) {
            return "clovers";
        } else if (i == 3) {
            return "diamonds";
        } else {
            return "hearts";
        }
    }

    public String convertRank(int i) {
        if (i == 1) {
            return "A";
        } else if (i == 11) {
            return "J";
        } else if (i == 12) {
            return "Q";
        } else if (i == 13) {
            return "K";
        } else {
            return String.valueOf(i);
        }
    }
}
