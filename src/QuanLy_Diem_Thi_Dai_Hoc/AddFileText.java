package QuanLy_Diem_Thi_Dai_Hoc;

import java.io.*;
import java.util.List;

public class AddFileText {
    public void addFile(Admissions admissions) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\newFile.csv"));
            String[] str;
            for (int i = 0; i < admissions.getStudent_String().size(); i++) {
                str = admissions.getStudent_String().get(i).split(",");
                for (String s : str) {
                    bufferedWriter.write(s + ",");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addObjectFile(Admissions admissions){
        try {
            ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("source.txt"));
            oos.writeObject(admissions.getList());
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readObjectFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("source.txt"));
            List<Student> students = (List<Student>) ois.readObject();
            System.out.println(students);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
