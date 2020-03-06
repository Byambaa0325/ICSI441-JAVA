/**
* @author Byambaa
* Ur dung tootsooloh class
* Motivation - Result should not extend Student which is like Table and Horse are both extending Leg class
*/
class Result_improved implements Exam
{
  private Student student;

  Result_improved(Student stud)
  {
    student = stud;
  }
  public void percent_cal()
  {
    int total=(student.getMark1() + student.getMark2());
    float percent = total/2;
    System.out.println ("Percentage: "+percent+"%");
  }
  void display()
  {
    student.display();
  }
}
