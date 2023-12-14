/*
Пользователь вводит с клавиатуры денежную сумму в рублях и копейках (рубли и копейки вводятся в разные переменные). 
Программа должна откорректировать введенную сумму в правильную форму. 
Например, если пользователь ввел 22 и 978 , то программа должна вывести 31 р. 78 к.

Sample Input:
22 978
Sample Output:
31 р. 78 к.
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rubles = scan.nextInt();
        int kop = scan.nextInt();
        int rubles1 = (rubles + (kop / 100));
        int kop1 = (kop % 100);
        System.out.println(rubles1+" р. "+kop1+" к.");
    }
}
