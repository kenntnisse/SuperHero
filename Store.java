// Shunzo Hida
// Super Hero Bake Sale
// 09-29-2023
// Period 5


/*
 * Description:
 * A store that can sell Cakes
 * Constructor creates a Store with String name and int capacity
   * capacity is the maximum Cakes they can hold
   * profit is the total the Store has made by selling Cakes
   * cakes is the array of Cakes the Store currently has, of length capacity
   * numCakes keeps track of how many Cakes the Store currently has
 * displayCakes() returns cakes 
    (which is the array of Cakes the Store currently has)
 * displayCake(int index) returns a specific Cake, index in cakes
 * sellCake(int index) gives profit to the Store equal to the cost of the Cake
 * getCake(Cake c) gives a Cake to the store
   * If they are already at capacity (numCakes = capacity), 
      then nothing happens
   * If they have space, it finds the first empty spot 
      and places the new Cake there and increments numCakes by one
 * displayStats() prints the Store name, profit, and numCakes
 */

public class Store{
  /////////////////////
  // Properties
  /////////////////////
  String name;
  int profit=0;
  Cake[] cakes;
  int numCakes=0;
  int capacity;


  ////////////////////
  // Constructor
  ////////////////////
  public Store(String name, int capacity){
    this.name = name;
    System.out.println("The " + capacity + "-cake store " + name + " has appeared.");
    // fills the cake array with placeholders
    this.cakes = new Cake[capacity];
    for (int i = 0; i < capacity; i++){
      this.cakes[i] = new Cake();
    }
    this.capacity = capacity;
  }

  ////////////////////
  // Methods
  ////////////////////
  public Cake[] displayCakes(){
    return this.cakes;
  }

  public Cake displayCake(int index){
    return this.cakes[index];
  }

  // loses a cake
  public void sellCake(int index){
    System.out.println("The store " + this.name + 
                       " has sold a $"+this.cakes[index].appraise() + " cake.");
    this.profit+=this.cakes[index].appraise();
    this.cakes[index].remove();
    this.numCakes -= 1;
  }

  // gets a cake, as long as it has space
  public void getCake(Cake c){
    // already at capacity
    if (numCakes == capacity){
      System.out.println("The store " + name + " already has "+ 
                         capacity+" cakes.");
      return;
    }
    System.out.println(this.name + " has gained a $"
                       c.appraise() + " cake.");
    // finds a placeholder to replace
    for (int i = 0; i < capacity; i++){
      if (this.cakes[i].appraise() == 0){
        this.cakes[i] = c;
        break;
      }
    }
    this.numCakes+=1;
  }

  public void displayStats(){
    System.out.println(this.name + " has $" + this.profit + 
                       " and " + this.numCakes + " cakes.");
  }
}