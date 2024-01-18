package lab1;
import lab1.MyFirstPackage.MySecondClass;

public class MyFirstClass3 {
    public static void main(String[] args) {
        MySecondClass myObject = new MySecondClass(5, 10);
        myObject.setValue(0, 1000);
        myObject.print();
    }
}