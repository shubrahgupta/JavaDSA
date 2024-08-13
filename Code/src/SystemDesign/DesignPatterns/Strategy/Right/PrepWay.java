package SystemDesign.DesignPatterns.Strategy.Right;

public interface PrepWay {
    //TODO: Generic interface
    public void strategy();
}

class ECWay1 implements PrepWay {
    //TODO: Strategy defined for a class of similar people to be used.
    String way = "Learn DSA, System Design, OS etc";
    @Override
    public void strategy() {
        System.out.println(way);
    }
}

class ECWay2 implements PrepWay {
    //TODO: Strategy defined for a class of similar people to be used.
    String way = "Learn Robotics";
    @Override
    public void strategy() {
        System.out.println(way);
    }
}

