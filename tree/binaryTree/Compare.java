public class Compare <T extends Comparable<T> > {
    private Node<T> first;
    private Node<T> second;

    private class Node<T extends Comparable<T> > {
        T data;
    }

    private void set(T fi, T si) {
       first.data = fi;
       second.data = si;
    }
    private void check() {

        int order = first.compareTo(second);
        System.out.println( order);
    }


    public static void main(String[] args) {
        Compare<String> s = new Compare<String>();

        s.set("apple", "bat");

        s.check();

    }




}
