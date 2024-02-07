
/*
Программа должна вычислять значение выражения, которое включает единственную операцию для целых неотрицательных чисел (+, -, *, / или %). 
Пользователь вводит строку без пробелов, которая содержит это выражение. Например: 78+21. 
Нужно вывести полностью результат вычисления выражения без пробелов: 78+21=99
В случае любой ошибки (деление на 0, отсутствие знака операции в строке, отсутствие одного или обоих операндов и т.д.) - выводится слово "Error".

Sample Input:

78+21
Sample Output:
78+21=99
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        try {
            String[] parts = s.split("[+*/%-]");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);

            if (s.indexOf("+") > 0 && s.indexOf("-") < 0) {
                int res = num1 + num2;
                System.out.println(num1 + "+" + num2 + "=" + res);
            } else if (s.indexOf("-") > 0 && s.indexOf("+") < 0) {
                int res = num1 - num2;
                System.out.println(num1 + "-" + num2 + "=" + res);
            } else if (s.indexOf("*") > 0) {
                int res = num1 * num2;
                System.out.println(num1 + "*" + num2 + "=" + res);
            } else if (s.indexOf("/") > 0) {
                int res = num1 / num2;
                System.out.println(num1 + "/" + num2 + "=" + res);
            } else if (s.indexOf("%") > 0) {
                int res = num1 % num2;
                System.out.println(num1 + "%" + num2 + "=" + res);
            } else {
                 System.out.println("Error");
            }
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
