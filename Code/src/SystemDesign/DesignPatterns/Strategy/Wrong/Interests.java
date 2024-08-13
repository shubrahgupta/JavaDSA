package SystemDesign.DesignPatterns.Strategy.Wrong;

class ElectricalCSEInterestedStudent1 extends ElectricalStudents{
    String way = "Learn DSA, System Design, OS etc";
    // TODO:have to define way in each child if different from the parent class
    @Override
    public void strategy() {
        System.out.println(way);
    }

}

class ElectricalCSEInterestedStudent2 extends ElectricalStudents{
    String way = "Learn DSA, System Design, OS etc";
    // TODO:have to define way in each child if different from the parent class

    @Override
    public void strategy() {
        System.out.println(way);
    }

}
class ElectricalCSEInterestedStudent3 extends ElectricalStudents{
    String way = "Learn DSA, System Design, OS etc";
    // TODO:have to define way in each child if different from the parent class

    @Override
    public void strategy() {
        System.out.println(way);
    }

}

public class Interests {
    public static void main(String[] args) {
        System.out.println("\nElectricalCSE Interested Student1");
        ElectricalStudents es1 = new ElectricalCSEInterestedStudent1();
        es1.strategy();
        System.out.println("\nElectricalCSE Interested Student2");
        ElectricalStudents es2 = new ElectricalCSEInterestedStudent2();
        es2.strategy();
        System.out.println("\nElectricalCSE Interested Student3");
        ElectricalStudents es3 = new ElectricalCSEInterestedStudent3();
        es3.strategy();

    }
}
