package model;


public class Category {

    private String catOne;

    private String catTwo;

    public Category() {}

    public Category(String catOne, String catTwo) {
        this.catOne = catOne;
        this.catTwo = catTwo;
    }

    public String getCatOne() {
        return catOne;
    }

    public void setCatOne(String catOne) {
        this.catOne = catOne;
    }

    public String getCatTwo() {
        return catTwo;
    }

    public void setCatTwo(String catTwo) {
        this.catTwo = catTwo;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catOne='" + catOne + '\'' +
                ", catTwo='" + catTwo + '\'' +
                '}';
    }
}
