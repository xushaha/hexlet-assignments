package exercise;

import java.util.List;

public class Shop {
    private Integer id;
    private String address;
    private List<Item> items;

    public Shop() {
    }

    public Shop(Integer id, String address, List<Item> items) {
        this.id = id;
        this.address = address;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
