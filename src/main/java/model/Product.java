package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    private String name;

    private int price;

    @SerializedName("category")
    private List<Category> categories;

    public Product() {
    }

    public Product(String name, int price, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories='" + categories + '\'' +
                '}';
    }
}
