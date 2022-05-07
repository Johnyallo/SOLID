package Solid;

//LLLiskov substitution principle and
///SSSingle responsibility principle
public class Fruit extends Product implements Weighted {
    public Fruit(String name, int price, String description) {
        super(name, price, description);
    }
    @Override
    public String weight() {
        String [] weight = this.description.split(" ");
        return weight[0];
    }
}