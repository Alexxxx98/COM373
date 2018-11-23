
import java.text.ParseException;



public class Accounts extends MyControlPanel
{
    
    public static Savings mySavings; 
    
    public static void main(String[] args) throws ParseException 
    {
        mySavings = new Savings(0, "", 0);
        MyFrame frame = new MyFrame();
        System.out.println(mySavings.getBalance());
    }
    
    public void setBalance()
    {
        mySavings.setBalance();
    }
}