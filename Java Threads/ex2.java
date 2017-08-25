class RunnableDemo implements Runnable {
  private Thread t;
  private String threadName;

  RunnableDemo(String name){
    threadName = name;
    System.out.println("Creating " + threadName);
  }

  public void run(){
    System.out.println("Running " + threadName);
    for(char ch='a';ch<='j';ch++)
    {
      System.out.println(ch);
    }
    }
   void start(){
    if(t==null){
      t = new Thread(this);
    }
    t.start();
   }
}


public class ex2 {
  public static void main(String args[]){
    RunnableDemo R1 = new RunnableDemo("T1");
    R1.start();
  }
}
