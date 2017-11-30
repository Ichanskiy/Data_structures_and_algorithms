package part3;

public class InsertionSort {

    public static void main(String[] args) {

        int array[] = {3, 2, 6, 5, 4, 1};
        int min, j;
        for(int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i + 1]) {
                min = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && min < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = min;
            }
        }
    }
}
