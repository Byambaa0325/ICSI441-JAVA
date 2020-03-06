package basic;

public class TegshUntsugt extends Durs{
	private int side_a;
	private int side_b;
	
	TegshUntsugt(int a, int b){
		this.side_a = a;
		this.side_b = b;
		setArea(a*b);
		System.out.println("TegshUntsugt object is initialized with sides, area: (" + this.side_a+", "+ this.side_b+"), "+this.talbai);
	}
	
	public double getArea() {
		return this.talbai;
	}

	public void printInfo() {
		System.out.println("TegshUntsugt object with sides, area: (" + this.side_a+", "+ this.side_b+"), "+this.talbai);
	}
	
}