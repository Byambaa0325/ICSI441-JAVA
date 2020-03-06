public abstract class Media {
  private String title; // garchig
  private int year; // jil
  private int quantity; // too shirheg
  /* baiguulagch */
  public Media (String t, int yr, int q){
    if(t == null)
    throw new IllegalArgumentException("No title given");

    else if(yr < 0 || yr > 2010) // jil hudal esehiig shalgah
    throw new IllegalArgumentException("Bad year");

    else if(q < 0) // too shirheg zuv esehiig shalgah
    throw new IllegalArgumentException("Bad quantity");
    else{
      title = t;
      year = yr;
      quantity = q;
    }
  }
  /* bugdiig ni string turul uruu hurvuuleh */
  public String toString(){
    return("Garchig: " + title
    + "\nJil: " + year
    + "\nToo shirheg: " + quantity);
  } //toString()
}
