package QuanLy_Diem_Thi_Dai_Hoc;

public class FactoryBlock extends Student{
    public FactoryBlock() {
    }
    public static Student createBlock(int choice,int id, String name, String address, double priorityArea){
        Student student;
        switch (choice){
            case 1-> student = new Khoi_A( id,  name,  address,  priorityArea);
            case 2-> student = new Khoi_B( id,  name,  address,  priorityArea);
            case 3-> student = new Khoi_C( id,  name,  address,  priorityArea);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return student;
    }
}
