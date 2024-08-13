package SystemDesign.DesignPatterns.Strategy.Right;

class ElectricalStudents {
    PrepWay prep;
    //TODO: Constructor injection of the required interface object, to be decided by the child on creation.
    ElectricalStudents(PrepWay prep) {
        this.prep = prep;
    }
    public void strategy() {
        prep.strategy();
    }
}

public class RightMain {
    public static void main(String[] args) {
        System.out.println("\nElectricalCSE Interested Student1");
        ElectricalStudents e1 = new ElectricalStudents(new ECWay1());
        e1.strategy();
        System.out.println("\nElectricalCSE Interested Student2");
        ElectricalStudents e2= new ElectricalStudents(new ECWay1());
        e2.strategy();
        System.out.println("\nRobotics Interested Student1");
        ElectricalStudents e3 = new ElectricalStudents(new ECWay2());
        e3.strategy();
    }
}


