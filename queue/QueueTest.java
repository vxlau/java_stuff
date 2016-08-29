/* Queue is an interface. You can't instantiate an interface directly*/

import java.util.*;

class QueueTest {


    public static void  main(String[] args){
        Queue<String> q = new LinkedList<String>();
 
        q.add("Hello");
        q.add("yes");
        String removedItem = q.remove();
        System.out.println(q);
        System.out.println(removedItem);


    }




   
}
