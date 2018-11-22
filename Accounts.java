
import java.text.ParseException;



public class Accounts 
{
    private double balance;
    private int date;
    private int numWithdrawals = 0;
    private double interest;
    private int size = 0;
    
    

    public Accounts(double balance, int date, int numWithdrawals)throws ParseException
    {
    this.balance = balance;
    this.date = date;
    this.numWithdrawals = numWithdrawals;
    }
    
    public double getBalance()
    {
        return this.balance;
    }
    
    public double getDate()
    {
        return this.date;
    }
    
    public double getNumWithdrawals()
    {
        return this.numWithdrawals;
    }
    public int getSize()
    {
        return this.size;
    }
    public static void main(String[] args) throws ParseException 
    {
        MyFrame frame = new MyFrame();

    
    }
}