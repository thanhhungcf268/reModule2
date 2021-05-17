package QuanLy_Diem_Thi_Dai_Hoc;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    static void menu() {
        System.out.println("""
                nhập lựa chọn của bạn ?\s
                1. Hiển thị thông tin của các thí sinh !\s
                2. Sắp xếp thí sinh theo họ tên\s
                3. Tìm kiếm 1 thí sinh theo id \s
                4. Chỉnh sửa thông tin của 1 thí sinh\s
                5. Xóa thông tin của một thí sinh\s
                6. Nhập thông tin của thí sinh\s
                7. Tổng số lượng thí sinh\s
                8. Save\s
                9. Save Object\s
                10. read Object\s
                0. Thoát\s""".indent(1));
    }

    static void menus() {
        System.out.println("""
                 1. Hiển thị tất cả\s
                 2. Hiển thị khối A\s
                 3. Hiển thị khối B\s
                 4. Hiển thị khối C\s
                """);
    }

    static void selections(Admissions admissions) {
        int choice = getChoices();
        switch (choice) {
            case 1 -> admissions.displayInformationStudent();
            case 2 -> admissions.displayInformationBlockA();
            case 3 -> admissions.displayInformationBlockB();
            case 4 -> admissions.displayInformationBlockC();
            default -> {
                System.out.println(" Chỉ nhập từ khoảng 1 -> 4 ! ");
                selections(admissions);
            }
        }
    }

    private static int getChoices() {
        int choice;
        System.out.println(" Enter number ! ");
        try {
             choice = scanner.nextInt();
        }catch (Exception e){
            System.err.println(" Nhập đúng kiểu dữ liệu");
            System.out.println(" Nhập lại ! ");
            scanner.nextLine();
            return getChoices();
        }
        return choice;
    }

    static void selection(Admissions admissions, AddFileText addFileText) {
        int choice = 0;
        do {
            menu();
            choice = getChoice(admissions, addFileText, choice);
            switch (choice) {
                case 1 -> {
                    menus();
                    selections(admissions);
                }
                case 2 -> admissions.selectionSort();
                case 3 -> admissions.displayAInformationStudentById();
                case 4 -> admissions.editInformationOfAStudent();
                case 5 -> admissions.deleteAStudent();
                case 6 -> admissions.enterInformationStudent();
                case 7 -> admissions.size();
                case 8 -> addFileText.addFile(admissions);
                case 9 -> addFileText.addObjectFile(admissions);
                case 10 -> addFileText.readObjectFile();
            }
        } while (choice != 0);
    }

    private static int getChoice(Admissions admissions, AddFileText addFileText, int choice) {
        try {
            choice = scanner.nextInt();
        }catch (Exception e){
            System.err.println(" Nhập đúng kiểu dữ liệu số nguyên ! ");
            scanner.nextLine();
            selection(admissions, addFileText);
        }
        return choice;
    }

    public static void main(String[] args) {
        Admissions admissions = new Admissions();
        AddFileText addFile = new AddFileText();
        selection(admissions, addFile);

    }
}
