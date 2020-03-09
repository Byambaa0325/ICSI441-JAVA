package Exercise_1;

public class Triangle extends Figure {
	Triangle(double a, double b) {
		super(a, b);
		System.out.println("Constructor of Triangle ");
	}

	double area() {
		System.out.println("Inside area for triangle");
		return dim1 * dim2 / 2;
	}
}
