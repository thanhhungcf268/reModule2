package FactoryMethod;

public class ShapeFactory {
    public static Shape getShape(String str){
        Shape a = null;
        switch (str){
            case "Circle"->a= new Circle();
            case "Square"-> a =new Square();
            case "Rectangle"-> a=new Rectangle();
        }
        return a;
    }
}
