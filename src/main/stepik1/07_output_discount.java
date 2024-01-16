package stepik1;
/*Вычислите стоимость товара с учетом скидки. Пользователь вводит цену товара в виде двух целых чисел через пробел (рубли копейки).
В следующей строке он вводит размер скидки в процентах (также целое число). Цену нужно вывести так, как показано в тесте.

Учтите, что здесь не применяется округление по правилам математики. Стоимость товара всегда учитывается в большую сторону.
При выводе число рублей и копеек выводится в двух позициях (т.е. 00 коп., если копеек нет).

Sample Input 1:
57 86
15
Sample Output 1:
49 руб. 19 коп.
  
Sample Input 2:
67 50
20
Sample Output 2:
54 руб. 00 коп.
*/
// put your code here
import java.util.Scanner;

class Main7 {
    public static void main(String[] args) {
        final int RUBLE = 100;
        Scanner sc = new Scanner(System.in);
        int rubles = sc.nextInt();
        int kop = sc.nextInt();
        int discount = sc.nextInt();

        int sum = rubles * RUBLE + kop;
        int sumDiscount = sum * discount/100;
        sum = sum - sumDiscount;
        int rublesDiscount = sum / RUBLE;
        int kopDiscount = sum % RUBLE;
        System.out.printf("%02d руб. %02d коп.", rublesDiscount, kopDiscount);        
    }
}
