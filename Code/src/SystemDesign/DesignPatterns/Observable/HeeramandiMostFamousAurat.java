package SystemDesign.DesignPatterns.Observable;

import java.util.ArrayList;
import java.util.List;

public interface HeeramandiMostFamousAurat {
    public void addTharki(Tharki t);
    public void removeTharki(Tharki t);
    public int getRate();
    public void SetRate(int newRate);
    public void notifyTharkis(int newRate);
    public String getName();

}

class Sonakshi implements HeeramandiMostFamousAurat {
    String name = "Sonakshi";
    int Rate;
    List<Tharki> Tharkis = new ArrayList<>();

    Sonakshi(int Rate) {
        this.Rate = Rate;
    }

    @Override
    public void addTharki(Tharki t) {
        Tharkis.add(t);
    }

    @Override
    public void removeTharki(Tharki t) {
        Tharkis.remove(t);
    }

    @Override
    public int getRate() {
        return Rate;
    }

    @Override
    public void SetRate(int newRate) {
        if (newRate < Rate) {
            notifyTharkis(newRate);
        }
    }

    @Override
    public void notifyTharkis(int newRate) {
        for (Tharki t : Tharkis) {
            t.Samachar(newRate, this);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}


class Alia implements HeeramandiMostFamousAurat {
    String name = "Alia";
    int Rate;
    List<Tharki> Tharkis = new ArrayList<>();

    Alia(int Rate) {
        this.Rate = Rate;
    }

    @Override
    public void addTharki(Tharki t) {
        Tharkis.add(t);
    }

    @Override
    public void removeTharki(Tharki t) {
        Tharkis.remove(t);
    }

    @Override
    public int getRate() {
        return Rate;
    }

    @Override
    public void SetRate(int newRate) {
        if (newRate < Rate) {
            notifyTharkis(newRate);
        }
    }

    @Override
    public void notifyTharkis(int newRate) {
        for (Tharki t : Tharkis) {
            t.Samachar(newRate, this);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}



