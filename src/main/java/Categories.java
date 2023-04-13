import java.util.ArrayList;

public class Categories {

    public ArrayList list;

    public Categories() {
        this.list.add(new Category(1, "Продукты"));
        this.list.add(new Category(2, "Товары для сада"));
    }

    public ArrayList getList() {
        return this.list;
    }

}
