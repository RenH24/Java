package stepik1;
/* Напишите программу, которая вычисляет значение функции f(x) = ln(x + 7 * sqrt(Math.pow(x, 4) + PI)).
При выводе значение функции представьте с четырьмя знаками после десятичной точки.

Sample Input:
3.45
Sample Output:
4.4738
*/
// put your code here
import java.util.Scanner;

class Main8 {
    public static void main(String[] args) {
        double x, y;
        Scanner scan=new Scanner(System.in);
        x = scan.nextDouble();
        y = Math.log(x + 7 * Math.sqrt(Math.pow(x, 4) + Math.PI));
        System.out.printf("%.4f", y);
    }
}
