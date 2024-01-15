Грузовой самолет должен пролететь с грузом из пункта А в пункт С через пункт В. Емкость бака для топлива у самолета – 300 литров. 

  Потребление топлива на 1 км в зависимости от веса груза у самолета следующее:
          - до 500 кг  (включительно) :    1 литров / км
          - до 1000 кг (включительно):   4 литров / км
          - до 1500 кг (включительно):   7 литров / км
          - до 2000 кг (включительно):   9 литров / км.
          - более 2000 кг – самолет не поднимает.
  
Пользователь вводит расстояние между пунктами А и В,  расстояние между пунктами В и С, а также вес груза. 
Программа должна рассчитать какое минимальное количество топлива необходимо для дозаправки самолету в пункте В, чтобы долететь из пункта А в пункт С. 
В случае невозможности преодолеть любое из расстояний – программа должна вывести ERROR.
Числовой результат работы программы округляется до двух знаков после десятичной точки.

Sample Input 1:
200 200 300
Sample Output 1:
100.00

Sample Input 2:
136 268 600
Sample Output 2:
ERROR

Sample Input 3:
136 150 400
Sample Output 3:
0.00
  
// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final int CONTAINER = 300; //емкость бака
        Scanner scan = new Scanner(System.in);
        int ab = scan.nextInt();
        int bc = scan.nextInt();
        int weight = scan.nextInt();
        scan.close();
        
        int consumption = 0; //потребление топлива на 1км в зависимости от веса
        if (weight <= 500) {
            consumption = 1;
        } else if (weight <= 1000) {
            consumption = 4;
        } else if (weight <= 1500) {
            consumption = 7;
        } else if (weight <= 2000) {
            consumption = 9;
        } else {
            System.out.println("ERROR");
            return;
        }   
        int distAB = ab * consumption; //сколько топлива нужно для пути из А в В
        int distBC = bc * consumption; //сколько топлива нужно для пути из А в В
        if (distAB > CONTAINER || distBC > CONTAINER){ //невозможность преодолеть любое из расстояний
            System.out.println("ERROR");
            return;
        }
        int restAB = CONTAINER - distAB; //сколько остается топлива в баке после пути из А в В
        float minAdd = (float) (distBC - restAB);
        if (minAdd > 0) {
            System.out.printf("%.2f", minAdd);
        } else {
            System.out.printf("%.2f", 0.);
        }
    }
}
