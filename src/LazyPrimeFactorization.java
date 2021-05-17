import java.util.Scanner;

public class LazyPrimeFactorization implements Runnable{
    Scanner scanner = new Scanner(System.in);
    private int kl;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int n = 1000;
        int dem = 0;
        int i = 2;
        while (dem < n) {
            if (isPrimeNumber(i)) {
                System.out.println(i + " lp");
                dem++;
            }
            i++;
        }
        long stop = System.currentTimeMillis();
        System.out.println();
        System.out.println((stop-start+"  đây là lp :  "));

    }
    public  boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
