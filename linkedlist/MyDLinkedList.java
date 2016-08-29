import java.util.NoSuchElementException;

public class MyDLinkedList<E> {
    private Node head;
    private Node tail;

    private int size;

    public MyDLinkedList() {
        size = 0;
    }

    private class Node {
        E element;
        Node next;
        Node prev;
    
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() { return size; }

    public boolean isEmpty() {return size ==0; }

    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);        

        if (head != null) { //empty
            head.prev = tmp;
        }
        head = tmp;
        if(tail == null) {
            tail = tmp;
        }
        size++;
    }

    public void addLast(E element) {
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) {head = tmp;}
        size++;
    }    

    public E removeFirst() {
        if (size ==0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size --;
        return tmp.element;
    }

    public E removeLast() {
        if (size ==0) throw new NoSuchElementException();
        Node tmp = tail;
        tail =tail.prev;
        tail.next = null;
        size--;
        return tmp.element;        
    }

    public static void main(String a[]){
        MyDLinkedList<Integer> dll = new MyDLinkedList<Integer>();
        dll.addFirst(10);
       
    }

}
