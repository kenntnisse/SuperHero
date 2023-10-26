// Shunzo Hida
// Super Hero Bake Sale
// 09-29-2023
// Period 5


/*
 * Description:
 * A customer that can buy Cakes from Stores
 * Constructor creates a Customer with String name and int budget
   * budget is the amount of money they have
   * cakesBought keeps track of how many Cakes they have bought
   * Store location and Store home are experimental.
 * findCake(Store s) searches the Cakes in a Store 
    for the costliest one that is within their budget
   * returns the index, or -1 if no Cakes were found.
 * buyCake(Store s, int index) reduces their budget 
    by the cost and increases cakesBought by one
 * getMoney(int m) gives them money of int m, but 
    does not let them go over 1 billion
 * displayStats() prints their name, budget, and cakesBought
 * appraise() returns their budget
 * goTo(Store s) and goHome() are experimental.
 */


public class Customer{
  /////////////////////
  // Properties
  /////////////////////
  String name;
  int budget;
  int cakesBought = 0;
  Store location;
  Store home;

  ////////////////////
  // Constructor
  ////////////////////
  public Customer(String name, int budget){
    this.name = name;
    this.budget = budget;
    System.out.println("Customer " + name + 
                       " with budget $"+budget + " has appeared.");
  }

  ////////////////////
  // Methods
  ////////////////////
  // finds the most expensive cake that they can buy from a store
  public int findCake(Store s){
    int chosen = 0;
    Cake[] cakes = s.displayCakes();
    for (int i = 0; i < cakes.length; i++){
      if (cakes[chosen].appraise() < cakes[i].appraise() && 
          cakes[i].appraise() <= this.budget) chosen = i;
    }
    if (cakes[chosen].appraise() == 0 || 
        cakes[chosen].appraise() > budget) return -1;
    return chosen;
  }

  // buys a cake, budget decreases
  public void buyCake(Store s, int index){
    this.budget -= s.displayCake(index).appraise();
    this.cakesBought += 1;
  }

  // gets money, maximum $1 billion
  public void getMoney(int m){
    int gained = Math.min(this.budget + m, 1000000000) - this.budget;
    System.out.println(this.name + " gained $" + gained);
    this.budget += gained;
  }

  //display stats
  public void displayStats(){
    System.out.println(this.name + " has $" + this.budget + 
                       " and " + this.cakesBought + " cake(s).");
  }

  public int appraise(){
    return this.budget;
  }

  public void goTo(Store s){
    this.location = s;
  }

  public void goHome(){
    this.location = this.home; 
  }
}