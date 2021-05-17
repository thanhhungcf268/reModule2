package QuanLy_Diem_Thi_Dai_Hoc;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;
    private double priorityArea;

    public Student() {
    }

    public Student(int id, String name, String address, double priorityArea) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.priorityArea = priorityArea;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPriorityArea() {
        return priorityArea;
    }

    public void setPriorityArea(double priorityArea) {
        this.priorityArea = priorityArea;
    }
    public String displayKhoi_A(){
        return
                " id : " + id +","+
                        " name : " + name +","+
                        " address : " + address +","+
                        " priorityArea : " + priorityArea +","+((Khoi_A)this).toStrings();
    }
    public String displayKhoi_B(){
        return
                " id : " + id +","+
                        " name : " + name +","+
                        " address : " + address +","+
                        " priorityArea : " + priorityArea +","+((Khoi_B)this).toStrings();
    }
    public String displayKhoi_C(){
        return
                " id : " + id +","+
                        " name : " + name +","+
                        " address : " + address +","+
                        " priorityArea : " + priorityArea +","+((Khoi_B)this).toStrings();
    }
    @Override
    public String toString() {
        return
                " id : " + id + "\n"+
                " name : " + name + "\n" +
                " address : " + address + "\n" +
                " priorityArea : " + priorityArea +
                "\n";
    }

}
