package SystemDesign.DesignPatterns.Decorator;

public class VegDelightPizza implements BasePizza{
    int cost = 100;
    @Override
    public int getCost() {
        return this.cost;
    }
}
