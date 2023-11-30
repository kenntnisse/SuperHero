// Shunzo Hida
// Super Hero Bake Sale
// 10-23-2023
// Period 5

// name, net worth, pocket, 2 additional properties

// 3 methods: give, take, make

import java.util.Random;
import java.util.HashMap;
public class Person{
  // Properties
  String name;
  char whatIMake;
  int netWorth = 0;
  int age = 0;
  char pocket = 0;
  String closet = new String();
  Random chance = new Random();


  //// Constructor
  public Person(String name){
    this.name = name;
    this.whatIMake = name.charAt(0);
    /*
    this.netWorth = 0;
    this.pocket = 0;
    this.age = 0;
    this.closet = new String();
    */

    int k = this.chance.nextInt(10);
    for (int i = 0; i < k; i++){
      this.addToCloset((char)(this.chance.nextInt(95)+32));
    }
    
  }


  //// Methods
  char give(){
    char temp = this.pocket;
    this.pocket = 0;
    if (temp == 0) System.out.println(temp);
    return temp;
  }

  void take(char c){
    if (this.pocket != 0) this.addToCloset();
    this.pocket = c;
  }

  void make(){
    if (this.pocket != 0) this.addToCloset();
    this.pocket = this.whatIMake;
  }

  void passTime(int time){
    this.age += time;
    this.whatIMake = 
      this.name.charAt(age%this.name.length());
  }

  void show(){
    System.out.println(this.name + ", worth $" + 
                       this.netWorth + ", has '" + 
                       this.pocket+"' and closet \"" 
                       + this.closet + "\"");
  }

  void addToCloset(){
    if (this.closet.length() % 6 == 5) this.closet+=',';
    this.closet += this.pocket;
    this.pocket = 0;
    if (this.closet.length() % 6 == 5) this.passTime(1);
    calcNetWorth();
  }

  void addToCloset(char c){
    if (this.closet.length() % 6 == 5) this.closet+=',';
    this.closet += c;
    if (this.closet.length() % 6 == 5) this.passTime(1);
    calcNetWorth();
  }

  int calcNetWorth2(){
    this.netWorth = 0;
    HashMap<Character, Integer> data = new HashMap<Character, Integer>(); // counts all occurrences
    int l = this.closet.length();
    for (int i = 0; i < l; i++){
      if (i%6!=5){
        char cur = this.closet.charAt(i);
        data.put(cur, data.getOrDefault(cur,0)+1);
      }
    }

    // edge cases
    if (l == 0) return 0;
    else if (l == 1) return netWorth = 1;
    else if (l == 2 && this.closet.charAt(0) == this.closet.charAt(1)) return netWorth = 20;
    else if (l == 2) return netWorth = 2;

    //first char
    if (this.closet.charAt(0) == this.closet.charAt(1)) this.netWorth+=10;
    else if (data.get(this.closet.charAt(0)) > 1) this.netWorth+=5;
    else this.netWorth++;
    
    for (int i = 1; i < l-1; i++){
      if (i%6!=5){
        char cur = this.closet.charAt(i);
        if (cur == this.closet.charAt(i-1) || cur == this.closet.charAt(i+1)) this.netWorth+=10;
        else if (data.get(cur) > 1) this.netWorth+=5;
        else this.netWorth++;
      }
    }

    //last char
    if (this.closet.charAt(l-1) == this.closet.charAt(l-2)) this.netWorth+=10;
    else if (data.get(this.closet.charAt(l-1)) > 1) this.netWorth+=5;
    else this.netWorth++;

    
    return this.netWorth;
  }


  int calcNetWorth(){
    //this.closet = "BBAB"; //test cases
    HashMap<Character, Integer> data = new HashMap<Character, Integer>(); // counts all occurrences
    int l = this.closet.length();


    //edge cases
    if (l == 0) return 0;
    else if (l == 1) return netWorth = 1;
    else if (l == 2 && this.closet.charAt(0) == this.closet.charAt(1)) return netWorth = 20;
    else if (l == 2) return netWorth = 2;



    
    data.put(this.closet.charAt(0), 1);
    int ans = 1;
    if (this.closet.charAt(0) == this.closet.charAt(1)) ans += 5;
    for (int i = 1; i < l-1; i++){
      if (i%6!=5){
        char cur = this.closet.charAt(i);
        char prev = this.closet.charAt(i-1);
        char next = this.closet.charAt(i+1);
        int occ = data.getOrDefault(cur,0); // default occurrences is 0
        ans++; // everything is at least worth 1
        if (occ == 1)//first occurrence is not counted as duplicate
          ans += 8;
        else if (occ > 1) // if duplicate
          ans += 4;
        if (cur == prev || cur == next) // next to a duplicate
          ans += 5;
        data.put(cur, occ+1); // adds to collection
      }
    }
    char cur = this.closet.charAt(l-1);
    char prev = this.closet.charAt(l-2);
    int occ = data.getOrDefault(cur,0); // default occurrences is 0
    ans++; // everything is at least worth 1
    if (occ == 1)//first occurrence is not counted as duplicate
      ans += 8;
    else if (occ > 1) // if duplicate
      ans += 4;
    if (cur == prev) // next to a duplicate
      ans += 5;
    this.netWorth = ans;
    return this.netWorth;
  }

  
  
  private void findRepeat(){
    this.closet = "ABACAD";
    int ans = 0;
    for (int i = 0; i < this.closet.length(); i++){
      char cur = this.closet.charAt(i);
      String b = this.closet.substring(i+1);
      if (b.indexOf(cur) != -1){
        ans++;
      }
    }
    System.out.println(ans);
  }
}