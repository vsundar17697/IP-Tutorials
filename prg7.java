//create two threads that access an one d array containing 10 to 100, thread 1 updates array by inc by 10 and thread 2 decremetns by 2
import java.util.*;
 class inc extends Thread{
    String t_name;
    int[] arr=new int[91];
    inc(String name,int[] arr){
        this.arr=arr;
        t_name=name;
    }
    public void run()
    {
        for(int i=0;i<91;i++)
        {
            arr[i]+=10;
            System.out.println(arr[i]);
        }
    }
     
}

class dec extends Thread{
    String t_name;
    int[] arr=new int[91];
    dec(String name,int[] arr){
        this.arr=arr;
        t_name=name;
    }
    public void run()
    {
        for(int i=0;i<91;i++)
        {
            arr[i]-=2;
            
        }
    }
     
}

public class prg7{
public static void main(String args[])
   {
       int[] arr= new int[91];
       for(int i=0;i<91;i++)
       arr[i]=i+10;
       inc t= new inc("thread",arr);
       dec t1=new dec("thread1",arr);
       Thread th= new Thread(t);
       Thread th1=new Thread(t1);
       th.start();
       th1.start();
       

   }
}