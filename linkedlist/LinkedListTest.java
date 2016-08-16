import java.util.*;

public class LinkedListTest{

    public static void main(String args[]){
        LinkedList<String> ll = new LinkedList<String>();

        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("A");
        ll.addFirst("First");
        ll.addLast("Last");

       //while(ll.remove("A")){};
//        ll.remove("A"); //remove first A
        
        ll.remove(2);
        ll.removeLast();

        Object val = ll.get(0);
          
        System.out.println(ll);

        System.out.println( (String)val );

    }


}
