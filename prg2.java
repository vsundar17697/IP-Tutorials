import java.util.*;

class prg2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String Str1 = in.nextLine();
        int flag = 0;
        char c = in.next().charAt(0);

        for (int i =0 ; i < Str1.length() ; i++)
        {
            if(c == Str1.charAt(i))
            {
                System.out.println("position at : " + (i+1));
                flag = 1;
            }
        }


        if(flag == 0)
        {
            System.out.println("Character not found");
        }    
    }
}