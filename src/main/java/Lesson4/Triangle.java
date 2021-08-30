package Lesson4;

//Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c).
// Разместите класс с функцией в src/main/java.
//Разместите тесты на эту функцию в классе src/test/java/.../TriangleTest.java.
//Настройте генерацию отчёта и по желанию — логирование.
public class Triangle {

//    public static void main(String[] args) {
//
//        System.out.printf("Площадь %.2f", Triangle (3, 4, 5)); //площадь треугольника равна = 6
//
//    }

    public static double Triangle (double a, double b, double c) {
        double p = (a + b + c) / 2;
        double AreaTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return AreaTriangle;
    }

}

