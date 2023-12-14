Пользователь вводит координаты двух точек на плоскости 
(в первой строке через пробел - координата X и координата Y первой точки, затем во второй строке также через пробел координаты второй точки). 
Нужно определить, какая из точек ближе к началу координат.
Выводится одно из сообщений: "Первая точка ближе", "Вторая точка ближе", "Точки на равных расстояниях".
Подсказка: расстояние до начала координат находится по формуле: d = sqrt(x2 + y2)

Sample Input 1:
3.5 -1.5
2 4.8
Sample Output 1:
Первая точка ближе

Sample Input 2:
2.2 -4.1
4.1 2.2
Sample Output 2:
Точки на равных расстояниях

// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double x1, y1, x2, y2;
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
       
        double d1 = Math.sqrt(x1 * x1 + y1 * y1);
        double d2 = Math.sqrt(x2 * x2 + y2 * y2);
        
        if (d1 < d2){
            System.out.println("Первая точка ближе");
        }else if(d1 > d2){
            System.out.println("Вторая точка ближе");
        }else if (d1 == d2){
            System.out.println("Точки на равных расстояниях");
        }    
    }
}
