package stepik1;
/* Выведите первое составное число в заданном диапазоне.
Составным называется число, у которого более двух делителей. (т.е. оно делится на единицу, на себя и еще на что-то).
Пользователь вводит границы диапазона через пробел (положительные целые числа). 
Границы диапазона могут быть некорректны (первое число больше второго). В этом случае все равно происходит поиск, как для корректных границ.
Если в заданном диапазоне нет таких чисел, то нужно вывести "NO".

Sample Input 1:
8 22
Sample Output 1:
8
  
Sample Input 2:
22 8
Sample Output 2:
8
  
Sample Input 3:
1 3
Sample Output 3:
NO
*/
//put your code here
import java.util.Scanner;

class Main33 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int composite = 0;
        
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        BLOCK: while (a <= b) {            
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    composite = a;
                    break BLOCK;
                }
            }
            a++;
        }
        if (composite == 0){
            System.out.println("NO");
        } else {
            System.out.println(composite);
        }
    }
}
