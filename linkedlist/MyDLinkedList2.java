/*my implementation*/

import java.util.NoSuchElementException;

public class MyDLinkedList2<T> {
    Node<T> head;
    Node<T> tail;

    class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        
    }

    public void addFront(T element) {
        Node<T> tmp = new Node<T>();
        tmp.value = element;
        tmp.prev = null;
        if (head == null) { //empty list
            tmp.next = null;
            tail = tmp;
            
        } else {
            tmp.next=head;
            head.prev = tmp; 
        }
        head = tmp;
    }

    public void addEnd(T element) {
        Node<T> tmp = new Node<T>();
        tmp.value = element;
        tmp.next = null;
        if (tail == null) {
            tmp.prev = null;
            head = tmp;
        } else {
            tail.next = tmp;
            tmp.prev = tail;
        }
        tail = tmp;
    }
    
    public void addAfter(T element, T after) {
        Node<T> newNode = new Node<T>();
        Node<T> tmp = head;
        Node<T> nextNode = new Node<T>();

        newNode.value = element;
    
        while(true) {
            if (tmp == null){
                System.out.println ("not found");
                break;
            }
            if (tmp.value == after) {
                if (tmp.next == null) { //tmp is tail
                    tmp.next = newNode;
                    newNode.prev = tmp;
                    newNode.next = null;
                    tail = newNode;
                } else {   // newNode in between two other nodes
                    nextNode = tmp.next;
                    tmp.next = newNode;
                    nextNode.prev = newNode;
                    newNode.prev = tmp;
                    newNode.next = nextNode;
               }
               break;
            }
            tmp = tmp.next;
        }
    }
 
    public void removeFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }
        Node<T> tmp = head;
        Node<T> aNode = tmp.next;
        aNode.prev= null;
        head = aNode;
    }


    public void remove(T element) {
        Node<T> tmp = head;
        Node<T> pNode = new Node<T>();
        Node<T> aNode = new Node<T>();

        while (tmp != null) {
            if (tmp.value == element) {
                if (head == tail) { //only one element in list
                    head = null;
                    tail = null;
                } else if (tmp == head){  //remove first node
                    removeFirst();
                } else if (tmp == tail) {  //remove last node
                    pNode = tmp.prev;
                    pNode.next = null;
                    tail = pNode;
                }else {   //remove node in between
                    pNode = tmp.prev;
                    aNode = tmp.next;
                    pNode.next = aNode;
                    aNode.prev = pNode;
                }
            }
            tmp = tmp.next;
        }
    }

    

    

    public void iterate(){
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp=tmp.next;
        }
    }

    public static void main(String[] args){
        MyDLinkedList2<String> dll = new MyDLinkedList2<String>();

        dll.addEnd("Hello");
        dll.addAfter("newElement", "Hello");
        dll.addEnd("hi");
        dll.remove("Hello");
        dll.addEnd("end");
        dll.remove("end");
        dll.addEnd("anotherEnd");
        dll.remove("hi");
        dll.iterate();

    }

} 

