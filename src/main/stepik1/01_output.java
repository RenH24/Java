package stepik1;
/*В программе заданы строка и несколько чисел. Выведите информацию на консоль так, как показано в примере.

Sample Output:
  С Днем Рождения, Андрей!
  Сегодня Вам 23!
  По этому поводу Вам скидка 15.5%
  на весь ассортимент нашего сайта! 
*/
// put your code here
class Main {
    public static void main(String[] args) {
        String name = "Андрей";
        int age = 23;
        double discount = 15.5;
        System.out.println("С Днем Рождения, "+name+"!");
        System.out.println("Сегодня Вам "+age+"!");
        System.out.println("По этому поводу Вам скидка "+discount+"%");
        System.out.println("на весь ассортимент нашего сайта!");
    }
}
