import java.util.Arrays;

public class MyArrayList<type> {
    private Object[] myStore;
    private int actSize = 0;

    public MyArrayList(){
        myStore = new Object[10];
    }

    public void add(type obj){
        if(myStore.length - actSize <= 5){
            increaseListSize();
        }
        myStore[actSize++] = obj;
    }

    public void set(int index, type obj){
        if (index < actSize){
            myStore[index] = obj;
        }else{
            System.out.println("index out of bound");
        }
    }

    @SuppressWarnings("unchecked")
    public type get(int index){
        if( index < actSize ){
            return (type) myStore[index];
        } else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    public type remove(int index){
        if (index < actSize){
            type obj = (type) myStore[index];
            myStore[index] = null;
            int tmp = index;
            while(tmp < actSize){
                myStore[tmp] = myStore[tmp +1];
                myStore[tmp+1] = null;
                tmp++;
            }
            actSize--;
            return obj;
        } else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size(){
        return actSize;
    }

    private void increaseListSize(){
        myStore = Arrays.copyOf(myStore, myStore.length*2);
        //System.arraycopy(myStore, 0, myStore, 0, myStore.length*2);
        //System.arraycopy(src, 0, dest, 0, myStore.length*2);
    }


    public static void main (String[] args){
        MyArrayList<String> mylist = new MyArrayList<String>();
        mylist.add("hello");
        System.out.println(mylist.get(0));  
    }

}
