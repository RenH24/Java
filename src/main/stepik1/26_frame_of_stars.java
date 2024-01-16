package stepik1;
/* Пользователь вводит  высоту  и ширину рамки через пробел. Нарисовать рамку из звездочек.
Если вводятся некорректные данные (высота или ширина <= 0), то вывести "ERROR".
P.S. Пустые места внутри рамки - это пробелы.

Sample Input 1:
5 4
Sample Output 1:
****
*  *
*  *
*  *
****
  
Sample Input 2:
-1 5
Sample Output 2:
ERROR
  
Sample Input 3:
1 2
Sample Output 3:
**

*/
//put your code here
import java.util.Scanner;

class Main26 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();
        if (height <= 0 || width <= 0) {
            System.out.println("ERROR");
        }
        for(int i = 1;i <= height; i++) {
            for(int j = 1; j <= width; j++) {
                if (j > 1 && j < width && i > 1 && i < height){
                    System.out.print(" ");
                } else {
                System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}