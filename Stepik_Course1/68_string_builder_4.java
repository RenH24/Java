Пользователь вводит строку, в которой среди других символов содержатся символы цифр. 
Сформируйте строку, которая "представляет" сумму этих цифр. Выведите полученную строку на консоль. 
Если в исходной строке цифр нет, то должно быть выведено ERROR.
Р.S.  Преобразовать символ в число можно вычитанием кода символа '0'

Sample Input:
ab34c#5i02k tolkien25
Sample Output:
3+4+5+0+2+2+5=21

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        int summa = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                summa += str.charAt(i) - '0';
                sb.append(str.charAt(i)).append('+');
            }
        }
        if (!sb.isEmpty()) {
            sb.replace(sb.length() - 1, sb.length(), "=");
            sb.append(summa);
            System.out.println(sb);
        } else {
            System.out.println("ERROR");
        }       
    }
}
