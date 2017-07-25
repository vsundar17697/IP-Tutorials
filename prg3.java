import java.util.*;

class prg3
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String Str1 = in.nextLine();
        int[] a = new int[30]; 

            int max = 0;

        for(int i=0;i<30;i++)
        {
            a[i] = 0;
        }

      

            for( int i =0 ; i < Str1.length() ; i++)
                {
                    char c1 = Str1.charAt(i);

                    a[c1 - 97]++;
                }
            for(int i =0; i < 30 ; i++)
            {
                if(a[i] > a[max])
                {
                    max = i;
                }
            }    
        
    

            System.out.println((char)(max + 97) + " is highest occurence " + a[max] );
       

    }
}