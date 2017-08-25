class array{
  private int [] arr = new int[125];

  array(){
    for(int i=1;i<=10;i++)
     arr[i] = (i*10);

          for(int i=1;i<=10;i++)
           System.out.print(arr[i] + " ");
          System.out.println(" ");
  }

  synchronized void modify(int num){

    for(int i = 1; i<=10 ; i++)
     arr[i] += num;

     System.out.println("After modification : ");

     for(int i=1;i<=10;i++)
      System.out.print(arr[i] + " ");
     System.out.println(" ");

  }

}

class threads extends Thread{
  private Thread t;
  private int n;
  String tname;
  array arr;

  threads(int num,String name,array ob){
    arr = ob;
    tname = name;
    n = num;
  }

  public void start(){
    if(t==null){
      t = new Thread(this,tname);
      t.start();
    }
  }

  public void run(){
    //System.out.println("Thread : " + t.getName() + ".");
    arr.modify(n);
  }
}

public class practice{
public static void main(String args[]) throws InterruptedException
{
   array ob = new array();
   threads t1 = new threads(10,"T1",ob);
   threads t2 = new threads(-2,"T2",ob);
   t1.start();
   t2.start();

   t1.join();
   t2.join();
 }
}
