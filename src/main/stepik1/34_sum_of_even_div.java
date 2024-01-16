package stepik1;
/* Пользователь вводит целое неотрицательное число. Найти сумму его четных делителей (не включая его самого).

Sample Input 1:
16
Sample Output 1:
14
  
Sample Input 2:
15
Sample Output 2:
0
*/
//put your code here
import java.util.Scanner;

class Main34 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int div = 0;
        for(int i = 2; i < a; i += 2) {
            if (a % i == 0) {
                div += i;
            }
        }
        System.out.println(div);
    }
}
