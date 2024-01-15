Введите строку (в ней возможны пробелы). Замените в ней каждый символ «;»   на пару символов «.,»

Sample Input:
hello;; by!; ;;
Sample Output:
hello.,., by!., .,.,

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String changed = str.replace(";", ".,");
        System.out.print(changed);
    }
}
