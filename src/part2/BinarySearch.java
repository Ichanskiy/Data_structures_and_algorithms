package part2;

public class BinarySearch {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6};
        int array2[] = {7, 8, 9, 10, 11, 12};
        int lower = 0;
        int upper = array.length;
        int found = 2;
        int i = 0;

        while (true){
            int middle = lower + (upper - lower) / 2;
            System.out.println("iteration " + ++i);
            if (array[middle] == found){
                System.out.println("found = " + array[middle]);
                break;
            }
            if (found < array[middle]) {
                upper = middle;
            } else {
                lower = middle ;
            }
        }
        BinarySearch binarySearch = new BinarySearch();
        int[] arrayResult = binarySearch.consolidation(array,array2);
    }

    private int[] consolidation(int[] arrayFirst, int[] arraySecond){
        int[] arrayResult = new int[arrayFirst.length + arraySecond.length];
        int size = arraySecond.length;

        for (int i = 0; i < size+1; i++) {
            for (int j = 0; j < size; j++) {
                if (arrayFirst[j] < arraySecond[i]){
                    arrayResult[j+i] = arrayFirst[i];
                    break;
                }
                arrayResult[j+i] = arraySecond[i];
            }
        }
        return arrayResult;
    }
}
