package QuanLy_Diem_Thi_Dai_Hoc;

import java.util.Scanner;

public class Khoi_A extends Student  {
    public static final String ENTER_MATHS = " nhập điểm toán : ";
    public static final String ENTER_PHYSICAL = " nhập điểm lý : ";
    public static final String ENTER_CHEMICAL = " nhập điểm hóa : ";
    private double maths;
    private double physical;
    private double chemical;
    Scanner sc = new Scanner(System.in);

    public Khoi_A(int id, String name, String address, double priorityArea) {
        super(id, name, address, priorityArea);
        enterInformationKhoi_A();
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemical() {
        return chemical;
    }

    public void enterInformationKhoi_A() {
        try {
            System.out.println(" bạn đã chọn khối A ");
            System.out.println(ENTER_MATHS);
            maths = sc.nextDouble();
            System.out.println(ENTER_PHYSICAL);
            physical = sc.nextDouble();
            System.out.println(ENTER_CHEMICAL);
            chemical = sc.nextDouble();
        }catch (Exception e){
            System.out.println(" Nhập đúng kiểu dữ liệu !!! ");
            sc.nextLine();
            enterInformationKhoi_A();
        }
    }
    public String toStrings() {
        return " Thi Khoi_A " +","+
                " maths : " + maths +","+
                " physical : " + physical +","+
                " chemical : " + chemical +",";
    }

    @Override
    public String toString() {
        return super.toString()+" Thi Khoi_A " +"\n"+
                " maths : " + maths + "\n"+
                " physical : " + physical +"\n"+
                " chemical : " + chemical +"\n";
    }

    public void setChemical(double chemical) {
        this.chemical = chemical;
    }
}
