// Shunzo Hida
// Super Hero Bake Sale
// 09-29-2023
// Period 5


/*
 * Description:
 * SuperHeroes are bakers who bake cakes
 * Constructor creates a superhero with String name and int level
 * createCake takes parameter Store s, and asks for y/n answer to whether to create cake
   * if yes, creates a cake of cost = level*1000, 
      level increases by one, gives the cake to Store s, and displays the cake
   * if no, nothing happens.
 */

import java.util.Scanner;
public class SuperHero{
  /////////////////////
  // Properties
  /////////////////////
  String name;
  int level;


  ////////////////////
  // Constructor
  ////////////////////
  public SuperHero(String name, int level){
    this.name = name;
    this.level = level;
    System.out.println("The level " + level + " SuperHero " + 
                       name + " has appeared.");
  }

  ////////////////////
  // Methods
  ////////////////////

  // creates a cake for Store s
  public void createCake(Store s){
    Scanner scan = new Scanner(System.in);
    // input on if they bake a cake y/n
    System.out.print("y/n Create a new cake? ");
    String input = scan.next();
    if (!input.equals("y")) return;

    // a cake with cost depending on level
    int cost = this.level*1000;
    Cake c = new Cake(cost);
    
    System.out.println(this.name + " baked a cake worth $" + cost + 
                       " and gave it to store " + s.name);

    // gives to Store
    s.getCake(c);
    // gets better
    this.level++;
    // displays cake
    c.view();
  }
}