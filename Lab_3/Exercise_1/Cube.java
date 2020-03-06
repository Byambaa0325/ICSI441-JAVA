/**
*@author Byambaa Bayarmandakh
*
*Class to represent a cube, where cube is defined by a 3D object (x,y,z)
*with same 3 sides. https://en.wikipedia.org/wiki/Cube
*/
public class Cube implements Shape {

  //x-coordinate
  private int x;
  //y-coordinate
  private int y;
  //z-coordinate
  private int z;
  //Side length
  private int side;

  /** Constructor to assign position (x,y,z) and the side length of the Cube
  */
  public Cube(int px, int py, int pz, int pside) {
    x = px;
    y = py;
    z = pz;
    side = pside;
  }

  /** Follows formula A = 6a^2
  */
  public double area() {
    return side*side*6;
  }

  /** Follow formula V = a^3
  */
  public double volume() {
    return side*side*side;
  }
  public void print() {
    System.out.println(" ----- Cub-iin medeelel -----");
    System.out.println(" Talbai: " + area() );
    System.out.println(" Ezelhuun: " + volume() );
  }
  public static void main(String args[]) {
    Cube p = new Cube(10,20,30,30);
    p.print();
  }
}
