// Create a thread to print characters a to j uwing threaed class and runnable inheritence

import java.util.*; 

class prg6 extends Thread{
   public String t_name;
    prg6(String name){
        t_name=name;
    }
   public void run(){
        for(char ch='a';ch<='j';ch++)
        {
            System.out.println(ch);
        }
    }

public static void main(String args[]) {
    prg6 t = new prg6("thread");
    Thread T= new Thread(t);
    T.start();
}
}