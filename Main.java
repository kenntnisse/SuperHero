// Shunzo Hida
// Super Hero Bake Sale
// 10-23-2023
// Period 5

class Main{
  public static void main(String[] args){
    Person a = new Person("Alice");
    Person b = new Person("Bobby");
    
    for (int i = 0; i < 20; i++){
      a.make(); b.make();
      b.take(a.give());
      a.show(); b.show();
      System.out.println();
    }
    System.out.println("Run complete.");
  }
}