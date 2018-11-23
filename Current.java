
import java.text.ParseException;


    
 public class Current extends Accounts
 {
    private double balance = 0;
    private String date = "";
    private int numWithdrawals = 0;
    //private double interest;
     
     public Current(double enteredBal, String simDate, int withdrawals) throws ParseException
     {
         //super(balance, date, numWithdrawals);
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
