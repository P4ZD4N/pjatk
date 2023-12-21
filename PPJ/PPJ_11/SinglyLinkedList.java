public class SinglyLinkedList {
    private Node head;

    public void add(Word word) {
        Node node = new Node(word);

        if (head == null)
            head = node;
        else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = node;
        }
    }

    public void show() {
        Node current = head;

        while (current != null) {
            current.word.show();
            System.out.print(" ");
            current = current.next;
        }

        System.out.println();
    }

    private static class Node {
        private Word word;
        private Node next;

        public Node(Word word) {
            this.word = word;
            this.next = null;
        }
    }
}
