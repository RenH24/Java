package stepik1;
/* Пользователь вводит строку из слов, разделенных пробелами.  Заменить все слова, которые содержат букву z на слово "ERROR".
Также удалить все лишние пробелы в начале и в конце строки. Между словами оставить ровно один пробел. 

Sample Input:
   mama   zlobno   myla    puzzle  and    ramy   
Sample Output:
mama ERROR myla ERROR and ramy
*/
//put your code here
import java.util.Scanner;

class Main65 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        text = text.trim();
        String[] words = text.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if (words[i].indexOf('z') != -1) {
                sb.append(" ").append("ERROR");
            } else { 
                sb.append(" ").append(words[i]);
            }
        }
        System.out.println(sb);
    }
}
