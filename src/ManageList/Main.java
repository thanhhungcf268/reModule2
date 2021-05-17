package ManageList;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ManageListStudent mana = new ManageListStudent();
        mana.a();
        switchCase(mana);
    }
    static void menu(){
        System.out.println(" Nhập lựa chọn !!");
        System.out.println("""
                1. Xem danh sách toàn bộ sinh viên !\s
                2. Thêm thông tin một sinh viên !\s
                3. Cập nhật thông tin một sinh viên !\s
                4. Xóa một một sinh viên ! \s
                5. Sắp xếp lại sinh viên ! \s
                6. Tìm kiếm một sinh viên theo mã sinh viên !\s
                7. Thống kê số lượng sinh viên của từng lớp !\s
                8. SaveFile\s
                9. ReadFile\s
                10. Tìm kiếm những sinh viên có điểm cao nhất\s
                0. Thoát \s""");
    }
    static void switchCase(ManageListStudent mana){
        int choice;
        do {
            menu();
            choice = sc.nextInt();
            switch (choice){
                case 1->mana.showInFormationAllStudent();
                case 2->mana.addInFormationAStudent();
                case 3->mana.editInFormationAStudent();
                case 4->mana.deleteAStudentById();
                case 5->mana.useBubbleSort();
                case 6->mana.showAStudentInFormationById();
                case 7->mana.totalStudentByClass();
                case 8->mana.addFile();
                case 9->mana.showFile();
                case 10->mana.showStudentsHighScout();
            }
        }while (choice!=0);
    }
}
