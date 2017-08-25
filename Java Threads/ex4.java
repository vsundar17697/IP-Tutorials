import java.util.LinkedList;
import java.util.Queue;

class PC
{
  //Queue shared by both the producer and the consumer.
  //Creating a queue.
  Queue<Integer> q = new LinkedList<>();
  int lim=1;

  //Function called by the producer thread.
  public void produce() throws InterruptedException
  {
    int val=0;
    while(true){
      synchronized(this){
        //Producer waits if queue is full.
        while(q.size() == lim)
         wait();

        System.out.println("Producer produced : " + val);

        //Insert the produced items into the queue.
        q.add(val++);

        //Notify the consumer that now it can consume.
        notify();

        if(val==5) break;

      }
    }
  }

  public void consume() throws InterruptedException
  {

    while(true){
      synchronized(this){
        //Consumer thread waits while queue is empty.
        while(q.size()==0)
         wait();

        //To retrieve a job from the queue.
        int val = q.remove();

      //  System.out.println(q.size());
        System.out.println("Consumer consumed : " + val);

          if(val==4)
            System.exit(0);

        //Wake up the producer thread
        notify();

      }
    }
  }


}


class producer extends Thread
{
  PC pc;

  producer(PC pcnew){
    pc = pcnew;
  }

  public void run(){
  try{
   pc.produce();
  }
  catch(InterruptedException e){
    e.printStackTrace();
  }
 }
};


class consumer extends Thread
{

    PC pc;

  consumer(PC pcnew)
  {
        pc = pcnew;
  }

  public void run(){
     try{
       pc.consume();
      }
      catch(InterruptedException e){
        e.printStackTrace();
      }
   }

};

public class ex4 {
  public static void main(String args[]) throws InterruptedException
  {
    PC pc = new PC();
    producer  pd = new producer(pc);
    consumer  cn = new consumer(pc);
    pd.start();
    cn.start();

    pd.join();
    cn.join();
  }
}
