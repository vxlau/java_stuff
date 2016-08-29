public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
   
    public void add(T element){
        Node<T> nd = new Node<T>();
        nd.setValue(element);

        if(head == null){
            head = nd;
            tail = nd;
        } else {  //add to  end
            tail.setNextRef(nd);
            tail  = nd;
        }
        
    } 
     
    public void addAfter(T element, T after){
        Node<T> tmp = head;
        Node<T> refNode = null;
       
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node<T> nd = new Node<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp==tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
        } else {
            System.out.println("Unable to find the given element");
        }

    }
    
    public void deleteFront(){
        if(head == null){
            System.out.println("list is empty");
        }else {
            Node<T> tmp = head;
            head = tmp.getNextRef();
            if(head == null) {
                tail = null;
            }
        }
    }    
    
    public void deleteAfter(T after) {
        Node<T> tmp = head;
        Node<T> refNode = null;

        while(true){  //just to find the target
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0) {
                refNode = tmp;
                break;
            }
            tmp= tmp.getNextRef();
        }
        if(refNode != null) {
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
        } else {
            System.out.println("unable to find element");
        }
    }

    public void delete(T element){
        Node<T> tmp = head;
        Node<T> prev = head;

        while(true) {
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(element) == 0) {
                prev.setNextRef(tmp.getNextRef());
                if(prev.getNextRef() == null){
                    tail = prev;
                }
                break;
            }

            prev = tmp;
            tmp=tmp.getNextRef();
        }
        if(prev == null){
            System.out.println("unable to find element");
        }
    }

    public void traverse(){
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }


    public static void main (String args[]) {
        MyLinkedList<String> mll = new MyLinkedList<String>();

        mll.add("hi");
        mll.add("hello");
        mll.addAfter("after", "hi");
        mll.deleteFront();
        mll.deleteAfter("after");
        mll.add("another");
        mll.add("another2");
        //mll.delete("another"); 
        mll.traverse();


    }


}


class Node<T> implements Comparable<T>{
    private T value;
    private Node<T> nextRef ;

    public T getValue(){
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void setNextRef(Node<T> ref){
        nextRef = ref;
    }

    public Node<T> getNextRef() {
        return nextRef;
    }

    @Override
    public int compareTo(T arg) {
        if( arg == this.value){
            return 0;
        } else {
            return 1;
        }        
    }


}

