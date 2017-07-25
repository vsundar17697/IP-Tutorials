 import java.util.*;



public class employee extends person
{
    public int ecode;
    public int salary;
    public int doj;

    public void displayEmployee()
    {
        System.out.println("Ecode : " + ecode + "\nSalary : " + salary + "\nDOJ : " + doj);
        displayPerson();
    }

    public void inputEmployee()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("ecodee : salary : doj");
        ecode = in.nextInt();
        salary = in.nextInt();
        doj = in.nextInt();
        inputPerson();
    }
}
