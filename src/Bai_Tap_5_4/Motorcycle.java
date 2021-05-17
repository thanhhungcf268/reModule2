package Bai_Tap_5_4;

import java.util.Scanner;

public class Motorcycle extends Vehicle{
    private String capacity;
    Scanner sc = new Scanner(System.in);
//    public Motorcycle(Vehicle vehicle){
//        super(vehicle);
//        setCapacity(sc.nextLine());
//    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "capacity='" + capacity + '\'' +
                '}';
    }
}
