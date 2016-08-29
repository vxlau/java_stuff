import java.util.*;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
 
        s.push("hello");
        s.push("ontop");
        s.pop();
        s.pop();
        s.empty();
        System.out.println(s);

        Stack s2 = new Stack();

        s2.push("Hello");
        s2.push(2);
        System.out.println(s2);


    }



}
