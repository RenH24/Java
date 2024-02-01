
/*
1.   Опишите интерфейс IShape, содержащий метод double computeSquare(). Этот метод должен будет рассчитывать площадь  геометрической фигуры.
2.  Создайте класс Rectangle (прямоугольник), реализующий интерфейс IShape.  Метод computeSquare() рассчитывает площадь прямоугольника.
3.  Создайте класс Cube (куб), реализующий интерфейс IShape. Метод computeSquare() рассчитывает площадь поверхности куба.
4.   В методе main() класса Main выполните следующее:

Введите размер массива и создайте массив фигур, для которых можно подсчитать площадь.
Заполните массив объектами, считав их данные с консоли. В начале каждой строки стоит тип объекта: 1 - прямоугольник, 2 - куб. 
Затем идут длины сторон (для прямоугольника две стороны, для куба - одна). Все данные отделяются пробелами.
Перебрав массив, распечатайте площади всех фигур, отделяя их пробелами. В конце этой строки тоже должен быть пробел. Площади округляются до двух знаков после десятичной точки.
Переведите курсор на новую строку.
Еще раз переберите массив и найдите прямоугольник с максимальной площадью (если площади одинаковые, выбирается прямоугольник с меньшим индексом). 
Выведите информацию о нем в формате: Прямоугольник сторона 1 = 3.45, сторона 2 = 2.67 Площадь = 9.21    Если же в массиве нет ни одного прямоугольника, то выведите слово ERROR.

Sample Input:
4
1 2.4 4.5
2 4.3
1 5.6 7.8
2 1.5
  
Sample Output:
10.80 110.94 43.68 13.50 
Прямоугольник сторона 1 = 5.6, сторона 2 = 7.8 Площадь = 43.68
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        IShape[] list = new IShape[n];

        //заполнение массива
        for(int i = 0; i < list.length; i++) {
            int type = scan.nextInt();
            switch (type) {
                case 1:
                    list[i] = new Rectangle(scan.nextDouble(), scan.nextDouble());
                    break;
                case 2:
                    list[i] = new Cube(scan.nextDouble());
                    break;
            }
        }
        
        //площадь всех фигур
        for (IShape figure: list) {
            System.out.printf("%.2f" + " ", figure.computeSquare());
        }
        System.out.println();
        
        //прямоугольник с максимальной площадью
        int indMax = -1;        
        for (int i = 0; i < list.length; i++) {
            if (list[i] instanceof Rectangle) {
                if (indMax == -1) {
                    indMax = i;
                } else if (list[i].computeSquare() > list[indMax].computeSquare()) {
                    indMax = i;
                }
            }
        }

        if (indMax == -1) {
            System.out.println("ERROR");            
        }
        else {
            System.out.print(list[indMax]);
            System.out.printf(" Площадь = " + "%.2f", list[indMax].computeSquare());
        }
    }
}

interface IShape {
    double computeSquare();
}

class Rectangle implements IShape {
    private double dim1;
    private double dim2;

    public Rectangle(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public Rectangle() {
    }

    @Override
    public double computeSquare() {
        return dim1 * dim2;
    }
    
    @Override
    public String toString() {
        return "Прямоугольник сторона 1 = " + dim1 + ", сторона 2 = " + dim2;
    }
}

class Cube implements IShape {
    private double dimCube;

    public Cube(double dimCube) {
        this.dimCube = dimCube;
    }

    @Override
    public double computeSquare() {
        return 6 * dimCube * dimCube;
    }
    
    @Override
    public String toString() {
        return "Куб сторона = " + dimCube;
    }
}
