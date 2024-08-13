package SystemDesign.DesignPatterns.Observable;

import java.util.ArrayList;
import java.util.List;

public interface Tharki {
    public void Samachar(int newRate, HeeramandiMostFamousAurat h);
}

class JohnnySins implements Tharki {
    String name = "Johnny Sins";
    String address;

    JohnnySins(String address) {
        this.address = address;
    }


    @Override
    public void Samachar(int newRate, HeeramandiMostFamousAurat h) {
        System.out.println("New Rate: " + newRate + " of " + h.getName() + " dispatched kabootar to "  + name +  " " + address);
    }

}
class ShekharSuman implements Tharki {
    String name = "Shekhar Suman";
    String address;

    ShekharSuman(String address) {
        this.address = address;
    }


    @Override
    public void Samachar(int newRate, HeeramandiMostFamousAurat h) {
        System.out.println("New Rate: " + newRate + " of " + h.getName() + " dispatched kabootar to "  + name +  " " +  address);
    }
}
