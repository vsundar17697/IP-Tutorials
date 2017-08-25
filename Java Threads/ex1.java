//Threads Practice.

class mythread extends Thread {
  private String tname;
  Thread t;

  mythread(String name){
    tname = name;
  }

  public void run(){
    for(char ch='a';ch<='j';ch++)
    {
      System.out.println(ch);
    }
    System.out.println(t.getName());
  }

  public void start(){
    if(t==null){
      t = new Thread(this);
    }
    t.start();
  }
}

public class ex1 {
 public static void main(String args[]){
   mythread t1 = new mythread("T1");
   t1.start();
 }
}
