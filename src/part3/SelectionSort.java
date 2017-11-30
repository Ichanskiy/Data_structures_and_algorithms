package part3;

public class SelectionSort {

    public static void main(String[] args) {

        int array[] = {3, 2, 3, 3, 2, 6, 5, 4, 1};
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                if (min >= array[j]) {
                    min = array[j];
                    array[j] = array[i];
                    array[i] = min;
                }
            }
        }
        for (int anArray : array) {
            System.out.println(anArray);
        }
    }
}
