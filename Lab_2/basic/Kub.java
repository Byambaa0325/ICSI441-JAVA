package basic;

public class Kub extends Durs{
	private int side;
	
	Kub(int s){
		this.side = s;
		setArea(s*s);
		System.out.println("Kub object is initialized with side, area: " + this.side +", "+ this.talbai);
	}
	
	public double getArea() {
		return this.talbai;
	}

	public void printInfo() {
		System.out.println("Kub object with side, area: " + this.side +", "+ this.talbai);
	}

	
}