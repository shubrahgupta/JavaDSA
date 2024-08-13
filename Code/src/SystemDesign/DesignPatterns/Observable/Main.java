package SystemDesign.DesignPatterns.Observable;

public class Main {
    public static void main(String[] args) {
        HeeramandiMostFamousAurat sonakshi = new Sonakshi(6000);
        HeeramandiMostFamousAurat alia = new Alia(10000);

        Tharki shekhar = new ShekharSuman("Lahore");
        Tharki johnny = new JohnnySins("USA");

        sonakshi.addTharki(shekhar);
        alia.addTharki(shekhar);
        alia.addTharki(johnny);

        sonakshi.SetRate(5000);
        alia.SetRate(8000);

        sonakshi.SetRate(4000);
    }



}
