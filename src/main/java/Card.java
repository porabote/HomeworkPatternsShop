import java.util.ArrayList;

public class Card {

    private ArrayList<Product> cardList;

    protected void put(Product product) {
        cardList.add(product);
    }

    public ArrayList getCardList() {
        return this.cardList;
    }

}
