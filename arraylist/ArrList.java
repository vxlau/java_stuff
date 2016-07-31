/*
boolean add(Element e)  adds to end of list
void add(int index, element e)
void clear()

E remove(int index)   //remove element at specificed position
protected void removeRange (int start, int end)


Object[] toArray()  returns array

E get(int index)

E set(int index, E element)

boolean contains (object o)
int indexOf(object o)  //return index of first occurrence. Return -1 if not found

Iterator iterator()
it.next();
it.hasNext();
it.previous();
ListIterator listIterator

boolean isEmpty()
int size()
*/

import java.util.ArrayList;
import java.util.Iterator;

public class ArrList {
    public static void main (String[] args) {
        ArrayList<String> mylist = new ArrayList<String>();
  
        System.out.println(mylist.isEmpty() );
        mylist.add("hello");
        mylist.add("hello2");
        System.out.println(mylist);

        System.out.println(mylist.size());            

        Iterator<String> it = mylist.iterator();
        System.out.println(it.next());
        System.out.println(it.next()); 
 
    }


}
