
import java.text.ParseException;


    
 public class Current extends MyControlPanel
 {
    public double balance;
    private String date;
    private int numWithdrawals;
    //private double interest;
     
     public Current(double enteredBal, String simDate, int withdrawals) throws ParseException
     {
        this.balance = enteredBal;
        this.date = simDate;
        this.numWithdrawals = withdrawals;
     }
     
     public double getBalance()
    {
        return this.balance;
    }
     
    public void setBalance(double enteredBal)
    {
        this.balance = enteredBal;
    }
    public String getDate()
    {
        return this.date;
    }
    
    public int getWithdrawals()
    {
        return this.numWithdrawals;
    }
 }
