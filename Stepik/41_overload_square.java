Напишите две перегрузки статического  метода square() для вычисления площади прямоугольника. 
В одном случае в метод передаются две стороны прямоугольника, а в другом - одна сторона квадрата (все - вещественные числа).

В методе main() вводится сначала целое число:
1 означает, что нужно вычислить площадь квадрата. И затем следует ввод одного вещественного числа (стороны квадрата)
2 означает, что нужно вычислить площадь прямоугольника. Затем следует ввод двух сторон прямоугольника.
  
Выводимую площадь нужно представить с двумя знаками после десятичной точки.
  
Sample Input 1:
2 4.4 3.2
Sample Output 1:
14.08
  
Sample Input 2:
1 5.5
Sample Output 2:
30.25

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        double length = scan.nextDouble();
        if (number == 1) {
            square(length);
        } else {
            double width = scan.nextDouble();
            square(length, width);
        }     
    }
    static void square(double l) {
        double s = l * l;
        System.out.printf("%.2f", s);
    }
    static void square(double l, double w) {
        double s = l * w;
        System.out.printf("%.2f", s);
    }
}
