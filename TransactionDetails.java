
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class TransactionDetails 
{
    private Transaction[] spendingLog;
    private int size;
    private double totalSpent;
    private int date;
    private String category;
    private String recipient;
    private double moneySpent;
    private double totalSpent2;

    
    public TransactionDetails()
    {
        this.spendingLog = new Transaction[10];
        this.size = 0;
        this.totalSpent = 0.0; 

    }
    
    public void addTransaction() throws ParseException, IOException
    {
        //Scanner in = new Scanner(System.in);
         
        Scanner in = null;
        in = new Scanner(System.in);
        
        String[] myStringArray = { "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10" };
        
        System.out.print("Enter date:");
        String dateString = in.next();
        
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateF = formatter.parse(dateString);
            DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
            String date2 = formatter2.format(dateF);
            date = Integer.parseInt(date2);
        
        System.out.print("Enter Category:");
        category = in.next();
        while (!Arrays.asList(myStringArray).contains(category))
        {
            System.out.println("Please eneter a valid category");
            category = in.next();
        }     
        
        System.out.print("Enter Recipient:");
        recipient = in.next();
        
        
        System.out.print("Enter Money Spent:");
        moneySpent = in.nextDouble();
        
        this.spendingLog[size] = new Transaction(date, category, recipient, moneySpent);
        this.totalSpent += moneySpent;
        this.spendingLog[size].printToFile();
        this.size++;
        
    }
    
    public void displayDetails()
    { 
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("Date: " + this.date);
        System.out.println("Category: " + this.category);
        System.out.println("Recipient: " + this.recipient);
        System.out.println("Money Spent: " +
        money.format(this.moneySpent));
       
    }
    
    
        
    public void getdetails() throws IOException
    {
        for (int i=0; i<spendingLog.length ; i++)
        {
            System.out.println(spendingLog[i]);
        }

    }
    public void getFromFile() throws IOException, ParseException
    {
        Scanner getIn = null;
        try
        {
            getIn = new Scanner(new File("TransactionDetails.txt"));
        }catch (FileNotFoundException ex)
        { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        if(getIn.hasNextLine())
        {
            
            while(getIn.hasNextInt())
            {
            int inDate = getIn.nextInt();
            
            String inCategory = getIn.next();
            String inRecipient = getIn.next();
            double inMoneySpent = getIn.nextDouble();
         
           
            this.date = inDate;
            this.category = inCategory;
            this.recipient = inRecipient;
            this.moneySpent = inMoneySpent;
            this.spendingLog[size] = new Transaction(date, category, recipient, moneySpent);
            size++;
            totalSpent += moneySpent;
            } 
        }
    } 
    
    public double getTotalSpent()
    {
        return totalSpent;
    }
    
    public void reportTotalSpent() throws ParseException
    {
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
        
        System.out.print("Enter first date:");
        String dateString = in.next();
        Date eDate = formatter.parse(dateString);
        String date2 = formatter2.format(eDate);
        int eDate2 = Integer.valueOf(date2);
        
        System.out.print("Enter second date:");
        String dateString2 = in.next();
        Date lDate = formatter.parse(dateString2);
        String date3 = formatter2.format(lDate);
        int lDate2 = Integer.valueOf(date3);
        
        Scanner getIn = null;
        try
        {
            getIn = new Scanner(new File("TransactionDetails.txt"));
        }catch (FileNotFoundException ex)
        { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        for(int i =0; i < spendingLog.length; i++)
        {
            
            if(getIn.hasNextLine())
            {
                if(getIn.hasNextInt())
                {
                    
                    int inDate = getIn.nextInt();
                    this.date = inDate; 
               
                
                    String inCategory = getIn.next();
                    String inRecipient = getIn.next();
                    double inMoneySpent = getIn.nextDouble();
                    if(inDate > eDate2 && inDate < lDate2)
                    {
                        //System.out.println(spendingLog[i]);
                        totalSpent2 += inMoneySpent;
                        
                    }
                }  
                
            }
           
        }
        System.out.println(money.format(this.totalSpent2));
        
        
    }
    
    public void reportTotalSpentCat() throws ParseException
    {
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
        
        System.out.print("Enter first date:");
        String dateString = in.next();
        Date eDate = formatter.parse(dateString);
        String date2 = formatter2.format(eDate);
        int eDate2 = Integer.valueOf(date2);
        
        System.out.print("Enter second date:");
        String dateString2 = in.next();
        Date lDate = formatter.parse(dateString2);
        String date3 = formatter2.format(lDate);
        int lDate2 = Integer.valueOf(date3);
        
        System.out.print("Enter category:");
        int inCat = in.nextInt();
        
        
        Scanner getIn = null;
        try
        {
            getIn = new Scanner(new File("TransactionDetails.txt"));
        }catch (FileNotFoundException ex)
        { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        for(int i =0; i < spendingLog.length; i++)
        {
            
            if(getIn.hasNextLine())
            {
                if(getIn.hasNextInt())
                {
                    
                    int inDate = getIn.nextInt();
                    this.date = inDate; 
               
                
                    String inCategory = getIn.next();
                    String inRecipient = getIn.next();
                    double inMoneySpent = getIn.nextDouble();
                    int intCat = Integer.valueOf(inCategory);
                    if(inDate > eDate2 && inDate < lDate2 && inCat == intCat)
                    {
                        System.out.println(spendingLog[i]);
                        totalSpent2 += inMoneySpent; 
                    }
                }      
            }  
        }
        System.out.println(money.format(totalSpent2));
    }
    
    public void reportGetrecords() throws ParseException
    {
        
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
        
        System.out.print("Enter first date:");
        String dateString = in.next();
        Date eDate = formatter.parse(dateString);
        String date2 = formatter2.format(eDate);
        int eDate2 = Integer.valueOf(date2);
        
        System.out.print("Enter second date:");
        String dateString2 = in.next();
        Date lDate = formatter.parse(dateString2);
        String date3 = formatter2.format(lDate);
        int lDate2 = Integer.valueOf(date3);
        
        Scanner getIn = null;
        try
        {
            getIn = new Scanner(new File("TransactionDetails.txt"));
        }catch (FileNotFoundException ex)
        { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        for(int i =0; i < spendingLog.length; i++)
        {
            
            if(getIn.hasNextLine())
            {
                if(getIn.hasNextInt())
                {
                    
                    int inDate = getIn.nextInt();
                    this.date = inDate; 
               
                
                    String inCategory = getIn.next();
                    this.category = inCategory;
                    String inRecipient = getIn.next();
                    this.recipient = inRecipient;
                    double inMoneySpent = getIn.nextDouble();
                    this.moneySpent = inMoneySpent;
                    if(inDate > eDate2 && inDate < lDate2)
                    {
                        System.out.println(this.date + " " + this.category + " " + this.recipient + " " + money.format(this.moneySpent));
                    }
                    //System.out.println(this.date + " " + this.category + " " + this.recipient + " " + this.moneySpent);
                }
                
            }
             
        }
    }  
    public void reportGetRecordsRecipient() throws ParseException
    {
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
        
        System.out.print("Enter first date:");
        String dateString = in.next();
        Date eDate = formatter.parse(dateString);
        String date2 = formatter2.format(eDate);
        int eDate2 = Integer.valueOf(date2);
        
        System.out.print("Enter second date:");
        String dateString2 = in.next();
        Date lDate = formatter.parse(dateString2);
        String date3 = formatter2.format(lDate);
        int lDate2 = Integer.valueOf(date3);
        
        System.out.print("Enter recipient:");
        String inRec = in.next();
        
        Scanner getIn = null;
        try
        {
            getIn = new Scanner(new File("TransactionDetails.txt"));
        }catch (FileNotFoundException ex)
        { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        for(int i =0; i < spendingLog.length; i++)
        {
            
            if(getIn.hasNextLine())
            {
                if(getIn.hasNextInt())
                {
                    
                     
                    int inDate = getIn.nextInt();
                    Date recDate2 = formatter2.parse(Integer.toString(inDate));
                    String formatDate = formatter.format(recDate2);
                
                    String inCategory = getIn.next();
                    this.category = inCategory;
                    String inRecipient = getIn.next();
                    this.recipient = inRecipient;
                    double inMoneySpent = getIn.nextDouble();
                    this.moneySpent = inMoneySpent;
                    if(inDate > eDate2 && inDate <  lDate2)
                    {
                        if (inRec.equals(inRecipient)) 
                        {
                            System.out.println(formatDate + " " + this.category + " " + this.recipient + " " + money.format(this.moneySpent));
                        }
                        
                    }
                }
                
            }
             
        }
    }
}