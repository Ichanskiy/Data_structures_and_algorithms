package part6;

public class DegreeRecursion {

    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        System.out.println(getDegreeRecursion(a, b));
    }

    private static int getDegreeRecursion(int a, int b){
        if (b == 1) {
            return a;
        }
        return getDegreeRecursion(a*a, b/2);
    }

}
