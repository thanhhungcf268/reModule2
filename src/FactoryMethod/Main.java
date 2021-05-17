package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        ShapeFactory.getShape("Circle").draw();
    }
}
