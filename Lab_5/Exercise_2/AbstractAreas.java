package Exercise_2;

public class AbstractAreas {
	public static void main(String args[]) {
		// Figure f = new Figure(10, 10); Abstract class object cannot be instantiated 
		Rectangle r = new Rectangle(9, 5);
		Triangle t = new Triangle(10, 8);
		Figure figref; // No object is instantiated here
		figref = r; // The dynamic type is Rectangle which is concrete class
		System.out.println("Area is " + figref.area());
		figref = t;
		System.out.println("Area is " + figref.area());
	}
}
