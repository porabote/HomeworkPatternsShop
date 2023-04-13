import java.util.ArrayList;
import java.util.HashMap;

public class Card {

    private HashMap<Integer, CardProduct> cardList = new HashMap<>();

    protected void put(Product product, int count){
        cardList.put(product.getId(), new CardProduct(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategoryId(),
                count
        ));
    }

    public HashMap getCardList() {
        return this.cardList;
    }

}
