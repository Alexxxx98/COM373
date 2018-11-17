
import java.text.ParseException;


    
 public class Current extends Accounts
 {
     private Accounts[] currentAccount;
     
     public Current(double balance, int numWithdrawals)throws ParseException
     {
         super(balance, numWithdrawals);
         this.currentAccount = new Accounts[100];
         this.numWithdrawals = 0;
         
     }
 }
