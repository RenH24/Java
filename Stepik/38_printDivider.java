Напишите статический  метод printDivider(), который выводит все делители натурального числа через пробел (включая единицу и само число). 
Метод не возвращает никакого значения!

Sample Input:
246
Sample Output:
1 2 3 6 41 82 123 246

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        printDivider(number);
    }
    static void printDivider(int x) {
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
