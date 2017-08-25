class PrintDemo {
  private int [] arr = new int[125];

  PrintDemo(){
   for(int i=10;i<=100;i++)
     arr[i]=i;
  }

  synchronized void printCount(int num) {
        for(int i = 10; i <= 100; i+=10) {
          arr[i] += num;
   }
   System.out.println("After modification : ");
   for(int i = 10; i <= 100; i+=10) {
     System.out.println(arr[i]);
   }
 }

}

class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   PrintDemo  PD;

   ThreadDemo( String name,  PrintDemo pd) {
      threadName = name;
      PD = pd;
   }

   public void run() {
        String name = t.getName();
        int num;

       if(name.compareTo("T1")==0)
       {
         num=10;
         PD.printCount(num);
       }
       else
        {
         num =  -2;
         PD.printCount(num);
       }
     }

   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}

public class ex3 {

   public static void main(String args[]) {
      PrintDemo PD = new PrintDemo();

      ThreadDemo T1 = new ThreadDemo( "T1", PD );
      ThreadDemo T2 = new ThreadDemo( "T2", PD );
      T1.start();
      T2.start();

      // wait for threads to end
      try {
         T1.join();
         T2.join();
      }catch( Exception e) {
         System.out.println("Interrupted");
      }
	//Statements to prove this is an example of multi-threading.
	/*	
      ThreadDemo T3 = new ThreadDemo( "T3", PD );
      T3.start();	
	*/
   }
}
