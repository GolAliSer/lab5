import java.util.Scanner;
class Drobb {
    int chislitel; int znamenatel;

    public Drobb() {   //дробь по умолчанию
        chislitel = 1;
        znamenatel = 1;
    }
    public Drobb(int c, int z) { //создание дроби
        if (z == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        chislitel = c;
        znamenatel = z;
        uprDr(); //сокращение/упрощение дроби
    }
    public int ObDel(int a, int b) {  //общий делитель для числителя и знаменателя
        if (a < 0)
            a = -1 * a;
        if (b < 0)
            b = -1 * b;
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    void uprDr() {  //сокращение/упрощение дроби
        int obshZn = ObDel(chislitel, znamenatel);
        chislitel /= obshZn;
        znamenatel /= obshZn;
    }
    public int vzChislitel() {
        return chislitel;
    }
    public int vzZnamenatel() {
        return znamenatel;
    }

    public Drobb summa(Drobb Drobb2) {
        int chisl = (chislitel * Drobb2.vzZnamenatel()) + (Drobb2.vzChislitel() * znamenatel);
        int znam = znamenatel * Drobb2.vzZnamenatel();
        return new Drobb(chisl, znam);
    }
    public Drobb summa(int number) { return summa(new Drobb(number, 1)); }

    public Drobb viichet(Drobb Drobb2) {
        int chisl = (chislitel * Drobb2.znamenatel) - (Drobb2.chislitel * znamenatel);
        int znam = znamenatel * Drobb2.znamenatel;
        return new Drobb(chisl, znam);
    }
    public Drobb viichet(int number) {
        return viichet(new Drobb(number, 1));
    }

    public Drobb umnoj(Drobb Drobb2) {
        int chisl = chislitel * Drobb2.chislitel;
        int znam = znamenatel * Drobb2.znamenatel;
        return new Drobb(chisl, znam);
    }
    public Drobb umnoj(int number) {
        return umnoj(new Drobb(number, 1));
    }

    public Drobb delenie(Drobb Drobb2) {
        int chisl = chislitel * Drobb2.vzZnamenatel();
        int znam = znamenatel * Drobb2.chislitel;
        return new Drobb(chisl, znam);
    }
    public Drobb delenie(int number) {
        return delenie(new Drobb(number, 1));
    }

    public String toString() {  //вид дроби
        return this.chislitel + "/" + this.znamenatel;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c, d;
        while (true) {
            System.out.print("Введите 1 дробь через энтр: ");
            try {
                a = Integer.parseInt(in.next());
                b = Integer.parseInt(in.next());
                if (b != 0)
                    break;
                else System.out.println("Знаменатель не должен быть 0.");
            } catch (NumberFormatException e) {
                System.out.println("Что-то не так. Попробуйте снова.");
            }
        }
        Drobb f1 = new Drobb(a, b);
        System.out.println(f1.toString());

        while (true) {
            System.out.print("Введите 2 дробь через энтр: ");
            try {
                c = Integer.parseInt(in.next());
                d = Integer.parseInt(in.next());
                if (d != 0)
                    break;
                else System.out.println("Знаменатель не должне быть 0");
            } catch (NumberFormatException e) {
                System.out.println("Что-то не так. Попробуйте снова.");
            }
        }
        Drobb f2 = new Drobb(c, d);
        System.out.println(f2.toString());

        Drobb f3 = f1.summa(f2);
        Drobb f4 = f1.summa(1);
        System.out.println("Сумма с 2 аргументами: " + f1 + " + " + f2 + " = " + f3);
        System.out.println("Сумма с 1 аргументов: " + f1 + " + 1/1 = " + f4);

        f3 = f1.viichet(f2);
        f4 = f1.viichet(1);
        System.out.println("Вычитание с 2 аргументами: " + f1 + " - " + f2 + " = " + f3);
        System.out.println("Вычитание с 1 аргументов: " + f1 + " - 1/1 = " + f4);

        f3 = f1.umnoj(f2);
        f4 = f1.umnoj(1);
        System.out.println("Умножение с 2 аргументами: " + f1 + " * " + f2 + " = " + f3);
        System.out.println("Умножение с 1 аргументов: " + f1 + " * 1/1 = " + f4);

        f3 = f1.delenie(f2);
        f4 = f1.delenie(1);
        System.out.println("Деление с 2 аргументами: " + f1 + " : " + f2 + " = " + f3);
        System.out.println("Деление с 1 аргументов:  " + f1 + " : 1/1 = " + f4);

        in.close();
    }
}