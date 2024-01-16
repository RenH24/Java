package stepik1;
/* Ввести текст из слов, разделенных пробелами. Между словами может быть любое количество пробелов.
Также пробелы могут быть перед первым и после последнего слова.
Также ввести контрольное слово.
Удалить из текста все появления данного слова (но не как части другого слова!)
Также удалить все лишние пробелы между словами и в начале и в конце строки.

Sample Input:
A good    dog deserves a    good bone or goodness
good
Sample Output:
A dog deserves a bone or goodness
*/
//put your code here
import java.util.Scanner;

class Main63 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String control = scan.nextLine();
        str =  str.trim();
        String[] words = str.split(" +");
        String result = "";
        for(String word:words){
            if (word.equals(control)) {
                continue;
            } else {
                result += word;
                result += " ";
            }
        }
        result = result.trim();
        System.out.println(result);
    }
}
