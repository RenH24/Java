package stepik1;
/* Напишите статический метод maxNumberDivider(), который в заданном диапазоне находит число с наибольшим количеством делителей.
Совет: сделайте отдельный  метод, который подсчитывает количество делителей числа, а затем вызывайте его в методе maxNumberDivider().

Sample Input:
530 545
Sample Output:
540
*/
//put your code here
import java.util.Scanner;

class Main39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int max = maxNumberDivider(a, b);
        System.out.println(max);
    }
    
    static int maxNumberDivider(int a, int b) {
        int max = a;
        int kolMax = kolDivider(a);
        a++;
        while (a <= b) {
            if (kolDivider(a) > kolMax) {
                kolMax = kolDivider(a);
                max = a;
            }
            a++;
        }
        return max;
    }
    
    static int kolDivider(int a) {
        int kol = 0;
            for (int i = 1; i < a; i++) {
                if (a % i == 0) {
                    kol++;
                }
            }
            return kol;
    }
}
