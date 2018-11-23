
 import java.text.ParseException;
 import java.util.Arrays;
 import java.util.Scanner;


 public class Savings extends Accounts
 {
    
     
     public double balance;
     public String date;
     public int numWithdrawals;
     
     public Savings(double enteredBal, String simDate, int withdrawals) throws ParseException
     {
        this.balance = enteredBal;
        this.date = simDate;
        this.numWithdrawals = withdrawals;
     }
     
     public double getBalance()
     {
         return this.balance;
     }
     public void setBal(double b)
     {
         this.balance = b;
     }
     
     public String getDate()
     {
         return this.date;
     }
     
     public int getNumWithdrawals()
    {
        return this.numWithdrawals;
    }

     /*public void addSavingsAcc() throws ParseException
     {
         Scanner in = null;
         in = new Scanner(System.in);
         
         System.out.print("Enter Balance:");
         this.balance = in.nextDouble();

         System.out.print("Enter Number of withdrawals:");
         numWithdrawals = in.nextInt();
         
         this.savingsAccount[size] = new Accounts(balance, numWithdrawals);
         this.size++;
         System.out.println(this.balance + " " + this.numWithdrawals);
         //System.out.println(Arrays.toString(savingsAccount));
     }
     
     public void displayDetails()
     { 
         //NumberFormat money = NumberFormat.getCurrencyInstance();
         System.out.println("Balance: " + this.balance);
         System.out.println("Recipient: " + this.numWithdrawals);      
     }*/
 }
