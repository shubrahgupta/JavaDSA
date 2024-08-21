package MachineCoding.DocumentProcessor;

public class driverClass {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        Character c1 = characterFactory.createCharacter('d',20,"Arial");
        c1.render(0,0);

        Character c2 = characterFactory.createCharacter('d',20,"Arial");
        c1.render(0,6);
    }
}
