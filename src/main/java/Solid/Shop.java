package Solid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Shop implements Expensive {
    public static int totalPrice;

    //Вывод доступных для покупки товаров                             method showProducts
    //Фильтрация товаров по ключевым словам, ценам, производителям    interface or method
    //Составление продуктовой корзины пользователя
    //Трекинг заказа в системе доставки                               interface tracking
    //Возврат заказа, повтороение заказа                              methods
    //Система рейтинга для товаров                                    class
    //Простая рекомендательная система для покупок

    //SOLID - closed for modification but opened for expansion


    @Override
    public boolean expensive() {
        if (totalPrice > 1000) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Product> list = new ArrayList<>();
        PlanToShop planToShop = new PlanToShop(list);
        PlanToPrice planToPrice = new PlanToPrice(list);

        Fruit apple = new Fruit("Apple", 60, "1000 gram");
        Product bread = new Product("Bread", 20, "500 gram");
        Product water = new Product("Water", 15, "1 litre");

//        list.add(bread);
//        list.add(water);
//        list.add(apple);


        // DRY
        Collections.addAll(list, bread, water, apple);


        Product [] products = {apple, bread, water};
        int [] prices = {60, 20, 15};
        int [] valueOfProducts = new int[products.length];    //MMMagic numbers

        Scanner scanner = new Scanner(System.in);

        System.out.println(planToShop.toString());
        System.out.println(planToPrice.count());

        for (int i = 0; i < products.length; i++) {
            System.out.println(i+1 + "." + products[i] + " " + prices[i] + "p.");
        }
        System.out.println();

        while(true) {
            System.out.println("Input product and value of it or input 'END':");
            String product  = scanner.nextLine();
            if (product.equals("end")) {
                break;
            }
            String [] productAndValue = product.split(" ");
            int productNumber = Integer.parseInt(productAndValue[0]) - 1;
            int count  = Integer.parseInt(productAndValue[1]);
            valueOfProducts[productNumber] += count;
        }

        System.out.println("We bought: ");
        System.out.println("PRODUCT " + " VALUE " + "PRICE " + "TOTAL_PRICE ");

        for (int i = 0; i < valueOfProducts.length; i++) {
            if (valueOfProducts[i] > 0) {
                System.out.println(products[i] + " " + valueOfProducts[i] + " " + prices[i] * valueOfProducts[i]);
            }
        }
        totalPrice = prices[0] * valueOfProducts[0] + prices[1] * valueOfProducts[1] + prices[2] * valueOfProducts[2];
        System.out.println("Total price for all products: "
                + totalPrice);
        System.out.println(shop.expensive());
        System.out.println(apple.weight());


        System.out.println(list.toString());

    }
}
