package com.example.parseproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@RedisHash("Product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int price;
//    private Map<String, String> properties;

    public Product() {
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
