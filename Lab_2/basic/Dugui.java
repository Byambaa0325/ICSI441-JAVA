package basic;

public class Dugui extends Durs{
	private int radius;
	
	Dugui(int r){
		this.radius = r;
		setArea(2*r*3.14);
		System.out.println("Dugui object is initialized with radius, area: " + this.radius +", "+ this.talbai);
	}
	
	public double getArea() {
		return this.talbai;
	}

	public void printInfo() {
		System.out.println("Dugui object with radius, area: " + this.radius +", "+ this.talbai);
	}

	
}