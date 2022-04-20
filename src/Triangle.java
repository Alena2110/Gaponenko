/*7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления площади,
периметра и точки пересечения медиан.
 */
public class Triangle {
    private double a1;//координаты точки a по оси x
    private double a2;//координаты точки a по оси y
    private double b1;//координаты точки b по оси x
    private double b2;//координаты точки b по оси y
    private double c1;//координаты точки с по оси x
    private double c2;//координаты точки с по оси y
    private double AB;//длина стороны AB
    private double BC;//длина стороны BC
    private double AC;//длина стороны AC

    Triangle(double a1, double a2, double b1, double b2, double c1, double c2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
        this.AB = Math.pow((Math.pow((this.a1 - this.b1), 2) + Math.pow((this.a2 - this.b2), 2)), 0.5);
        this.BC = Math.pow((Math.pow((this.b1 - this.c1), 2) + Math.pow((this.b2 - this.c2), 2)), 0.5);
        this.AC = Math.pow((Math.pow((this.a1 - this.c1), 2) + Math.pow((this.a2 - this.c2), 2)), 0.5);
    }

    public double perimeter() { //периметр треугольника
        return (this.AB + this.BC + this.AC);
    }

    public double square() { //площадь треугольника
        double p = perimeter() / 2;
        return Math.pow((p * (p - this.AB) * (p - this.BC) * (p - this.AC)), 0.5);
    }

    public String medianIntersection() {//точка пересечения медиан треугольника
        return "(" + Math.round((this.a1 + this.b1 + this.c1) / 3 * 10.0) / 10.0 + ":" +
                Math.round((this.a2 + this.b2 + this.c2) / 3 * 10.0) / 10.0 + ")";
    }

    public String toString() {
        return "Треугольник с координатами: точка A (" + this.a1 + ":" + this.a2 + "), точка B (" + this.b1 + ":" +
                this.b2 + "), точка C (" + this.c1 + ":" + this.c2 + ")";
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 5, 8, 5, -4, 7);
        System.out.println(triangle);
        System.out.println("Периметр треугольника: " + Math.round(triangle.perimeter() * 10.0) / 10.0);
        System.out.println("Площадь треугольника: " + Math.round(triangle.square() * 10.0) / 10.0);
        System.out.println("Точка пересечения медиан треугольника: " + triangle.medianIntersection());
    }
}
