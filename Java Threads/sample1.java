class ThreadDemo extends Thread {
  private Thread t;
  private String threadName;

  ThreadDemo(String name){
    threadName = name;
    System.out.println("Creating : " + threadName);
  }

  public void run(){
    for(char i='A';i<='J';i++){
      System.out.println(" Thread : " + threadName + ", " + (i));
    }
    System.out.println("Thread : " + threadName + " exiting.");
  }

  public void start(){
    System.out.println("Starting : " + threadName);
    if(t == null){
      t = new Thread(this,threadName);
      t.start();
    }
  }

}

public class sample1{
  public static void main(String args[]){
    ThreadDemo R1 = new ThreadDemo("T1");
    R1.start();
  }
}
