package QuanLy_Diem_Thi_Dai_Hoc;

import java.io.Serializable;
import java.util.Scanner;

public class Khoi_B extends Student  {
    private double maths;
    private double physics;
    private double biology;
    Scanner sc = new Scanner(System.in);

    public Khoi_B(int id, String name, String address, double priorityArea) {
        super(id, name, address, priorityArea);
        enterInformationKhoi_B();
    }

    public Khoi_B enterInformationKhoi_B() {
        try {
            System.out.println(" bạn đã chọn khối B ");
            System.out.println(" nhập điểm toán : ");
            maths = sc.nextDouble();
            System.out.println(" nhập điểm hóa : ");
            physics = sc.nextDouble();
            System.out.println(" nhập điểm sinh : ");
            biology = sc.nextDouble();
        }catch (Exception e){
            System.out.println(" Nhập đúng kiểu dữ liệu !!! ");
            sc.nextLine();
            return enterInformationKhoi_B();
        }
        return this;
    }
    public String toStrings() {
        return " Thi Khoi_B " +","+
                " maths : " + maths +","+
                " physical : " + physics +","+
                " born : " + biology +",";
    }

    @Override
    public String toString() {
        return super.toString()+" Thi Khoi_B " +"\n"+
                " maths : " + maths +"\n"+
                " physical : " + physics +"\n"+
                " born : " + biology +"\n";
    }

}
