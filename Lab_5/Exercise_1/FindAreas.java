package Exercise_1;

class FindAreas {
	public static void main(String args[]) {
		Figure f = new Figure(10, 10);
		Rectangle r = new Rectangle(9, 5);
		Triangle t = new Triangle(10, 8);
		Figure figref;
		figref = r;// Rectangle is subclass of Figure therefore superclass instance can have dynamic type of its subclass
		System.out.println("area is" + figref.area());
		figref = t;// Triangle is subclass of Figure therefore superclass instance can have dynamic type of its subclass
		System.out.println("area is" + figref.area());
		figref = f;// A concrete class can have object of its type for its instance
		System.out.println("area is" + figref.area());
	}
}
