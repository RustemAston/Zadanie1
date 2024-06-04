import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Own realization of ArrayList class by Shaikhutdinov Rustem
 */
public class _MyArrayList<T>{

    private int arrFullSize = 10;
    private T[] arr;
    private int arrInner = 0;

    public _MyArrayList() {
        arr = (T[]) new Object[arrFullSize];
    }

    public _MyArrayList(int capacity) {
        if (capacity < 0)
            arr = (T[]) new Object[arrFullSize];

        arr = (T[]) new Object[capacity];
    }

    /**
     * method returns actual size of MyArrayList
     */
    public int quantity(){
        return arrInner;
    }

    /**
     * method allows to add new Object to MyArrayList
     * it will return true in case of successful adding
     */
    public boolean add(T obj){
        if (arrInner >= arr.length-1) {
            arrFullSize = (arrFullSize * 3) / 2 + 1;
            biggerArray(arrFullSize);
        }

        arr[arrInner++] = obj;
        return true;
    }

    /**
     * method allows to add new Object to MyArrayList by pointed index
     */
    public void add(int ind, T obj){
        T[] newArr;
        if ( ind >= arrInner ) {
            biggerArray(arrFullSize);
            arr[arrInner++] = obj;
        } else {

            newArr = (T[]) new Object[++arrFullSize];

            for (int i = 0; i < ind; i++){
                newArr[i] = arr[i];
            }

            newArr[ind] = obj;

            for (int i = ind+1; i < arr.length; i++){
                newArr[i+1] = arr[i];
            }
            arr = newArr;
        }
    }

    /**
     * method allows to get index of some specified object from MyArrayList
     */
    public int indexOf(T obj){
        int index = -1;
        for (int i = 0; i < arr.length; i++ ){
            if (arr[i] != null && arr[i].equals(obj)){
                index = i;
            }
        }
        return index;
    }

    /**
     * method allows to remove some specified object from MyArrayList
     */
    public boolean remove(T obj){
        int ind = indexOf(obj);
        if ( ind == -1) {
            return false;
        }

        arrInner--;
        arr = Arrays.stream(arr).filter(x -> x != arr[ind]).toArray(y -> (T[]) new Object[y+1]);
        return true;
    }

    /**
     * method allows to remove some specified object from MyArrayList by pointed index
     * it will return previous element (object) from MyArrayList
     */
    public T remove(int ind){
        if ( checkSize(ind))
            throw new IndexOutOfBoundsException();

        T previousObject = arr[ind];
        arrInner--;
        arr = Arrays.stream(arr).filter(x -> x != arr[ind]).toArray(y -> (T[]) new Object[y+1]);
        return previousObject;
    }

    /**
     * method allows to get some specified object from MyArrayList by pointed index
     */
    public T get(int ind){
        if ( checkSize(ind) )
            throw new IndexOutOfBoundsException();

        return arr[ind];
    }

    /**
     * method allows to change some specified object in MyArrayList to another one by index
     * it will return previous element (object) from MyArrayList
     */
    public T set(int ind, T obj){
        if ( checkSize(ind) )
            throw new IndexOutOfBoundsException();

        T previousObject = arr[ind];
        arr[ind] = obj;
        return previousObject;
    }

    /**
     * utilitarian method to check size of MyArrayList
     */
    public boolean checkSize(int ind){
        return ind >= arrInner;
    }

    /**
     * utilitarian method to make a copy of an existing array from the previous to the bigger one
     */
    public void biggerArray(int arrSize){
        T[] newArr = (T[]) new Object[arrSize];
        for(int i = 0; i < arr.length; i++)
            newArr[i] = arr[i];

        arr = newArr;
        this.arrFullSize = arrSize;
    }

    /**
     * utilitarian method to print the contents of MyArrayList
     */
    @Override
    public String toString() {
        return Arrays.stream(arr).filter(x -> !(x == null))
                .map(elem -> "" + elem).collect(Collectors.joining(", ", "[", "]"));
    }
}