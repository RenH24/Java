package stepik2;
/*
Пользователь вводит целые числа. Признак конца ввода - слово "finish". 
Нужно сформировать два списка: для неотрицательных и для отрицательных чисел. 
Отсортировать эти списки по возрастанию и вывести на консоль, отделяя элементы пробелами (сначала список неотрицательных, а затем с новой строки -  список отрицательных).
Если пользователь вводит строку, которую нельзя преобразовать к целому числу, то считать это число нулем и заносить в первый список!
Если какой-либо список окажется пустым, то на соответствующем месте нужно вывести "Пустой список".


Sample Input:
4 8 fg -2 -8  1 -10 klop 2 finish
Sample Output:
0 0 1 2 4 8 
-10 -8 -2 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        while (true) {
            try {
                String buffer = scan.next();
                if ("finish".equals(buffer)) break;
                int number = Integer.parseInt(buffer);
                if (number >= 0) {
                    positive.add(number);
                } else {
                    negative.add(number);
                }
            } catch (NumberFormatException ex) {
                positive.add(0);
            }
        }

        Collections.sort(positive);
        Collections.sort(negative);

        if (!positive.isEmpty()) {
            for (Integer item: positive) {
                System.out.print(item + " ");
            }
        } else {
            System.out.print("Пустой список");
        }
        System.out.println();

        if (!negative.isEmpty()) {
            for (Integer item: negative) {
                System.out.print(item + " ");
            }
        } else {
            System.out.print("Пустой список");
        }
    }
}
