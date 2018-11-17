
import java.text.ParseException;



public class Accounts 
{
    public double balance;
    public int numWithdrawals;
    private double interest;
    public int size;
     
    public Accounts(double balance, int numWithdrawals)throws ParseException
    {
    this.balance = balance;
 
    this.numWithdrawals = numWithdrawals;
    }
     
    public static void main(String[] args) throws ParseException 
    {
        //Accounts a1 = new Accounts();
        //Savings s1 = new Savings(1.0, 1, 1);
        MyFrame frame = new MyFrame();
        


        
    
    }
}