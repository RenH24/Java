package stepik1;
/* Пользователь вводит высоту треугольника. Нарисовать треугольник из звездочек, как показано в примере теста.
Если вводятся некорректные данные (высота  <= 0), то вывести "ERROR".

Sample Input:
5
Sample Output:
*****
 ****
  ***
   **
    *
*/
//put your code here
import java.util.Scanner;

class Main27 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        if (height <= 0){
            System.out.println("ERROR");
            return;
        }
        for(int i = 0; i < height; i++) {
            for(int j = height; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
            for (int k = 0; k <= i; k++) {
                System.out.print(" ");
            }
        }
    }
}