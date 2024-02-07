package stepik2;
/*
Пользователь вводит строку, в которой находятся числа, разделенные символами решетки. 
Однако между символами решетки может находится не только число (набор букв и цифр, например). Найти сумму "правильных"  чисел и вывести  ее на консоль. Ответ округлить до одного знака после десятичной точки.

Sample Input:
3.14#22.04#2#true#
Sample Output:
27.2
*/

import java.util.Scanner;

class Main29 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] parts = s.split("#");
        double sum = 0;

        for (int i = 0; i < parts.length; i++) {
            try {
                double num = Double.parseDouble(parts[i]);
                sum += num;
            } catch (NumberFormatException ex) {
            }
        }
        System.out.printf("%.1f", sum);
    }
}