package MachineCoding.DocumentProcessor;

public class Character implements ICharacter {
    char character;
    int size;
    String fontStyle;

    public Character(char character, int size, String fontStyle) {
        this.character = character;
        this.size = size;
        this.fontStyle = fontStyle;
    }

    public char getCharacter() {
        return character;
    }

    public int getSize() {
        return size;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    @Override
    public void render(int row, int column) {
        System.out.println(row + " " + column + " : " + getCharacter());
    }
}
