package stepik2;
/*
Пользователь вводит строку, в которой среди прочих символов находятся целые числа. Например, ab34$78%125-3k
Нужно найти и вывести на консоль максимальное из этих чисел. В данном примере это 125.
Если в строке нет чисел вообще, то выводится 0. 


Sample Input:
25true67%23$-6
Sample Output:
67
*/

import java.util.Scanner;

class Main28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int max = 0;
        int i = 0;
        String num = "";
        
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else {
                if (!num.isEmpty()){
                    int number = Integer.parseInt(num);
                    if (number > max) {
                        max = number;
                    }
                    num = "";
                }
            }
            i++;
        }
        System.out.println(max);
    }
}          
