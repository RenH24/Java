В отделе работают 3 сотрудника, которые получают заработную плату в рублях. 
Требуется определить, на сколько зарплата самого высокооплачиваемого из них отличается от самого низкооплачиваемого. 
Пользователь вводит три целых числа (три зарплаты в рублях). Программа выводит разность зарплат в рублях.
Используйте тернарную операцию!

Sample Input:
6000 12000 10500
Sample Output:
6000 

// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int worker1 = scan.nextInt();
        int worker2 = scan.nextInt();
        int worker3 = scan.nextInt();
        int max = (worker1 > worker2?worker1:worker2);
        max = (max > worker3?max:worker3);
        int min = (worker1 < worker2?worker1:worker2);
        min = (min < worker3?min:worker3);
        System.out.println(max-min);
    }
}
