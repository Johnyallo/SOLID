package Solid;

import java.util.ArrayList;
import java.util.List;

public class PlanToShop implements Countable {
    List<Product> list = new ArrayList<>();

    public PlanToShop(List<Product> list) {
        this.list = list;
    }

    @Override
    public List<Product> addProduct(List<Product> basketOfProduct, Product product) {
        basketOfProduct.add(product);
        return basketOfProduct;
    }

    @Override
    public String toString() {
        return "I need to buy next products: " + list +
                '}';
    }

    @Override
    public int count() {
        return list.size();
    }
}
