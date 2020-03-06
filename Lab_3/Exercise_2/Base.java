public class Base {
  public static void main(String args[])
  {
    Result R = new Result("Bat",12,93,84);
    R.display();
    R.percent_cal();

    //Changes should return same output as above
    Student bat = new Student("Bat",12,93,84);
    Result_improved Ri = new Result_improved(bat);
    Ri.display();
    Ri.percent_cal();
  }
}
