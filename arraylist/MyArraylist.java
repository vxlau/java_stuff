import java.util.Arrays;

public class MyArrayList {
    private Object[] myStore;
    private int actSize = 0;

    public MyArrayList(){
        myStore = new Object[10];
    }

    public void add(Object obj){
        if(myStore.length - actSize <= 5){
            increaseListSize();
        }
        myStore.[actSize++] = obj;
    }

    public void set(int index, Object obj){
        if (index < actSize){
            myStore[index] = obj;
        }else{
            System.out.println("index out of bound");
        }
    }

    public Object get(int index){
        if( index < actSize ){
            return myStore[index];
        } else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Object remove(int index){
        if (index < actSize){
            Object obj = myStore[index];
            myStore[index] = null;
            int tmp = index;
            while(tmp < actsize){
                myStore[tmp] = myStore[tmp +1];
                myStore[tmp+1] = null;
                tmp++;
            }
            actSize--;
        } else{
            throw new ArrayIndexOutOfBoundException();
        }
    }

    public int size(){
        return actSize;
    }

    private void increaseListSize(){
        myStore = Arrays.copyOf(myStore, myStore.length*2);
        //System.arraycopy(myStore, 0, myStore, 0, myStore.length*2);
    }


    public static void main (String[] args){
        
    }

}
