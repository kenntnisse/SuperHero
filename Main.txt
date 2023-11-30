// Shunzo Hida
// Super Hero Bake Sale
// 09-29-2023
// Period 5

/* Description:
 * This creates a world where there are SuperHeros 
    who bake Cakes for Stores,
    Stores that hold and sell Cakes to Customers, 
    and Customers who buy Cakes from Stores
 * It creates a random seed [2-11] that determines the capacity of the Store,
    the # of Customers, and # of SuperHeros
   * each Customer starts out with budget = i * 10000
   * each SuperHero starts out with level = i
 * It asks for user input on how many days to simulate
   * each Day is kept within a function, and the days happen within a for loop
   * each iteration asks for user input to continue
 * transaction(Customer c, Store s, int index) sells a Cake to
    a Customer, if index is valid
 * passDay(SuperHero[] supes, Store s, Customer[] customers)
   * each SuperHero creates a Cake, given to Store s
   * each Customer doubles their budget and buys the most expensive Cake they can.
   * Store stats are displayed and a new line is printed to separate days.
*/



/**
* This project needs to be a bake sale in which
* super heros use their super powers to bake cakes
* to raise money for the PTA.
*
* It must include custom types for the following:
* - SuperHero
* - Cake
* - Store
* - Customer
*
* In your Main class, you must create:
* - at least 2 hero instances
* - at least 2 customer instances
* - at least 1 store instance
* - at least 3 cake instances
*
* Both customers must buy a Cake at a store 
*   so the store can raise money for the PTA.
* Neither customer can spend 
*   more money than they have.
* The hero must get better at making cakes 
*   with each cake they make
* Better cakes are made by better cake makers 
*   and sell for more money than worse cakes
*
* You may use the Turtle object or not
* You may create a PTA type or not
* The store must raise 1 MILLION DOLLARS!
* You should use a "FOR" loop
* You may use Arrays
*/
import java.util.Random;
import java.util.Scanner;
class Main {
  // determines store capacity, # of superheros, # of customers
  static Random rand = new Random();
  static final int seed = rand.nextInt(10)+2;
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    // Takes input on how many days to run simulation
    System.out.print("SuperHero Baking Sim\nHow many days? ");
    int days = scan.nextInt();

    // creates list of superheroes with different skill levels
    SuperHero[] supes = new SuperHero[seed];
    for (int i = 0; i < seed; i++){
      supes[i] = new SuperHero("s"+(i+1), i+1);
    }

    // one single store
    Store s = new Store("PTA", seed);

    // creates a list of customers with different amounts of money
    Customer[] customers = new Customer[seed];
    for (int i = 0; i < seed; i++){
      customers[i] = new Customer("c"+(i+1), (i+1)*10000);
    }

    
    for (int i = 0; i < days; i++){
      System.out.print("Input to go to the next day: ");
      scan.next();
      System.out.println("Day " + i);
      passDay(supes, s, customers);
    }

    System.out.println("\nFINAL RESULTS");
    s.displayStats();
  }

  // completes a transaction: customer buys & store sells a Cake.
  public static void transaction(Customer c, Store s, int index){
    if (index == -1){
      System.out.println(c.name + " could not buy a cake.");
      return;
    }
    c.buyCake(s, index);
    s.sellCake(index);
  }

  // Simulates one day passing
  public static void passDay(SuperHero[] supes, Store s, Customer[] customers){
    //each SuperHero bakes a cake
    for (int i = 0; i < supes.length; i++){
      supes[i].createCake(s);
    }
    
    for (int i = 0; i < customers.length; i++){
      // money doubles every day
      customers[i].getMoney(customers[i].appraise()); 
      // transaction happens
      transaction(customers[i], s, customers[i].findCake(s)); 
    }
    s.displayStats();
    System.out.println();
  }
  
}