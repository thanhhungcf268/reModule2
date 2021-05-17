import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        new Main().passwordExample();
    }
    public void passwordExample() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        Scanner sc = new Scanner(System.in);
        String a =sc.nextLine();
        char[] passwordArray = console.readPassword(a);
        console.printf("Password entered was: %s%n", new String(passwordArray));

    }

}
