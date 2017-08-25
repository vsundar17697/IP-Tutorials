import java.util.*;

class parent{
  String name;
  void input(){
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter the name : ?\n");
    name = sc.nextLine();
  }
}

class child extends parent{
  void display(){
    System.out.println("After inheritance : " + name);
  }
}

public class inheritance {
  public static void main(String args[]){
    child ob = new child();
    ob.input();
    ob.display();
  }
}
