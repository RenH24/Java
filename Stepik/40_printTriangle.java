Напишите статический метод printTriangle(), который выводит на консоль треугольник, показанный в примерах тестов. 
Параметрами метода являются ширина основания и символ, которым рисуется треугольник.

Также напишите метод main(), в котором вводятся с консоли ширина треугольника и символ, а затем вызывается метод printTriangle(). 

Совет. В классе Scanner нет метода для ввода отдельного символа. Можно ввести данные как строку, а потом взять первый символ этой строки:
String str = scan.next();
char sim = str.charAt(0);

Sample Input 1:
7 #
Sample Output 1:
   #
  ###
 #####
#######
  
Sample Input 2:
4 $
Sample Output 2:
 $$
$$$$

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();
        String str = scan.next();
        char sim = str.charAt(0);
        printTriangle(width, sim);        
    }
    static void printTriangle(int x, char y) {
        int probel = (x+1)/2-1; // количество пробелов
        int kol = 0; // количество символов
        if (x % 2 == 0) {
            kol = 2;
        } else {
            kol = 1;
        }
        while (kol <= x) {
            for (int i = 1; i <= probel; i++) { // выводим пробелы
                System.out.print(' ');
            }
            for (int i = 1; i <= kol; i++) { // выводим символы
                System.out.print(y);
            }
            System.out.println();
            probel--;
            kol += 2;
        }
    }        
}
