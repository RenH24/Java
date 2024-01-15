Напишите статический метод, который проверяет, есть ли в конце строки подстрока ".com". 
Если да, то он возвращает часть строки без этого фрагмента. Если нет, то он возвращает строку без изменения.

Sample Input 1:
intel.com.think.com
Sample Output 1:
intel.com.think
  
Sample Input 2:
stepik.org
Sample Output 2:
stepik.org

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(delCom(str));
    }
    public static String delCom(String str) {
        String s1 = ".com";
        String s2 = str.substring (str.lastIndexOf (".") );
        if (s1.equals(s2)) {
            return str.substring (0, str.lastIndexOf (".") );
        } else {
            return str;
        }
    }
}
