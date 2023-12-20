public class PhraseArray {
    private Word[] words = new Word[0];

    void addWordAtEnd(Word word) {
        Word[] wordsWithWordAdded = new Word[words.length + 1];
        for (int i = 0; i < words.length; i++)
            wordsWithWordAdded[i] = words[i];
        wordsWithWordAdded[wordsWithWordAdded.length - 1] = word;
        words = wordsWithWordAdded;
    }

    void show() {
        for (Word word : words){
            word.show();
            System.out.print(" ");
        }
    }
}
