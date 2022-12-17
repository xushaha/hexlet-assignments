package exercise;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        Item item = new Item();
        item.setId(1);
        item.setName("Булка");

        Item item2 = new Item(2, "Рыба");

        Shop shop = new Shop();
        shop.setId(4);
        shop.setAddress("Москва");
        shop.setItems(List.of(item, item2));
    }
}
