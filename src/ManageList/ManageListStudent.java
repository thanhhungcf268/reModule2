package ManageList;

import java.io.*;
import java.util.*;

public class ManageListStudent {
    Scanner sc = new Scanner(System.in);
    List<Student> list = new ArrayList<>();

    public void showInFormationAllStudent() {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void a() {
        list.add(new Student(10, "Thành", "Thanh hóa", 9, 10));
        list.add(new Student(11, "Tuấn", "Thanh hóa", 9, 11));
        list.add(new Student(15, "Đức", "Thanh hóa", 9, 9));
        list.add(new Student(12, "Tú", "Thanh hóa", 12, 9));
        list.add(new Student(9, "Vũ", "Thanh hóa", 12, 11));
    }

    public void addInFormationAStudent() {
        list.add(inFormationStudent());
    }

    public void editInFormationAStudent() {
        System.out.println(" Nhập mã sinh viên !");
        int id = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, inFormationStudent());
                return;
            }
        }
    }

    private Student inFormationStudent() {
        int id = checkId();
        sc.nextLine();
        System.out.println(" Nhập name");
        String name = sc.nextLine();
        System.out.println(" Nhập address");
        String address = sc.nextLine();
        System.out.println(" Nhập Class");
        int Class = sc.nextInt();
        System.out.println(" Nhập Scout");
        double scout = sc.nextInt();
        sc.nextLine();
        return new Student(id, name, address, Class, scout);
    }

    public void deleteAStudentById() {
        System.out.println(" Nhập mã sinh viên cần xóa !");
        int id = checkIds();
        for (int i=0;i<list.size();i++){
            if (id==list.get(i).getId()){
                list.remove(i);
                break;
            }
        }
    }

    public void useBubbleSort() {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1 - i; j++) {
                if (list.get(j).getScout() > list.get(j + 1).getScout()) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    private ArrayList<Student> findStudentsHighScout() {
        Student max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max.getScout() < list.get(i).getScout()) {
                max = list.get(i);
            }
        }
        ArrayList<Student> newList = new ArrayList<>();
        for (Student s : list) {
            if (s.getScout() == max.getScout()) {
                newList.add(s);
            }
        }
        return newList;
    }

    public void showStudentsHighScout() {
        for (Student s : findStudentsHighScout()) {
            System.out.println(s);
        }
    }
    private int checkIds(){
        int id;
        try {
            id = sc.nextInt();
            for (Student s : list){
                if (s.getId()==id){
                    return id;
                }
            }
        }catch (Exception e){
            System.err.println(" Nhập sai kiểu dữ liệu !");
            sc.nextLine();
            return checkIds();
        }
        System.out.println(" Mã sinh viên không tồn tại ! ");
        sc.nextLine();
        return checkIds();
    }
    private int checkId(){
        int id;
        try {
            System.out.println(" Nhập mã số sinh viên ! ");
            id = sc.nextInt();
            for (Student s : list){
                if (s.getId()==id){
                    sc.nextLine();
                    System.out.println(" Mã sinh viên đã tồn tại ! ");
                    return checkId();
                }
            }
        }catch (Exception e){
            System.err.println(" Nhập sai kiểu dữ liệu !");
            sc.nextLine();
            return checkId();
        }
        return id;
    }

    public void showAStudentInFormationById() {
        System.out.println(" Nhập mã sinh viên cần hiển thị ! ");
        int id = checkIds();
        for (int i=0;i<list.size();i++){
            if (id==list.get(i).getId()){
                useBubbleSort();
                System.out.println(findAStudentByIdUsBinary(0, list.size() - 1, (list.size() - 1) / 2, id));
                break;
            }
        }
    }


    private Student findAStudentByIdUsBinary(int low, int high, int mid, int id) {
        mid = (high + low) / 2;
        if (list.get(mid).getId() == id) {
            return list.get(mid);
        } else if (list.get(mid).getId() < id) {
            return findAStudentByIdUsBinary(low, high, low + 1, id);
        } else
            return findAStudentByIdUsBinary(low, high, high - 1, id);
    }

    public void totalStudentByClass() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Student student : list) {
            int key = student.getClassS();
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        for (Map.Entry<Integer, Integer> s : hashMap.entrySet()) {
            System.out.print(" Lớp : " + s.getKey()+" = " + s.getValue() + " học sinh \n");
        }

    }

    public void addFile() {
        try {
            FileOutputStream fos = new FileOutputStream("Student.txt");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(list);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student.txt"));
            list = (List<Student>) ois.readObject();
            showInFormationAllStudent();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
