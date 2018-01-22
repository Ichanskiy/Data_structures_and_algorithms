package part6;

public class MergeSort {

    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC;
        arrayC = merge(arrayA, arrayB);
        display(arrayC);
    }

    private static int[] merge(int[] arrayA, int[] arrayB){
        int[] arrayC = new int[arrayA.length + arrayB.length];

        int indexA = 0, indexB = 0, indexC = 0;

        while (indexA < arrayA.length && indexB < arrayB.length){
            if (arrayA[indexA] < arrayB[indexB]) {
                arrayC[indexC] = arrayA[indexA];
                ++indexA;
                ++indexC;
            }else {
                arrayC[indexC] = arrayB[indexB];
                ++indexC;
                ++indexB;
            }
        }

        while (indexA < arrayA.length){
            arrayC[indexC] = arrayA[indexA];
            ++indexA;
            ++indexC;
        }

        while (indexB < arrayB.length){
            arrayC[indexC] = arrayB[indexB];
            ++indexB;
            ++indexC;
        }
        return arrayC;
    }

    private static void display(int[] array) {
        for (int anArray : array) System.out.print(anArray + " ");
    }
}
