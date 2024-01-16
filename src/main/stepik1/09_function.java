package stepik1;
/* Ввести значение вещественного аргумента a и вычислить значения двух функций:
        z = 2 * sin^2(3 * PI - 2 * a) * (cos^2(5 * PI + 2 * a);
        y = 1/4 - 1/4 * sin(2.5 * PI - 8 * a);
Вывести на консоль сначала z, а потом y, разделив их пробелом. Значения представить с пятью знаками после десятичной точки.

Sample Input:
4.78
Sample Output:
0.03569 0.03569
*/
// put your code here
import java.util.Scanner;

class Main9 {
    public static void main(String[] args) {
        double a, z, y;
        Scanner scan=new Scanner(System.in);
        a = scan.nextDouble();
        z = 2 * Math.pow(Math.sin(3*Math.PI - 2 * a),2) * Math.pow(Math.cos(5*Math.PI + 2 * a),2);
        y = 0.25 - 0.25 * Math.sin(2.5 * Math.PI - 8 * a);     
        System.out.printf("%.5f %.5f", z, y);
    }
}
