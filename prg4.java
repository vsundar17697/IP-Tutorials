import java.util.*;


class prg4
{
    public static void main(String args[])
    {
        System.out.println("Enter number of emp : ");
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        employee[] emp = new employee[n];
        for(int i=0 ; i<n;i++)
            emp[i] = new employee();
        for(int i=0;i<n;i++)
            emp[i].inputEmployee();
        for(int i=0;i<n;i++)    
            emp[i].displayEmployee();
    }
}