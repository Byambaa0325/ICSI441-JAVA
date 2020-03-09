package Exercise_1;

public class Figure {
	double dim1;
	 double dim2;
	 Figure(double a,double b)
	{
	 dim1=a;
	 dim2=b;
	 System.out.println("Constructor of Figure");
	}
	double area()
	 {
	 System.out.println("Area for figure is undefined");
	 return 0;
	 }
}
