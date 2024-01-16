package stepik1;
/* Пользователь вводит целое неотрицательное число.
Нужно вывести "YES", если это число простое.

Sample Input 1:
13
Sample Output 1:
YES
  
Sample Input 2:
1
Sample Output 2:
NO
*/
//put your code here
import java.util.Scanner;

class Main31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int del = 0;
        for (int i = 1; i <= number; i++){
            if (number % i == 0 && i != 1 && i != number) {
                del++;
                System.out.println("NO");
                break;
            } else if (number == 1) {
                System.out.println("NO");
            }
        }
        if (del == 0 && number != 1) {            
        System.out.println("YES");
        }
    }
}
