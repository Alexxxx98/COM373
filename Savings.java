
 import java.text.ParseException;
 import java.util.Arrays;
 import java.util.Scanner;


 public class Savings extends Accounts
 {
     private Accounts[] savingsAccount;
     
     public Savings(double balance, int numWithdrawals) throws ParseException
     {
         super(balance, numWithdrawals);
         this.savingsAccount = new Accounts[10];
         this.numWithdrawals = 0;
         this.size = 0;
     }
     
     public void addSavingsAcc() throws ParseException
     {
         Scanner in = null;
         in = new Scanner(System.in);
         
         System.out.print("Enter Balance:");
         balance = in.nextDouble();

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
     }
 }
