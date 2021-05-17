package Bai_Tap_5_4;

import java.util.Scanner;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String engineType;
    Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                ", engineType='" + engineType + '\'' +
                '}';
    }

//    public Car(Vehicle vehicle){
//        super(vehicle);
//        setEngineType(sc.nextLine());
//        setNumberOfSeats(sc.nextByte());
//    }


    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
