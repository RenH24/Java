Напишите метод, который проверяет, что строка является адресом почты gmail.com (т.е. в конце строки "@gmail.com", и знак @ только один).

Sample Input 1:
petr.ivanov@gmail.com
Sample Output 1:
YES
  
Sample Input 2:
ivanov@petr@gmail.com
Sample Output 2:
NO

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (isGMailAddress(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    public static boolean isGMailAddress(String str) {
        String s1 = "@gmail.com";
        String s2 = str.substring (str.indexOf("@"));
        return s1.equals(s2);
    }                                   
}
