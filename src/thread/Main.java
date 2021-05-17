package thread;

public class Main {
    public static int DISTANCE = 100;

    public static int STEP = 2;

    public static void main(String[] args){
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        System.out.println("Distance: 100KM");
        carA.start();
//        carB.start();
//        carC.start();
    }
}