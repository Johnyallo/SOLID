package Solid;

import java.util.ArrayList;
import java.util.List;


//OOOpen-closed principle
public class PlanToPrice implements Countable{
    List<Product> list = new ArrayList<>();

    public PlanToPrice(List<Product> list) {
        this.list = list;
    }

    @Override
    public List<Product> addProduct(List<Product> basketOfProduct, Product product) {
        basketOfProduct.add(product);
        return basketOfProduct;
    }

    @Override
    public int count() {
        int totalPrice = 0;
        for(int i = 0; i < list.size(); i++) {
            totalPrice += list.get(i).price;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "PlanToPrice: " +
                "list=" + list +
                '}';
    }
}