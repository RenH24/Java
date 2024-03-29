package stepik1;
/* Программа должна определить зарплату служащего компании.
Пользователь вводит количество отработанных часов (целое) и почасовой тариф (вещественное). 
Компания платит обычный тариф за первые 20 часов (включительно),  
полуторный тариф за время, отработанное от 20 (не включая) до 40 часов (включительно), 
и двойной тариф за время свыше 40 часов.

Например, если служащий отработал 42 часа, а почасовой тариф 10.5 рублей, то он получит
20*10.5=210 рублей за первые 20 часов;
20*10.5*1.5=315 рублей за вторые 20 часов;
2*10.5*2=42 рубля за последние 2 часа.
Итого 210+315+42=567 рублей.

Вывести зарплату служащего, округлив ее до двух знаков после десятичной точки. 
Если введено отрицательное значение количества часов или отрицательный тариф, вывести ERROR.

Sample Input:
42 10.5
Sample Output:
567.00
*/
// put your code here
import java.util.Scanner;

class Main14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = scan.nextInt();
        float tarif = scan.nextFloat();
        float wage = 0;
        if (hours < 0 || tarif < 0){
            System.out.println("ERROR");
            return;
        }
        if (hours <= 20){
            wage = (float) hours * tarif;
        }
        if (20 < hours && hours <= 40){
            wage = (float) (20 * tarif + (hours - 20) * tarif * 1.5);
        }
        if (hours > 40){
            wage = (float) (20 * tarif + 20 * tarif * 1.5 + (hours - 40) * tarif * 2);
        }
        System.out.printf("%.2f", wage);
    }
}
