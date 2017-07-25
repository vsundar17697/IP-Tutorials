//

import java.util.*;

class prg5{

    static class Person
    {
        String name , address , email , mobile;
        void input_person()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nEnter name :");
            name = sc.nextLine();
            System.out.println("\nEnter address :");
            address = sc.nextLine();
            System.out.println("\nEnter email :");
            email = sc.nextLine();
            System.out.println("\nEnter mobile :");
            mobile = sc.nextLine();                       
        }
        void output_person()
        {
            System.out.println("\nName : " + name);
            System.out.println("\naddress : " + address);
            System.out.println("\nemail : " + email);
            System.out.println("\nmobile : " + mobile);
        }
    }

    static class accountHolder extends Person
    {
        String accno;
        String type;
        float amount , interest;
        void input_account()
        {
            Scanner sc = new Scanner(System.in);

            input_person();
            System.out.println("\nEnter accno :");
            accno = sc.nextLine();
            System.out.println("\nEnter type :");
            type = sc.nextLine();
            System.out.println("\nEnter amount :");
            amount = sc.nextFloat();              
        }
        void output_account()
        {
            output_person();
            System.out.println("\naccno : " + accno);
            System.out.println("\ntype : " + type);
            System.out.println("\namount : " + amount);
            System.out.println("\ninterest : " + interest);
        }

        void calc_interest()
        {
            
        }

        String retType()
        {
            return type;
        }
    }

    static class SBI extends accountHolder
    {
        float int_rate_sb , int_rate_ca;

        SBI()
        {
            int_rate_ca = 0;
            int_rate_sb = 0;
        }
        void input_accountHolder()
        {
                    Scanner sc = new Scanner(System.in);

            input_account();
            String specType = retType();

            if(specType.equals("SB"))
            {
                System.out.println("\nEnter interest rate SB : ");
                int_rate_sb = sc.nextFloat();
                calc_interest();
            }
            else
            {
                System.out.println("\nEnter interest rate CA : ");
                int_rate_ca = sc.nextFloat();
                calc_interest();           
            }
        }

        @Override
        void calc_interest() {
            super.calc_interest();
            if(type.equals("SB"))
            interest = super.amount * int_rate_sb / 100;
            else
            interest = super.amount * int_rate_ca / 100;

        }

        void output_SBI()
        {
            output_account();
        }

    }


    public static void main(String args[])
    {
        SBI x = new SBI();
        x.input_accountHolder();
        x.output_SBI();
    }
}    