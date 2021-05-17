package Bai_Tap_5_4;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private String manufacturer;
    private int yearOfManufacture;
    private int price;
    private String colorOfVehicle;

    public Vehicle() {
    }

    public Vehicle(String manufacturer, int yearOfManufacture, int price, String colorOfVehicle) {
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.colorOfVehicle = colorOfVehicle;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColorOfVehicle() {
        return colorOfVehicle;
    }

    public void setColorOfVehicle(String colorOfVehicle) {
        this.colorOfVehicle = colorOfVehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", colorOfVehicle='" + colorOfVehicle + '\'' +
                '}';
    }
}
