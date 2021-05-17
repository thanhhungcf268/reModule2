import CaseStudy.Staff;
import com.observer.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check_dau_Ng_Tron {
    static String relax = "^\\D{5,}$";

    public static void main(String[] args) {
        String str = "((()))– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (sym == '(') {
                stack.push(sym);
            }
            if (sym == ')') {
                if (stack.isEmpty()) {
                    check = true;
                    break;
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        if (check||!stack.isEmpty()) {
            System.out.println("biểu thức sai");
        } else System.out.println(" biểu thức đúng");
    }
}
