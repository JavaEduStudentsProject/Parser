package model;

import com.google.gson.annotations.SerializedName;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByPosition;

import java.util.List;
import java.util.Map;

public class Product {
    @SerializedName(value="name", alternate={"Имя", "Наименование"})
    private String name;

    @SerializedName(value="price", alternate={"Цена", "Стоимость"})
    private int price;

    @SerializedName("properties")
    private Map<String, String> properties;

    public Product() {
    }

    public Product(String name, int price, Map<String, String> properties) {
        this.name = name;
        this.price = price;
        this.properties = properties;
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

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", properties=" + properties +
                '}';
    }
}
