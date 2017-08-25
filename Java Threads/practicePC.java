import java.util.*;

class Queuer{
  Queue<Integer> q = new LinkedList<>();
  int lim=2,val=0,end=6;
  int localval=0;

  public void produce() throws InterruptedException{
  while(true){
   synchronized(this)
   {
    if(q.size() == lim)
     wait();

       System.out.println(" Producer produced : " + val);
    q.add(val++);

    notify();

    if(val==end)
     break;
    }
   }
 }

 public void consume() throws InterruptedException{
 while(true){
  synchronized(this)
  {
   if(q.size() == 0)
    wait();

   localval = q.remove();

   System.out.println(" Consumer consumed : " + localval);
   notify();

   if(localval==end-1)
    return;
   }
  }
}

}

class threads extends Thread {
  Thread t;
  String tname;
  Queuer queue;

  threads(String name,Queuer q){
   queue = q;
   tname = name;
 }

  public void start(){
    if(t==null){
      t = new Thread(this,tname);
      t.start();
    }
  }

  public void run(){
   String temp = t.getName();
   try{
    if(temp.compareTo("P")==0)
     queue.produce();
    else if(temp.compareTo("C")==0)
     queue.consume();
   }
   catch(InterruptedException e){
    e.printStackTrace();
   }
 }

}

public class practicePC {
  public static void main(String args[]) throws InterruptedException{
    Queuer ob = new Queuer();
    threads t1 = new threads("P",ob);
    threads t2 = new threads("C",ob);

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
}
