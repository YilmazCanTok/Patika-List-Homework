import java.util.ArrayList;
import java.util.List;

public class MyList<T>{
    private int capacity = 10; // array initial value
    private T[] array;
    private int index = 0;

    public MyList() {
        this.array = (T[])new Object[capacity];
    }
    public MyList(int number){
        this.capacity=number;
    }
    public int size(){
        return index;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T input){
        if(index == this.capacity){
            T[] newArray = (T[]) new Object[capacity * 2];
            int i = 0;
            for (T arr : this.array) {
                newArray[i] = arr;
                i++;
            }
            this.array = newArray;
            this.capacity = this.capacity*2;
        }
        array[index] = input;
        index++;
    }
    public T get(int input){
        if(input < 0 || input>this.index){
            return null;
        }else{
            return array[input];
        }
    }
    public T remove(int input){
        this.index--;
        if(input < 0 || input>this.index){
            return null;
        }else{
            T deleteIndexValue = this.array[input];
            for (int i = input; i<this.index; i++){
                this.array[i] = this.array[i+1];
            }
            this.array[size()] = null;
            return deleteIndexValue;
        }
    }
    public T set(int input, T data){
        if(input < 0 || input>this.index){
            return null;
        }else{
            T setIndexValue = this.array[input];
            this.array[input] = data;
            return setIndexValue;
        }
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(T data : this.array){
            if(data!=null){
                stringBuilder.append(data.toString() + ",");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    public int indexOf(T data){
        int dataIndex = 0;
        boolean isThere = false;
        for(T arr : this.array){
            if(arr == data){
                isThere = true;
                break;
            }
            dataIndex++;
        }
        return isThere == true ? dataIndex : -1;
    }
    public int lastIndexOf(T data){
        int dataIndex = 0;
        int lastIndex = 0;
        boolean isThere = false;
        for(T arr : this.array){
            if(arr == data){
                isThere = true;
                lastIndex = dataIndex;
            }
            dataIndex++;
        }
        return isThere == true ? lastIndex : -1;
    }
    boolean isEmpty(){
        return index == 0 ? true : false;
    }
    public T[] toArray(){
        return this.array;
    }
    public void clear(){
        this.index = 0;
        this.capacity = 10;
        T[] newArray = (T[]) new Object[this.capacity];
        this.array = newArray;
    }
    public MyList<T> sublist(int begin,int finish){
        MyList<T> newMyList = new MyList<>();
        for(int i = begin+1; i<finish; i++){
            newMyList.add(this.array[i]);
        }
        return newMyList;
    }
    public boolean contains(T input){
        boolean isThere = false;
        for(T data : this.array){
            if(data == input){
                isThere = true;
            }
        }
        return isThere;
    }
}
