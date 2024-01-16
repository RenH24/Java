package stepik1;
/* Напишите программу- переводчик. Пользователь вводит название дня недели на русском языке, а программа выводит это название на английском.
При этом на русском можно вводить название как с большой буквы, так и с маленькой. 
А на английском день недели - имя собственное, поэтому выводится с большой буквы.

Если  название дня недели введено неверно, то программа выводит "ERROR".
Используйте оператор switch.
*/
// put your code here
import java.util.Scanner;

class Main16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.next();
        switch (day){
            case "Понедельник":
            case "понедельник":
                System.out.println("Monday");
                break;
            case "Вторник":
            case "вторник":
                System.out.println("Tuesday");
                break;
            case "Среда":
            case "среда":
                System.out.println("Wednesday");
                break;
            case "Четверг":
            case "четверг":
                System.out.println("Thursday");
                break;
            case "Пятница":
            case "пятница":
                System.out.println("Friday");
                break;
            case "Суббота":
            case "суббота":
                System.out.println("Saturday");
                break;
            case "Воскресенье":
            case "воскресенье":
                System.out.println("Sunday");
                break;
            default:
                System.out.println("ERROR");
        }
    }
}  
