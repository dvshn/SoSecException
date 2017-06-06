package socsecexception;
/**
 *
 * @author deeso
 */
import java.util.Scanner;
import java.lang.Exception;

        
public class SocSecProcessor
{
    
    static SocSecException excep;
    static String error="";
    
    public static void main(String[] args)
    {    
        String name,SSN="";
        String choice="";
        
        boolean terminate = false;
        
        while(!terminate)
        {
                Scanner input = new Scanner(System.in);
                System.out.printf("Enter Name\t: ");
                name = input.nextLine();
                System.out.printf("Enter SSN\t: ");
                SSN = input.next();
       
                if(isValid(SSN))
                {
                     System.out.println(name+" "+SSN+" is valid.");   
                }
                else
                    System.out.println(error);
            
                while(true)
                {
                    System.out.printf("Continue(y/n)\t: ");
                    choice = input.next();
                    choice = choice.toLowerCase();
        
                    if(choice.equals("n"))
                    {
                        terminate = true;
                        break;
                    }
                    else if(choice.equals("y"))
                    {
                        break;
                    }
                }
        }
    }
    public static boolean isValid(String ssn)
    {
        boolean valid = true;
        
        try{
        if(ssn.length() != 11)
        {
            throw new SocSecException("wrong number of characters.");
        }
        else if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
        {
            throw new SocSecException("dashes at wrong position.");
        }
        else
        {
            for(int x=0;x<ssn.length();x++)
            {
                if(ssn.charAt(x) == '-' || Character.isDigit(ssn.charAt(x)))
                    continue;
                else
                {
                    throw new SocSecException("contains a character that is not a number.");
                }
            }
        }
        }catch(SocSecException e)
        {
            error = e.toString();
            valid = false;
        }
    
        return valid;
    }
}
    
