public class Person {
    private int[] a;
    public Person(){
    }
    public void setA(int[] a){
        this.a = a.clone();
    }
    public void getA(){
        for (int s : a){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
