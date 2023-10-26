// Shunzo Hida
// Super Hero Bake Sale
// 10-23-2023
// Period 5

// name, net worth, pocket, 2 additional properties

// 3 methods: give, take, make


public class Person{
  // Properties
  String name;
  int netWorth;
  int age;
  char pocket;
  char whatIMake;
  String closet;


  //// Constructor
  Person(String name){
    this.name = name;
    this.netWorth = 0;
    this.pocket = ' ';
    this.age = 0;
    this.whatIMake = name.charAt(0);
  }


  //// Methods
  char give(){
    char temp = this.pocket;
    this.pocket = 0;
    return temp;
  }

  void take(char c){
    if (this.pocket != 0) this.addToCloset();
    this.pocket = c;
  }

  void make(){
    this.pocket = this.whatIMake;
  }

  void getOld(int time){
    this.age += time;
    this.whatIMake = this.name.charAt(age%this.name.length());
  }

  void show(){
    System.out.println(this.name + " has " + this.pocket+" and closet " + this.closet);
  }

  void addToCloset(){
    this.closet += this.pocket;
    this.pocket = 0;
  }
}