package stepik1;
/* Введите три строки (могут содержать пробелы). Выведите их в порядке возрастания.

Sample Input:
Hello, world!
Hello, sky!
By-by, baby!
  
Sample Output:
By-by, baby!
Hello, sky!
Hello, world!

 */
//put your code here
import java.util.Scanner;
import java.util.Arrays;

class Main57 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        String s3 = scan.nextLine();
        if(s1.compareTo(s2) > 0) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        if (s2.compareTo(s3) > 0) {
            String tmp = s2;
            s2 = s3;
            s3 = tmp;
        }
        if (s1.compareTo(s2) > 0) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
