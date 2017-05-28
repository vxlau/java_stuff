import java.util.*;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        Node<T> next;
        T data;
    }

    public void add(T element) {
        Node<T> tmp = new Node<T>();
        tmp.data = element;
        tmp.next = null;

        if(head == null){
            head=tmp;
        } else {
            tail.next = tmp;
        }
        tail = tmp;
        size++;
    } 

    public T remove() {
        T removedItem = head.data;
        
        if( head==null){
            throw new NoSuchElementException();
        }else {
            head = head.next;
            if (head == null){  //not really needed b/c add will take care of.
                tail = null;
            }
            size--;
        }
        return removedItem;

    }   

    public void iterate(){
        Node<T> tmp = head;

        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    } 

    public static void main(String[] args){
        MyQueue<String> mq = new MyQueue<String>();

        mq.add("Hello");
        mq.add("yes");
        mq.add("another");
        String rItem = mq.remove();
        System.out.println("removed item is: " + rItem);
        mq.remove();
        mq.iterate();   

    }


}

