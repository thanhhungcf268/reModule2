package QuanLy_Diem_Thi_Dai_Hoc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admissions implements Serializable {
    public static final String INPUT_0_OR_NUMBER = " nhập 0 nếu muốn thoát hoặc phím số bất kì nếu muốn nhập lại : ";
    public static final String SO_BAO_DANH = " nhập sai số báo danh \n";
    public static final String ENTER_NAME = " Nhập tên : ";
    public static final String ENTER_ADDRESS = " Nhập địa chỉ : ";
    public static final String SELECTION = " chọn vùng ưu tiên : ";
    public static final String CHOOSE = " 1. khu vực 1 là thành phố ( điểm ưu tiên 0 )\n";
    public static final String CHOOSE_TWO = " 2. khu vực 2 là nông thôn ( điểm ưu tiên 2.5 )";
    public static final String CHOOSE_OR_CHOOSE_TWO = " Hãy chọn 1 trong 2 khu vực bằng cách nhấn 1 hoặc 2 : ";
    public static final String ENTER_NUMBER = " Nhập dữ liệu dạng số ! ";
    public static final String ENTER_NUMBER_WANT_DELETE = " nhập số báo danh của của thí sinh muốn xóa : ";
    public static final String ENTER_NUMBER_WANT_EDIT = " nhập số báo danh của của thí sinh muốn sửa : ";
    public static final String ENTER_ID_SHOW = " nhập số báo danh của của thí sinh muốn hiển thị : ";
    public static final String ALL_SIZE_LIST = " Số lượng thí sinh cho đến thời điểm hiện tại là : ";
    public static final String ENTER_AT_LEAST_THREE_CHARACTER = " Nhập tối thiểu 3 ký tự ! ";
    public static final String ENTER_ONE_TWO_THREE_PLEASE = " vui lòng nhập 1, 2 hoặc 3 ! ";
    public static final String MENU_SELECTION_BLOCK = """
            Chọn khối bạn muốn thi : \s
            Nhập 1 : khối A\s
            Nhập 2 : khối B\s
            Nhập 3 : khối C""";
    Scanner sc = new Scanner(System.in);
    private final ArrayList<Student> list = new ArrayList<>();

    public void enterInformationStudent() {
        list.add(enterInformationStudents());
    }

    public void displayInformationStudent() {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    private void selectionListById() {
        int n = list.size();
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getId() < list.get(min_idx).getId()) {
                    min_idx = j;
                }
            }
            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            Student temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);

        }

    }

    private int findStudentById() {
        selectionListById();
        int id = sc.nextInt();
        int low = 0;
        int high = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            int mid = (low + high) / 2;
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(mid).getId() == id) {
                    return mid;
                }
                if (list.get(mid).getId() < id) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public void displayAInformationStudentById() {
        System.out.println(ENTER_ID_SHOW);
        int index = findStudentById();
        if (index == -1) {
            System.out.println(SO_BAO_DANH + INPUT_0_OR_NUMBER);
            index = sc.nextInt();
            if (index != 0) {
                displayAInformationStudentById();
            }
        } else {
            System.out.println(list.get(index));

        }

    }

    public void size() {
        System.out.println(ALL_SIZE_LIST + list.size());
    }


    public void selectionSort() {

        int n = list.size();
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getName().compareTo(list.get(min_idx).getName()) < 0) {
                    min_idx = j;
                }

            }
            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            Student temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);

        }
    }

    private int checkId() {
        int id;
        try {
            System.out.println(" Nhập số báo danh 5 số : ");
            id = sc.nextInt();
            for (Student list : list) {
                if (list.getId() == id) {
                    System.out.println("số báo danh đã tồn tại : ");
                    sc.nextLine();
                    return checkId();
                }
            }
            String str = Integer.toString(id);
            String relax = "^\\d{5}$";
            Pattern p = Pattern.compile(relax);
            Matcher m = p.matcher(str);
            if (!m.find()) {
                System.out.println(" Phải nhập đủ 5 số ");
                sc.nextLine();
                return checkId();
            }

        } catch (Exception e) {
            System.err.println(ENTER_NUMBER);
            sc.nextLine();
            return checkId();
        }
        return id;
    }

    private String checkAddress() {
        String address = sc.nextLine();
        String relax = "^\\D{3,}$";
        Pattern p = Pattern.compile(relax);
        Matcher m = p.matcher(address);
        if (m.find()) {
            return address;
        } else {
            System.out.println(ENTER_AT_LEAST_THREE_CHARACTER);
            return checkAddress();
        }
    }

    private Student enterInformationStudents() {
        int id = checkId();
        System.out.println(ENTER_NAME);
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println(ENTER_ADDRESS);
        String address = checkAddress();
        System.out.println(SELECTION);
        double priorityArea = priorityArea();
        int choice = blockSelection();
        return FactoryBlock.createBlock(choice, id, name, address, priorityArea);
    }

    private double priorityArea() {
        try {
            System.out.println(CHOOSE + CHOOSE_TWO);
            double index = sc.nextDouble();
            if (index == 1) {
                return 0;
            } else if (index == 2) {
                return 2.5;
            } else {
                System.out.println(CHOOSE_OR_CHOOSE_TWO);
                return priorityArea();
            }
        } catch (Exception e) {
            System.err.println(ENTER_NUMBER);
            sc.nextLine();
            return priorityArea();
        }

    }

    private int blockSelection() {
        try {
            System.out.println(MENU_SELECTION_BLOCK);
            int choice = sc.nextInt();
            if (choice == 1) {
                return 1;
            } else if (choice == 2) {
                return 2;
            } else if (choice == 3) {
                return 3;
            } else {
                System.out.println(ENTER_ONE_TWO_THREE_PLEASE);
                return blockSelection();
            }
        } catch (Exception e) {
            System.err.println(ENTER_NUMBER);
            sc.nextLine();
            return blockSelection();
        }

    }

    public void editInformationOfAStudent() {
        System.out.println(ENTER_NUMBER_WANT_EDIT);
        int index = findStudentById();
        if (index == -1) {
            System.out.println(SO_BAO_DANH +
                    INPUT_0_OR_NUMBER);
            index = sc.nextInt();
            if (index != 0) {
                editInformationOfAStudent();
            }
        } else {
            list.set(index, enterInformationStudents());
        }
    }

    public void displayInformationBlockA() {
        for (Student student : list) {
            if (student instanceof Khoi_A) {
                System.out.println(student);
            }
        }
    }

    public void displayInformationBlockB() {
        for (Student student : list) {
            if (student instanceof Khoi_B) {
                System.out.println(student);
            }
        }
    }

    public void displayInformationBlockC() {
        for (Student student : list) {
            if (student instanceof Khoi_C) {
                System.out.println(student);
            }
        }
    }

    public ArrayList<String> getStudent_String() {
        ArrayList<String> string = new ArrayList<>();
        for (Student student : list) {
            if (student instanceof Khoi_A) {
                string.add(student.displayKhoi_A());
            }
            if (student instanceof Khoi_B) {
                string.add(student.displayKhoi_B());
            }
            if (student instanceof Khoi_C) {
                string.add(student.displayKhoi_C());
            }
        }
        return string;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void deleteAStudent() {
        System.out.println(ENTER_NUMBER_WANT_DELETE);
        int index = findStudentById();
        if (index == -1) {
            System.out.println(SO_BAO_DANH +
                    INPUT_0_OR_NUMBER);
            ;
            index = sc.nextInt();
            if (index != 0) {
                deleteAStudent();
            }
        } else {
            list.remove(index);
        }
    }
}
