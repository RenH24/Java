
/*
Разработайте класс Material, описывающий некоторый физический материал (вещество).
Поля: название вещества, плотность.
Конструктор: с параметрами.
Методы: геттеры.

Также разработайте класс Thing, описывающий однородный предмет, состоящий из одного материала.
Поля: название предмета, материал (поле имеет тип класса Matherial), объём (вещественное число).
Конструкторы: по умолчанию; с параметрами. 
Методы: геттеры и сеттеры; getMass( ) – вычисление массы предмета (= плотность * объём);
show( ) –   вывод информации об объекте в csv формате. Последним значением выводится масса. Пример:   wire;steel;7850;0.03;235.5

В методе main() класса Main сделать следующее:
Создать объект Стальной_Провод из стали в объёме 0.0м3.
Вывести информацию о нем на консоль с использованием show().
Считать новый объем провода с консоли и изменить объект.
Изменить материал провода на медь (плотность = 8500).
Вывести на консоль новую информацию о проводе.

Sample Input:
0.05
Sample Output:
wire;steel;7850;0.03;235.5
wire;copper;8500;0.05;425.0
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {        
        Thing wire = new Thing("wire", new Material("steel", 7850), 0.03);
        wire.show();
        
        Scanner scan = new Scanner(System.in);
        double newVolume = scan.nextDouble();
        wire.setVolume(newVolume);
        
        Material copper = new Material("copper", 8500);
        wire.setMaterial(copper);
        wire.show();
    }
}

class Material {
    private String name;
    private int density;

    public Material(String name, int density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public int getDensity() {
        return density;
    }
}

class Thing {
    private String itemName;
    private Material material;
    private double volume;

    public Thing() {
    }

    public Thing(String itemName, Material material, double volume) {
        this.itemName = itemName;
        this.material = material;
        this.volume = volume;
    }
    
    public double getMass() {
        return material.getDensity() * volume;
    }
    
    public void show() {
        System.out.println(itemName + ";" + material.getName() + ";" + material.getDensity() + ";" + volume + ";" + getMass());
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
