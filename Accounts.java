
import java.text.ParseException;



public class Accounts extends Timers
{
    public double balance;
    public double balChange;
    public String date;
    private int numWithdrawals = 0;
    
    public Accounts(double enteredBal, double balanceChange, String simDate, int withdrawals)
    {
        this.balance = enteredBal;
        this.balChange = balanceChange;
        this.date = simDate;
        this.numWithdrawals = withdrawals; 
    }
    
    
    public static void main(String[] args) throws ParseException
    {
        
        MyFrame frame = new MyFrame();
        
    }
    
    
}