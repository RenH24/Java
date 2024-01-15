Измените исходный код таким образом, чтобы ваша фамилия была выведена в столбик по буквам. Буквы фамилии должны задаваться как параметры командной строки.
Откомпилируйте и запустите программу, добавив в командную строку ряд аргументов. Например, следующим образом: “java MyFirstClass И в а н о в”.

Код
import java.util.Scanner;

class MyFirstClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String surname = scan.nextLine();

        char[] letters = surname.toCharArray();
        for (char letter : letters) {
            System.out.println(letter);
        }
    }
}
