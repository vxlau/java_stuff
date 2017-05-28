




public class MyBST <T extends Comparable<T> > implements Iterable<T>{
    private Node<T> root;
    

    public static void main(String[] args){
        
    }

//Insert - telling parent that it has a child
    public void insert(T data){m
        root = insert(root, data);
    }    
    private Node<T> insert( Node<T> p, T toInsert) {
        if (p == null) {
            return new Node<T>(toInsert);
        }
        if (compare (toInsert, p.data) == 0){
            return p;
        }

        if (
    }


    private void Node<T> {
        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r){
            left = l; right =r;
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
