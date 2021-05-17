package CaseStady_Tuan;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        UserManage userManage = new UserManage();
        Scanner sc = new Scanner(System.in);

        userManage.addSomeObj();

        List<User> account = userManage.readAccFromFile();
        System.out.println("Đây là những acc và pass đã đăng ký từ trước");
        System.out.println(account);

        int order = -1;
        do {
            System.out.println();
            System.out.println("Enter");
            System.out.println("1: Log in");
            System.out.println("2: Register");
            System.out.println("______________");
            order = sc.nextInt();
            switch (order) {
                case 1:
                    account = userManage.readAccFromFile();
                    userManage.logIn(account);
                    break;
                case 2:
                    userManage.writeAccToFile();
                    break;
            }
        } while (order != 1 || order != 2);
    }
}
