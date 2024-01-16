package stepik1;
/* Пользователь вводит три строки, которые содержат части кодового слова.
Каждая вводимая строка может содержать пробелы и заканчивается символом перехода на новую строку ('\n').
Части кодового слова выделены внутри строки знаками ';'. Нужно соединить эти части в одну строку и вывести эту строку на консоль.

Sample Input:
To be or ;not; to be?
tes;ting; is good
I like ;ham; more then eggs
  
Sample Output:
nottingham

 */
//put your code here
import java.util.Scanner;

class Main59 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        String str3 = scan.nextLine();
        
        String part1 = str1.substring (str1.indexOf(";") + 1, str1.lastIndexOf(";"));
        String part2 = str2.substring (str2.indexOf(";") + 1, str2.lastIndexOf(";"));
        String part3 = str3.substring (str3.indexOf(";") + 1, str3.lastIndexOf(";"));
        
        String result = part1 + part2 + part3;
        System.out.println(result);        
    }
}
