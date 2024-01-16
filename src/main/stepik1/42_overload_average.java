package stepik1;
/* Напишите четыре перегрузки статического метода average(), который находит среднее арифметическое
двух вещественных чисел;
трех вещественных чисел;
двух целых чисел;
трех целых чисел.
Подумайте, можно ли сократить число перегрузок? Если да, то какие методы можно удалить?

Sample Input:
3 4 8
7.2 0.3 4.8
Sample Output:
3.50 5.00
3.75 4.10
*/
//put your code here
import java.util.Scanner;

class Main42 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double z = scan.nextDouble();
        System.out.printf("%.2f %.2f\n", average(a, b), average(a, b, c));
        System.out.printf("%.2f %.2f\n", average(x, y),average(x, y, z));
    }
    static double average(double x, double y) {
        double av = (x + y) / 2;
        return av;
    }
    static double average(double x, double y, double z) {
        double av = (x + y + z) / 3;
        return av;
    }
}
