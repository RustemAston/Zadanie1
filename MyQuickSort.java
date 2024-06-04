import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyQuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(6, 5, 1, 3, 8, 4, 7, 9, 2));
        quickSort(list, 0, list.size()-1);
        System.out.println("compare using Comparable interface - " + list);
        System.out.println("******************************************************");
        quickSort(list, 0, list.size()-1, (o1, o2) -> o1.compareTo(o2));
        System.out.println("compare using Comparator - " + list);
    }

    public static <E extends Comparable<E>> void quickSort(List<E> list, int low, int high) {
        int i = low;
        int j = high;
        E pivot = list.get((i+j)/2);

        while (i <= j) {

            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (list.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                if (i < j) {
                    E temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
                i++;
                j--;
            }
        }

        if (i < high) {
            quickSort(list, i, high);
        }
        if (low < j) {
            quickSort(list, low, j);
        }
    }

//    static Comparator<? super E> comparator = ;

    public static <E> void quickSort(List<E> list, int low, int high, Comparator<? super E> comparator) {
        int i = low;
        int j = high;
        E pivot = list.get((i+j)/2);

        while (i <= j) {

            while (comparator.compare(list.get(i), pivot) < 0) {
                i++;
            }

            while (comparator.compare(list.get(j), pivot) > 0) {
                j--;
            }

            if (i <= j) {
                if (i < j) {
                    E temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
                i++;
                j--;
            }
        }

        if (i < high) {
            quickSort(list, i, high, comparator);
        }
        if (low < j) {
            quickSort(list, low, j, comparator);
        }
    }
}