import java.util.*;

/*
    Comparable interface - (String, Double, BigInterger already implements this)
        compable of comparing itself with another object
    a.compareTo(b)
    -------
    comparator-comparing two different object. Might want to create a comparator object to pass to sort.
    comparison method for classes that you have no control over
        compapre(a,b)

    negative - this < that
    0  ==
    positive this > that

*/

public class BST <T extends Comparable<T>> implements Iterable<T>{
    private Node<T> root;
    private Comparator<T> comparator;
 
    public static void main(String[] args){
    
    }

    public BST(){
        root = null;
        comparator = null;
    }

    public BST(Comparator<T> comp){   //uses comparator class 
        root = null;
        comparator = comp;
    }

    private int compare(T x, T y){
        if(comparator == null){
            return x.compareTo(y); //what is normally used
        }else{
            return comparator.compare(x,y);
        }

    }

//Insert
    public void insert(T data){
        root = insert(root, data);
    }
    private Node<T> insert(Node<T> p, T toInsert){ //searching for empty node to insert to
        if(p == null){  //if null put node here
            return new Node<T>(toInsert);
        }
        if (compare (toInsert, p.data) == 0){
            return p;
        }

        if (compare(toInsert, p.data) < 0){
            p.left = insert(p.left, toInsert);
        }else{
            p.right = insert(p.right, toInsert);
        }

        return p;
    }

//Search
    public boolean search(T toSearch){
       return search(root, toSearch);
    }
    private boolean search(Node<T> p, T toSearch){
        if (p == null){
            return false;
        }else if (compare(toSearch, p.data) == 0){
            return true;
        }else if (compare(toSearch, p.data) < 0){
            return search(p.left, toSearch);
        }else {
            return search(p.right, toSearch);
        }
    }


// Delete
    public void delete(T toDelete){
        root = delete(root, toDelete);
    }    

    private Node<T> delete(Node<T> p, T toDelete){
        if (p == null){
            throw new RuntimeException("cannot delete");
        }else if (compare(toDelete, p.data) < 0){
            p.left = delete (p.left, toDelete);
        }else if (compare(toDelete, p.data) > 0){
            p.right = delete(p.right, toDelete);
        }else{   // if equal, found node to delete
            if(p.left == null) return p.right;
            else if  (p.right == null) return p.left;
            else{
                //get data from the rightmost node in the left subtree
                p.data = retrieveData(p.left);
                //delete the rightmost node in the left subtree
                p.left = delete(p.left, p.data);
            }
        }
        return p;
    }

    private T retrieveData(Node<T> p){
        while (p.right != null){
            p=p.right;
        }
        return p.data;
    }

//Traversal
    public void perOrderTraversal(){
        preOrderHelper(root);
    }
   
    public void preOrderHelper(Node r){
        if( r != null){
           System.out.println(r+" ");
           preOrderHelper(r.left);
           preOrderHelper(r.right);
        }
    }

    public void inOrderTraversal(){
        inOrderHelper(root);
    }
   
    public void inOrderHelper(Node r){
        if(r != null){
            inOrderHelper(r.left);
            System.out.println(r+" ");
            inOrderHelper(r.right);
        }
    }


//Height
    public int height(){
        return height(root);
    }
    
    public int height(Node<T> p){
        if(p == null){
            return 0;
        }else{
            return 1 + Math.max( height(p.left), height(p.right) );
        }

    }
    

//iterator
    public Iterator<T> iterator(){
        return new MyIterator();
    }
  
    //pre-order
    private class MyIterator implements Iterator<T>{
        Stack<Node<T>>stk = new Stack<Node<T>>();

        public MyIterator(){
            if(root != null) stk.push(root);
        }

        public boolean hasNext(){
            return !stk.isEmpty();
        }

        public T next(){
            Node<T> cur = stk.peek();
            if(cur.left != null){
                stk.push(cur.left);
            }else {
                Node<T> tmp = stk.pop();
                while( tmp.right == null) {
                    if(stk.isEmpty()) return cur.data;
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }
           return cur.data;
        }
       
        public void remove(){

        } 


    }



    private class Node<T>{
        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r){
            left = l; right = r;
            this.data = data;
        }

        public Node(T data){
            this(data, null, null);
        }
        public String toString(){
            return data.toString();
        }
    }

}


class MyComp1 implements Comparator<Integer>{

    public int compare(Integer x, Integer y){
        return y-x;

    }

}
