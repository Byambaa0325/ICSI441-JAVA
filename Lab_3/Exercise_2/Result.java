/**
* @author Enkhzol
* Ur dung tootsooloh class
*/
class Result extends Student implements Exam
{
  Result(String n, int r, int m1, int m2)
  {
    super(n,r,m1,m2);
  }
  public void percent_cal()
  {
    int total=(getMark1() + getMark2());
    float percent=total * 100/200;
    System.out.println ("Percentage: "+percent+"%");
  }
  void display()
  {
    super.display();
  }
}
