package exercise;

public class Item {
    private Integer id;
    private String name;
    private Shop shop;

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item() {
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
