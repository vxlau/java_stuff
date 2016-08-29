import java.util.*;

public class MyStack<T> {    
    private Node<T> top;
    private int count;

    private class Node<T> {
        T data;
        Node<T> bellow;
    }

    public void push(T element){
        Node<T> tmp = new Node<T>();
        tmp.data = element;
        if (top == null){
            top = tmp;       
        }else {
            tmp.bellow = top;
            top = tmp;
        }
        count++;
    }

    public T pop() {
        if (top == null){
            throw new NoSuchElementException();
        }else {
            T data = top.data;    
            top = top.bellow;
            count--;
            return data;
        }
    }

    public void iterate() {
        Node<T> tmp = top;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.bellow;
        }

    }


    public static void main(String[] args){
        MyStack<String> ms = new MyStack<String>();
        
        ms.push("Hello");
        ms.push("onTop");
        ms.pop();
        ms.iterate();


    }




}
