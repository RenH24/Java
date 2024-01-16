package stepik1;
/*Введите значения трех переменных: имени (может состоять из нескольких слов), возраста (целое) и размера скидки (вещественное).
Выведите на консоль рекламное предложение в формате, показанном в примере теста.

Sample Input:
Андрей Иванович
45
23.3
Sample Output:
С днем рождения, Андрей Иванович! Сегодня Вам 45!
По этому поводу дарим Вам скидку 23.3%
на весь ассортимент нашего сайта!
*/
// put your code here
import java.util.Scanner;

class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        name=scan.nextLine();
        int age;
        age = scan.nextInt();
        double discount;
        discount = scan.nextDouble();
        System.out.println("С днем рождения, "+name+"! "+"Сегодня Вам "+age+"!");
        System.out.println("По этому поводу дарим Вам скидку "+discount+"%");
        System.out.println("на весь ассортимент нашего сайта!");
    }
}
