// Shunzo Hida
// Super Hero Bake Sale
// 09-29-2023
// Period 5


/*
 * Description:
 * A cake baked by a SuperHero
 * Constructor creates a Cake with int cost, 
    or cost = 0 if no parameter was provided
   * A Cake with cost = 0 means it's empty, it's just a placeholder
 * remove() destroys the Cake by setting its cost to zero.
 * appraise() returns the Cake's cost
 * view() displays the cake in ASCII art, 
    with changing designs as the cake costs more
   * uses nested for loops to draw each layer, and 
      chars to hold symbols for each part of the Cake
   * width = ceiling(log_2(cost))*2+2 and 
      height = ceiling(log_2(cost))*2+1 so that Cakes don't get too big.
 */

public class Cake{
  /////////////////////
  // Properties
  /////////////////////
  int cost=0;


  ////////////////////
  // Constructor
  ////////////////////
  public Cake(){};
  public Cake(int cost){
    this.cost = cost;
    System.out.println("A $"+cost+" cake has been baked!");
  }

  ////////////////////
  // Methods
  ////////////////////
  // a cake with cost 0 is empty
  public void remove(){
    this.cost = 0;
  }
  
  public int appraise(){
    return this.cost;
  }

  // uses ASCII art to display a cake, changing depending on cost
  public void view(){
    char decor = ' ';
    char icing = ' ';
    char layer = '%';
    char filling = '%';
    char left = ' ';
    char right = ' ';
    
    double size = Math.ceil(Math.log(this.cost))*2;
    if (this.cost>1000) icing = '_';
    if (this.cost>2000) layer = '|';
    if (this.cost>3000) decor = '#';
    if (this.cost>4000) filling = '=';
    if (this.cost>5000) left = right = '|';
    
    if (this.cost>6000) icing = '-';
    if (this.cost>7000) layer = '#';
    if (this.cost>7000) decor = '^';
    if (this.cost>8000) filling = '~';
    if (this.cost>9000) {left = '{'; right = '}';}

    //top layer
    System.out.print(left);
    for (int i = 0; i < size; i++){
      System.out.print((i%2==0)?decor:icing);
    }
    System.out.println(right);

    //layers
    for (int i = 0; i < size; i++){
      System.out.print(left);
      for (int j = 0; j < size; j++){
        System.out.print((i%2==0)?filling:layer);
      }
      System.out.println(right);
    }  
  }
}