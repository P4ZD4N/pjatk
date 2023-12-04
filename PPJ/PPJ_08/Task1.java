public class Task1 {
    public static void main(String[] args) {
        char[] characters = "Ala ma kota".toCharArray();
        char[] uniqueCharactersCodes = new char[characters.length];
        countCharacters(characters, uniqueCharactersCodes);
    }
    private static void countCharacters(char[] characters, char[] uniqueCharactersCodes) {
        createUniqueCharactersArray(characters, uniqueCharactersCodes);
        printCharactersOccurrences(characters, uniqueCharactersCodes);
    }
    private static void createUniqueCharactersArray(char[] characters, char[] uniqueCharactersCodes) {
        int repeatsCounter = 0;
        for (int i = 0; i < characters.length; i++) {
            for (char uniqueCharactersCode : uniqueCharactersCodes) {
                if (uniqueCharactersCode == characters[i]) {
                    repeatsCounter++;
                }
            }
            if (repeatsCounter == 0) {
                uniqueCharactersCodes[i] = characters[i];
            }
            repeatsCounter = 0;
        }
    }
    private static void printCharactersOccurrences(char[] characters, char[] uniqueCharactersCodes) {
        int charCounter = 0;
        for (char uniqueCharacter : uniqueCharactersCodes) {
            for (char character : characters) {
                if (uniqueCharacter == character) {
                    charCounter++;
                }
            }
            if (uniqueCharacter != 0) {
                System.out.println(uniqueCharacter + " occurences: " + charCounter);
            }
            charCounter = 0;
        }
    }
}