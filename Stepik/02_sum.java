/* 
Напишите программу, которая считает сумму двух целых чисел.
Sample Input:
8 11
Sample Output:
19
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numb1;
        int numb2;
        numb1=scan.nextInt();
        numb2=scan.nextInt();
        System.out.println(numb1+numb2);
    }
}
