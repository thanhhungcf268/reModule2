package Bai_Tap_5_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageVehicle {
    Scanner sc = new Scanner(System.in);
    private List<Vehicle> list = new ArrayList<>();

    private Truck addInformationOfTruck() {
        System.out.println(" Nhập trọng tải ! :");
        int payload = sc.nextInt();
        return new Truck(addInformationOfVehicle(),payload);
    }

//    private Car addInformationOfCar() {
//        sc.nextLine();
//        return new Car(addInformationOfVehicle());
//    }
//
//    private Motorcycle addInformationOfMotorcycle() {
//        return new Motorcycle(addInformationOfVehicle());
//    }

    private Vehicle addInformationOfVehicle() {
        Vehicle v = new Vehicle();
        System.out.println(" nhập màu xe");
        v.setColorOfVehicle(sc.nextLine());
        System.out.println(" nhập hãng sản xuất");

        v.setManufacturer(sc.nextLine());
        System.out.println(" nhập giá bán");

        v.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.println(" nhập năm sản xuất");

        v.setYearOfManufacture(sc.nextInt());
        sc.nextLine();
        return v;
    }

    private int selection() {
        return -1;
    }

    public void addInformationInList() {
        list.add(addInformationOfTruck());
    }

    public void showList() {
        for (Vehicle s : list) {
            System.out.println(s.toString());
        }
    }

    private int checkColor() {

        return checkColor();
    }

    public void showVehicleByColorAndManufacturer() {
        System.out.println(" Nhập màu cần tìm kiếm : ");
        sc.nextLine();
        String color = sc.nextLine();
        System.out.println(" Nhập hãng sản xuất ");
        String manufacturer = sc.nextLine();
        boolean b = true;
        for (Vehicle vehicle : list) {
            if (vehicle.getColorOfVehicle().equals(color) && vehicle.getManufacturer().equals(manufacturer)) {
                System.out.println(vehicle);
                b = false;
            }
        }
        if (b) {
            System.out.println(" Không có chiếc xe nào tìm thấy ! ");
        }
    }

    public void addFile() {
        ObjectOutputStream ois = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\Vehicle.txt");
            ois = new ObjectOutputStream(fos);
            ois.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null){
                    fos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void readFile() {
        try {
            ObjectInputStream fis = new ObjectInputStream(new FileInputStream("Vehicle.txt"));
            list = (List<Vehicle>) fis.readObject();
            fis.close();
            showList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
