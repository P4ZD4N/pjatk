public class PhraseSinglyLinkedList {
    private SinglyLinkedList singlyLinkedList;

    public PhraseSinglyLinkedList() {
        this.singlyLinkedList = new SinglyLinkedList();
    }

    void addWordAtEnd(Word word) {
        singlyLinkedList.add(word);
    }

    void show() {
        singlyLinkedList.show();
    }
}
