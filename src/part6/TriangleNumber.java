package part6;

public class TriangleNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(calculateTriangleNumber(n));
    }

    private static int calculateTriangleNumber(int indexNumber){
        if (indexNumber == 1) {
            return indexNumber;
        }
        return (indexNumber + calculateTriangleNumber(indexNumber - 1));
    }
}
