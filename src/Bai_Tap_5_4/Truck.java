package Bai_Tap_5_4;

import java.io.Serializable;
import java.util.Scanner;

public class Truck extends Vehicle implements Serializable {
    private int payload;
    Scanner sc = new Scanner(System.in);


    public Truck(Vehicle vehicle, int payload) {
        super(vehicle.getManufacturer(), vehicle.getYearOfManufacture(), vehicle.getPrice(), vehicle.getColorOfVehicle());
        this.payload = payload;
    }

//    public Truck(Vehicle vehicle, int payload) {
//        super(vehicle);
//        this.payload = payload;
//    }

//    public Truck(Vehicle vehicle) {
//        super(vehicle);
//        System.out.println(" Nhập Trọng tải : ");
//        setPayload(sc.nextInt());
//    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload=" + payload +
                ", sc=" + super.toString() +
                '}';
    }
}
