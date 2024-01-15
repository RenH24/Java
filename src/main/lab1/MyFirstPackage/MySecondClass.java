package lab1.MyFirstPackage;

import java.util.Random;

public class MySecondClass {
    private int[] mas;

    public void setValue(int i, int newV) {
        mas[i] = newV;
        System.out.println(i + " элемент массива: " + mas[i]);
    }

    public void getValue(int n) {
        System.out.println(n + " элемент массива: " + mas[n]);
    }

    public MySecondClass(int n, long seed) {
        int[] b = new int[n];
        Random rand = new Random(seed);
        for (int i = 0; i < b.length; i++) {
            b[i] = rand.nextInt(0, 6);
        }
        mas = b;
    }

    public void print() {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }
}
