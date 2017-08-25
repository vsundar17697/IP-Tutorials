class threads implements Runnable {

  Thread t;
  
  public void run(){
    System.out.println("Implementing Runnable Interface :)");
  }

  public void start(){
    if(t==null){
      t = new Thread(this);
      t.start();
    }
  }
}

public class practiceRI{
 public static void main(String args[]){
   threads t1 = new threads();
   t1.start();
 }
}
