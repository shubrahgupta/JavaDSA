package MachineCoding.DocumentProcessor;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    Map<java.lang.Character, Character> characterCache;

    public CharacterFactory() {
        this.characterCache = new HashMap<>();
    }

    public Character createCharacter(char characterName, int size, String fontStyle) {
        if (characterCache.containsKey(characterName)){
            return characterCache.get(characterName);
        }
        else {
            Character character = new Character(characterName, size, fontStyle);
            characterCache.put(characterName, character);
            return character;
        }
    }
}
