package SystemDesign.DesignPatterns.Decorator;

public class MargheritaPizza implements BasePizza{

    int cost = 200;
    @Override
    public int getCost() {
        return this.cost;
    }
}
