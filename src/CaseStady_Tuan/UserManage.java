package CaseStady_Tuan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManage extends FilmManage implements Serializable {
    public static final String USER_DATA = "UserData.txt";
    public static final String PASSWORDS_REGEX = "Passwords must be at least 6 characters";
    public static final String USERNAME_REGEX = "Username must be at least 6 characters";
    List<User> account = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addSomeObj() {
        filmList.add(film1);
        filmList.add(film2);
        filmList.add(film3);
    }

    public void logIn(List<User> account) throws IOException {
        System.out.println("LOG IN");
        System.out.println("Input username: ");
        String accountName = sc.next();
        for (User user : account) {
            if (accountName.equals(user.getUsername())) {
                System.out.println("Input password: ");
                String password = sc.next();
                if (password.equals(user.getPassword())) {
                    mainToy();
                } else {
                    System.out.println("Wrong password");
                }
            }
        }
    }

    public void writeAccToFile() throws IOException {
        account = readAccFromFile();
        account.add(inputAccount());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
        oos.writeObject(account);
        oos.close();
    }

    public List<User> readAccFromFile() {
        List<User> y = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USER_DATA));
            y = (List<User>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception ignored) {
        }
        return y;
    }

    public User inputAccount() {
        List<User> acc = readAccFromFile();
        System.out.println("New Account");
        String username = inputUserName(acc);
        String password = inputPassword();
        return new User(username,password);
    }

    public String inputPassword(){
        System.out.println("Input password: ");
        String password = sc.next();
        sc.nextLine();
        if (password.matches("(.*?){6,20}")) {
            return password;
        }else {
            System.out.println(PASSWORDS_REGEX);
            return inputPassword();
        }
    }

    public String inputUserName(List<User> acc) {
        System.out.println("Input new username: ");
        String username = sc.next();
        if (username.matches("(.*?){6,20}$")) {
            for (User user : acc) {
                if (user.getUsername().equals(username)) {
                    System.out.println("This username already exists");
                    return inputUserName(acc);
                }
            }
        } else {
            System.out.println(USERNAME_REGEX);
            return inputUserName(acc);
        }
        return username;
    }
}
