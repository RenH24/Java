Пользователь вводит целое трехзначное число. Вывести сумму его нечетных цифр.
Если число не является трехзначным, вывести "ERROR".
Если нечетных цифр нет, то вывести "NO".

Sample Input 1:
367
Sample Output 1:
10
  
Sample Input 2:
-351
Sample Output 2:
9

// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number < 0) number = -number;
        if (number < 100 || number > 999) {
            System.out.println("ERROR");
            return;
        }
        int lastDigit = number % 10;
        int middleDigit = (number / 10) % 10;
        int firstDigit = (number / 10) / 10;
        if (firstDigit % 2 != 0){
            sum += firstDigit;
        }
        if (middleDigit % 2 != 0){
            sum += middleDigit;
        }
        if (lastDigit % 2 != 0){
            sum += lastDigit;
        }
        if (firstDigit % 2 == 0 && middleDigit % 2 == 0 && lastDigit % 2 == 0){
            System.out.println("NO");
            return;
        }
        System.out.println(sum);
    }
}    
