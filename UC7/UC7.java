

public class UC7 {

    static class CharacterPatternMap {
        private final Character character;
        private final String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {

        CharacterPatternMap o = new CharacterPatternMap('O', new String[] {
                String.join("", "  *****  "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", "  *****  ")
        });

        CharacterPatternMap p = new CharacterPatternMap('P', new String[] {
                String.join("", " ******  "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " ******  "),
                String.join("", " **      "),
                String.join("", " **      "),
                String.join("", " **      ")
        });

        CharacterPatternMap s = new CharacterPatternMap('S', new String[] {
                String.join("", "  *****  "),
                String.join("", " **   ** "),
                String.join("", " **      "),
                String.join("", "  *****  "),
                String.join("", "      ** "),
                String.join("", " **   ** "),
                String.join("", "  *****  ")
        });

        CharacterPatternMap sp = new CharacterPatternMap(' ', new String[] {
                "         ",
                "         ",
                "         ",
                "         ",
                "         ",
                "         ",
                "         "
        });

        return new CharacterPatternMap[] { o, p, s, sp };
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        char lookup = Character.toUpperCase(ch);
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == lookup) {
                return map.getPattern();
            }
        }
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ' ') {
                return map.getPattern();
            }
        }
        return new String[] {
                "         ","         ","         ",
                "         ","         ","         ","         "
        };
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {

        int rows = 7;

        for (int row = 0; row < rows; row++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                String[] pattern = getCharacterPattern(message.charAt(i), charMaps);
                sb.append(pattern[row]);
                if (i < message.length() - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}