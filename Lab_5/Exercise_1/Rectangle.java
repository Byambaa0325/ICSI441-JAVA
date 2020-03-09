package Exercise_1;

public class Rectangle extends Figure {
	Rectangle(double a, double b) {
		super(a, b);
		System.out.println("Constructor of Rectangle ");
	}

	double area() {
		System.out.println("Inside area for rectangle");
		return dim1 * dim2;
	}
}
