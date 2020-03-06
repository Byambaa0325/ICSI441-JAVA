public class Student {
  private String name;
  private int roll_no,mark1,mark2;

  Student(String n, int r, int m1, int m2)
  {
    name=n;
    roll_no=r;
    mark1=m1;
    mark2=m2;
  }

  void display()
  {
    System.out.println ("Oyutnii ner: "+getName());
    System.out.println ("Dugaar ni: "+getRoll_no());
    System.out.println ("Hicheel 1-iin unelgee: "+ getMark1());
    System.out.println ("Hicheel 2-iin unelgee: "+getMark2());
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getRoll_no() {
    return this.roll_no;
  }
  public void setRoll_no(int roll_no) {
    this.roll_no = roll_no;
  }
  public int getMark1() {
    return mark1;
  }
  public void setMark1(int mark1) {
    this.mark1 = mark1;
  }
  public int getMark2() {
    return mark2;
  }
  public void setMark2(int mark2) {
    this.mark2 = mark2;
  }
}
