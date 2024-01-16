package stepik1;
/* Пользователь вводит ширину треугольника. Нарисовать треугольник из звездочек, как показано в примерах теста.
Если вводятся некорректные данные (ширина  <= 0), то вывести "ERROR".
Р.S. В конце каждой строки невидимых пробелов нет! (Перевод курсора сразу после звездочек).

Sample Input 1:
7
Sample Output 1:
*******
 *****
  ***
   *
  
Sample Input 2:
4
Sample Output 2:
****
 **

*/
//put your code here
import java.util.Scanner;

class Main28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        if (w <= 0) {
            System.out.println("ERROR");
            return;
        }
        int probel = 0; //количество пробелов в первой строке
        int zvezd = w; //количество звезд в первой строке
        for (int i = 1; i <= (w+1)/2; i++){
            for (int j = 1; j <= probel; j++) { //выводим пробелы
                System.out.print(' ');
            }
            for (int j = 1; j <= zvezd; j++) { //выводим звезды
                System.out.print('*');
            }
            System.out.println(); //переводим курсор
            probel++; //в следующей строке будет пробелов на 1 больше
            zvezd = zvezd - 2; //а звезд на 2 меньше
        }
    }
}