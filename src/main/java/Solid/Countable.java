package Solid;

import java.util.List;

public interface Countable {
    int count();
    List<Product> addProduct(List<Product> basketOfProduct, Product product);
}