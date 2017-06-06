package socsecexception;
/**
 *
 * @author deeso
 */
public class SocSecException extends Exception
{
    private String error;
    
    public SocSecException(String error)
    {
       super(error);
       this.error = error;
    }
    public String toString() {
        return "Invalid Social Security Number, " +error; 
    }   
}
