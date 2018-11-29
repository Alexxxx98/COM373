
import java.text.ParseException;
import java.util.Arrays;



public class Accounts extends Timers implements Comparable
{
    public static double  balance;
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
    
    public boolean equals(Accounts other)
    {
        return this.getBalance() == other.getBalance();
    }
    @Override
    public int compareTo(Object temp) 
    {
	Accounts other = (Accounts) temp;
        if (getBalance() > other.getBalance())
        {
            return 1;
        }else if(getBalance() < other.getBalance())
        {
            return -1;
        }else
        return	0;
    }	
    public double getBalance()
    {
        return this.balance;
    }
    public static void main(String[] args) throws ParseException
    {
        
        MyFrame frame = new MyFrame();
        Accounts a1 = new Accounts(100, 500, "dtring" ,0);
        Accounts a2 = new Accounts(400, 500, "dtring" ,0);
        int result = a1.compareTo(a2);
        
        if (result < 0)
            System.out.println(a1.getBalance() + " comes before" + a2.getBalance());
        else if(result > 0 )
            System.out.println(a2.getBalance() + " comes before" + a1.getBalance());
            
    }
    
    
}