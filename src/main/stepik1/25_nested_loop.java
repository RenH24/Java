package stepik1;
/* Пользователь вводит ширину треугольника (от 1 до 9). Изобразить треугольник числами, как показано в примере теста.

Sample Input:
5
Sample Output:
55555
4444
333
22
1
*/
//put your code here
import java.util.Scanner;

class Main25 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        for(int i = height; i >= 1; i--) { //меняется i - номер строки
            for(int j = i; j >= 1; j--) { //меняется j - номер столбца
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
