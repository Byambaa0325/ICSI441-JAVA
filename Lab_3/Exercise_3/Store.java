/**
* @author Enkhzol
* delguuriin jisheeg ajilluulah gol class
*/
public class Store{
  public static void main(String args[]){
    Media items[] = new Media[5];
    for(int i = 0; i < 5; i++){
      try{
        if(i % 3 == 0)
        items[i] = new CD("Im a CD", 1993, i*3);
        else if(i % 3 == 1)
        items[i] = new DVD("Im a DVD", 1999, i*2);
        else
        items[i] = new VHS("Im old!", 1987, i*4);
      }catch(IllegalArgumentException iae){}
      }
      System.out.println("Inventory:\n");
      for(int i = 0; i < items.length ; i++){
        System.out.println("Item " + (i +1) + ": \n" + items[i] + "\n");
        System.out.println(" ----------------");
      }
    } //main
  } //class
