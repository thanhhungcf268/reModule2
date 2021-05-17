package ManageList;


import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;
    private int Class;
    private double scout;
    public Student(){}
    public Student(int id, String name, String address, int Class,double scout) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.Class = Class;
        this.scout = scout;
    }

    public void setObject(int Class) {
        this.Class = Class;
    }
    public int getClassS(){
        return Class;
    }

    public double getScout() {
        return scout;
    }

    public void setScout(double scout) {
        this.scout = scout;
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

    @Override
    public String toString() {
        return "Student[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", Class=" + Class +
                ", scout=" + scout +
                ']';
    }
}
