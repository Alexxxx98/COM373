
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;


public class Transaction 
{
    private int date;
    private String category;
    private String recipient;
    private double moneySpent;
    private static int totalNum = 0;
    
    public Transaction(int date, String category, String recipient, double moneySpent)throws ParseException
    {
        this.date = date;
        this.category = category;
        this.recipient = recipient;
        this.moneySpent = moneySpent;
        totalNum++;
        
    }
    public void printToFile() throws IOException
    {
        PrintWriter out = null;
        try
        { 
            out = new PrintWriter(new FileWriter("TransactionDetails.txt", true));
        } 
        catch (FileNotFoundException ex)
        { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        out.println(this.date + "   " + this.category + "   " + this.recipient + "  " + this.moneySpent);
        out.close();
    }
    
    
    /**
     *
     * @param args
     * @throws ParseException
     * @throws IOException
     */
    public static void main(String[] args) throws ParseException, IOException
    {
        
        //Scanner in = new Scanner(System.in);
        TransactionMenu t1 = new TransactionMenu();
        
        //t1.getFromFile();
        //t1.getdetails();
        //t1.addTransaction();
        //t1.printToFile();
        //t1.addTransaction(in);
        //t1.printToFile();
        //t1.getFromFile();
        //t1.getdetails();
        //t1.getdetails();
        //System.out.println(totalNum);
        //t1.reportTotalSpent();
        
        //t1.reportGetrecordsRecipient(in);
        //System.out.println(t1.sum());
        t1.mainMenu();
        
    }
    
}
