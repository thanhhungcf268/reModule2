package CaseStudy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Manage {
    static String use1 = "";
    private HashMap<String, String> map = new HashMap<>();
    private Admin admin = new Admin();
    private Use uses = new Use();

    public void Manages() throws Exception {
        uses.updateFileTotal();
        getUses();
        admin.updateReadFile();
        dangNhap_Dangky(admin, uses);
    }

    private void dangNhap_Dangky(Admin admin, Use uses) throws Exception {
        update();
        try {
            int choice = 0;
            do {
                System.out.println("1. Đăng ký ");
                System.out.println("2. Đăng nhập ");
                System.out.println(BlockStatic.EXIT);
                choice = BlockStatic.sc.nextInt();

                if (choice == 1) {
                    BlockStatic.sc.nextLine();
                    registration();
                } else if (choice == 2) {
                    BlockStatic.sc.nextLine();
                    power(logIn(), admin, uses);
                }
//                else
//                    if (choice == 3) {
//                    for (Map.Entry<String, String> s : map.entrySet()) {
//                        System.out.println(s.getKey() + " giá trị " + s.getValue());
//                    }
//                }
            } while (choice != 0);
            System.exit(0);
        } catch (Exception e) {
            System.err.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            dangNhap_Dangky(admin, uses);
        }

    }

    private void dang_ky() {

    }

    private void power(int a, Admin admin, Use use) throws Exception {
        if (a == -1) {
            return;
        }
        switch (a) {
            case 1 -> {
                System.out.println(" Hello Admin ");
                switchCase(admin, use);
            }
            case 2 -> {
                System.out.println(" Hello "+ use1);
                lech_Use(use);
            }
        }
    }

    private void lech_Use(Use use) {
        try {
            int choice;
            do {
                System.out.println(BlockStatic.ENTER_THE_OPTION);
                System.out.println("1. xem hàng");
                System.out.println("2. mua hàng");
                System.out.println("3. Xem giỏ hàng");
                System.out.println("4. đổi mật khẩu ");
                System.out.println(BlockStatic.EXIT);
                choice = BlockStatic.sc.nextInt();
                if (choice == 1) {
                    use.showHang();
                } else if (choice == 2) {
                    use.ro_Hang();
                    admin.updateFile();
                } else if (choice == 3) {
                    use.showTheRow();
                } else if (choice == 4) {
                    BlockStatic.sc.nextLine();
                    editPW();
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.err.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            lech_Use(use);
        }

    }

    private void update() throws Exception {
        uses.setList(admin.getList());
    }

    private void updatesFileUse() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserDatas.txt"));
            oos.writeObject(map);
            oos.close();
        } catch (Exception e) {
            System.err.println(BlockStatic.FILE_ERROR_WRITER);
        }

    }

    private void getUses() {
        try {
            File f = new File("UserDatas.txt");
            if (!f.isFile() || f.length() == 0) {
                map.put("admin", "admin");
                return;
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserDatas.txt"));
            map = (HashMap<String, String>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.err.println(BlockStatic.ERROR_FILE_READ);
        }
    }

    private int logIn() throws Exception {
        System.out.println(BlockStatic.ENTER_LOGIN);
        String use = BlockStatic.sc.nextLine();
        System.out.println(BlockStatic.PASSWORD);
        String password = BlockStatic.sc.nextLine();
        int k = -1;
        if (!map.containsKey(use)) {
            System.out.println(" Tên đăng nhập không tồn tại ");
            return -1;
        }

        for (Map.Entry<String, String> m : map.entrySet()) {
            if (m.getKey().equals(use) && use.equals(BlockStatic.ADMIN)) {
                if (m.getValue().equals(password)) {
                    k = 1;
                    use1 = use;
                    break;
                } else {
                    System.out.println(BlockStatic.WRONG_PASSWORD);
                }
            }
            if (m.getKey().equals(use) && !use.equals(BlockStatic.ADMIN)) {
                if (m.getValue().equals(password)) {
                    k = 2;
                    use1 = use;
                    break;
                } else {
                    System.out.println(BlockStatic.WRONG_PASSWORD);
                }
            }
        }
        return k;
    }

    private void registration() throws Exception {
        System.out.println(BlockStatic.ENTER_LOGIN);
        String use = BlockStatic.sc.nextLine();
        System.out.println(BlockStatic.PASSWORD);
        String password = BlockStatic.sc.nextLine();
        if (!map.containsKey(use)) {
            System.out.println(" Bạn đã đăng ký thành công ! ");
            map.put(use, password);
            updatesFileUse();
        } else {
            System.out.println(" Tài khoản đã tồn tại ");
        }
    }

    private void menu() {
        System.out.println(BlockStatic.ENTER_THE_OPTION);
        System.out.println("1. Thêm sản phẩm mới ");
        System.out.println("2. Nhập thêm hàng ");
        System.out.println("3. Xem danh mục sản phẩm ");
        System.out.println("4. Quản lý nhân sự ");
        System.out.println("5. add FIle CSV ");
        System.out.println("6. Đọc FIle CSV ");
        System.out.println("7. Tính doanh thu ");
        System.out.println("8. xóa tài khoản thành viên ");
        System.out.println("9. danh sách thành viên ");
        System.out.println("10. đổi mật khẩu ");
        System.out.println(BlockStatic.EXIT);
    }

    private void add() {
        System.out.println(BlockStatic.ENTER_THE_OPTION);
        System.out.println(BlockStatic.COCA);
        System.out.println(BlockStatic.PEPSI);
        System.out.println(BlockStatic.ORANGE);
        System.out.println(BlockStatic.EXIT);
    }

    private void switchCaseS(Admin admin) throws Exception {
        try {
            int choice;
            do {
                add();
                choice = BlockStatic.sc.nextInt();
                switch (choice) {
                    case 1 -> admin.addCOca(choice);
                    case 2 -> admin.addPepsi(choice);
                    case 3 -> admin.addOrange(choice);
                }
            } while (choice != 0);
            admin.updateFile();
        } catch (Exception e) {
            System.err.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            switchCaseS1(admin);
        }
    }

    private void switchCaseS1(Admin admin) throws Exception {
        try {
            int choice;
            do {
                add();
                choice = BlockStatic.sc.nextInt();
                switch (choice) {
                    case 1 -> admin.addNewCoca(choice);
                    case 2 -> admin.addNewPepsi(choice);
                    case 3 -> admin.addNewOrange(choice);
                }
            } while (choice != 0);
            admin.updateFile();
        } catch (Exception e) {
            System.err.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            switchCaseS1(admin);
        }

    }

    private void menuAdmin() {
        System.out.println(BlockStatic.ENTER_THE_OPTION);
        System.out.println("1. Thuê thêm nhân viên ");
        System.out.println("2. Chỉnh sửa thông tin nhân viên ");
        System.out.println("3. Xa thải nhân viên ");
        System.out.println("4. Xem danh sách nhân viên ");
        System.out.println(BlockStatic.EXIT);
    }

    private void swAdmin() {
        try {
            int choice;
            do {
                menuAdmin();
                choice = BlockStatic.sc.nextInt();
                switch (choice) {
                    case 1 -> admin.addStaff();
                    case 2 -> admin.editStaff();
                    case 3 -> admin.remove();
                    case 4 -> admin.showList();
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.out.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            swAdmin();
        }
    }

    private void switchCase(Admin admin, Use use) throws Exception {
        try {
            int choice;
            do {
                menu();
                choice = BlockStatic.sc.nextInt();
                switch (choice) {
                    case 1 -> switchCaseS1(admin);
                    case 2 -> switchCaseS(admin);
                    case 3 -> admin.Show();
                    case 4 -> swAdmin();
                    case 5 -> admin.addFileCSV();
                    case 6 -> admin.readFileCSV();
                    case 7 -> admin.setTotal();
                    case 8 -> {
                        System.out.println(" Nhập tài khoản muốn xóa ");
                        BlockStatic.sc.nextLine();
                        String stri = BlockStatic.sc.nextLine();
                        deleteUse(stri);
                    }
                    case 9 -> showUse();
                    case 10 -> {
                        BlockStatic.sc.nextLine();
                        editPW();
                    }
                }
            } while (choice != 0);
            admin.updateFile();
            dangNhap_Dangky(admin, use);
        } catch (Exception e) {
            System.err.println(BlockStatic.ENTER_TYPE);
            BlockStatic.sc.nextLine();
            switchCase(admin, use);
        }

    }

    private void editPW() {
        System.out.println(" nhập mật khẩu cũ");
        String stri = BlockStatic.sc.nextLine();
        if (stri.equals(map.get(use1))) {
            System.out.println(" nhập mật khẩu muốn mới");
            stri = BlockStatic.sc.nextLine();
            map.replace(use1, stri);
            updatesFileUse();
            System.out.println(" đổi mk thành công !");
        } else {
            System.out.println(" sai mật khẩu");
        }
    }

    private void deleteUse(String stri) {
        if (map.containsKey(stri)) {
            map.remove(stri);
            updatesFileUse();
            System.err.println(" xóa thành công ! ");
        } else {
            System.err.println(" không có tài khoản này ! ");
            System.out.println(" Nhập tài khoản muốn xóa ");
            System.out.println(" enter nếu muốn thoát ! ");
            stri = BlockStatic.sc.nextLine();
            if (!Pattern.matches("", stri)) {
                deleteUse(stri);
            }
        }
    }

    private void showUse() {
        if (map.size() == 1) {
            System.out.println(" chưa có thành viên nào ");
            return;
        }
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (m.getValue().equals("admin")) {
                continue;
            }
            System.out.println(" Use :" + m.getKey() + " Password : " + m.getValue());
        }
    }
}
