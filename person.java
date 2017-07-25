import java.util.*;

public class person
{
    public String name;
    public int date;

    public void displayPerson() 
    {
        System.out.println("Name : " + name + "\nDate : " + date);
    }

    public void inputPerson()
    {
        System.out.println("name : date");

        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        date = in.nextInt();
    }
}