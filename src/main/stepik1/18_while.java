package stepik1;
/* Выполните задачу с использованием цикла while.
Пользователь вводит 10 оценок ученика (в 10-балльной системе). 
Нужно подсчитать, сколько среди них неудовлетворительных оценок (менее 4 баллов)

Sample Input 1:
6 7 3 2 9 5 4 1 7 8
Sample Output 1:
3
  
Sample Input 2:
5 7 8 9 9 10 7 4 9 8
Sample Output 2:
0
*/
// put your code here
import java.util.Scanner;

class Main18 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        final int N = 10;
        int mark, kol = 0;
        int average = 0;
        while(kol < N){
            mark=scan.nextInt();
            if  (mark < 4){
                average++;
            }
            kol++;
        }
        System.out.println(average);
    }
}
