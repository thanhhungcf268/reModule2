package QuanLy_Diem_Thi_Dai_Hoc;

import java.util.Scanner;

public class Khoi_C extends Student  {
    private double literature;
    private double history;
    private double geography;
    Scanner sc = new Scanner(System.in);

    public Khoi_C(int id, String name, String address, double priorityArea) {
        super(id, name, address, priorityArea);
        enterInformationKhoi_C();
    }



    public Khoi_C enterInformationKhoi_C() {
        try {
            System.out.println(" bạn đã chọn khối C ");
            System.out.println(" nhập điểm văn : ");
            literature = sc.nextDouble();
            System.out.println(" nhập điểm sử : ");
            history = sc.nextDouble();
            System.out.println(" nhập điểm địa : ");
            geography = sc.nextDouble();
        } catch (Exception e) {
            System.out.println(" Nhập đúng kiểu dữ liệu !!! ");
            sc.nextLine();
            return enterInformationKhoi_C();
        }
        return this;
    }

    public String toStrings() {
        return " Thi Khoi_C " +
                " Literature : " + literature +
                " history : " + history +
                " geography : " + geography;
    }

    @Override
    public String toString() {
        return super.toString()+" Thi Khoi_C " + "\n" +
                " Literature : " + literature + "\n" +
                " history : " + history + "\n" +
                " geography : " + geography + "\n";
    }

}
