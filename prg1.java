import java.util.*;

class prg1
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String Str1 = in.nextLine();
        String Str2 = in.nextLine();
        int[] a = new int[30]; 
        int[] b = new int[30]; 

        int flag = 0;

        for(int i=0;i<30;i++)
        {
            a[i] = 0;
            b[i] = 0;
        }

        if(Str1.length() == Str2.length())
        {
            Str1.toLowerCase();
            Str2.toLowerCase();
            for( int i =0 ; i < Str1.length() ; i++)
                {
                    char c1 = Str1.charAt(i);
                    char c2 = Str2.charAt(i);

                    a[c1 - 97]++;
                    b[c2 - 97]++;
                }
            flag = 1;

            for(int i =0; i < 30 ; i++)
            {
                if(a[i]!=b[i])
                {
                    flag = 0;
                    break;
                }
            }    
        }
        else
        {
            flag = 0;
        }

        if(flag == 1)
        {
            System.out.println("are anagrams");
        }
        else
        {
            System.out.println("not anagrams");
        }

    }
}