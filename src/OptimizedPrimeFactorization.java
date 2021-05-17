import java.util.Scanner;

public class OptimizedPrimeFactorization implements Runnable {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int n = 1000;
        int dem = 0;
        int i = 2;
        while (dem < n) {
            if (isPrimeNumber(i)) {
                System.out.println(i + " op");
                dem++;
            }
            i++;
        }
        long stop = System.currentTimeMillis();
        System.out.println();
        System.out.println((stop-start+ " đây là op :  "));
    }
    public  boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = n-1; i>=2; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
