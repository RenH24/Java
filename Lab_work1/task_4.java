Вынесите код класса MySecondClass без изменений в отдельный файл с именем MyFirstPackage.java, и поместите его в поддиректорию MyFirstPackage. Добейтесь работоспособности программы.

//MyFirstClass
import MyFirstPackage.MySecondClass;

class MyFirstClass {
    public static void main(String[] args) {
        MySecondClass myObject = new MySecondClass();
        int[] a = myObject.init(5, 50);
        myObject.newValue(a, 0, 4);
        myObject.print(a);
    }
}

//MySecondClass
package MyFirstPackage;

import java.util.Random;
import java.util.Scanner;

public class MySecondClass {
    public static void main(String[] args) {
        int[] mas = new int[5];
        gettingValue(mas, 3);
        newValue(mas, 2, 4);
        init(10, 99);
        print(init(5, 50));
    }

    public static void newValue(int[] mas, int i, int newV) {
        mas[i] = newV;
        System.out.println(i + " элемент массива: " + mas[i]);
    }

    public static void gettingValue(int[] mas, int n) {
        System.out.println(n + " элемент массива: " + mas[n]);
    }

    public static int[] init(int n, long seed) {
        int[] b = new int[n];
        Random rand = new Random(seed);
        for (int i = 0; i < b.length; i++) {
            b[i] = rand.nextInt(0, 6);
        }
        return b;
    }

    public static void print(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }
}
