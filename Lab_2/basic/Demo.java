package basic;

import java.util.Scanner;

public class Demo{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Dugui dugui = new Dugui(input.nextInt());
		dugui.printInfo();
		Kub kub = new Kub(input.nextInt());
		kub.printInfo();
		TegshUntsugt t = new TegshUntsugt(input.nextInt(), input.nextInt());
		t.printInfo();
		Double totalArea = dugui.getArea() + kub.getArea() + t.getArea();
		System.out.println("Total Area of the objest created = "+(totalArea));
	}
}