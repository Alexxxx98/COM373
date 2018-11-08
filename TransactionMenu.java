
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class TransactionMenu 
{
    
    public void mainMenu() throws ParseException, IOException
    {
        Scanner getMenu = new Scanner(System.in);
        
        
        TransactionDetails t1 = new TransactionDetails();
        t1.getFromFile();
        
        
        System.out.println("Transaction Menu");
        System.out.println("Type 'Add' to create a transaction log");
        System.out.println("Type 'Report' to access the report menu");
        System.out.println("Type 'Exit' to close the program");
        
        
        switch (getMenu.next()) {
            case "Add":
                System.out.println("");
                t1.addTransaction();
                System.out.println("");
                
                this.returnToMainMenu();
            case "Report":
                System.out.println("");
                this.reportMenu();
            case "Exit":
                System.out.println("");
                System.exit(0);
            default:
                System.out.println("Please enter a valid option\n");
                this.mainMenu();
        }
    }
    public void reportMenu() throws ParseException, IOException
    {
        
        Scanner getReport = new Scanner(System.in);
        TransactionDetails t1 = new TransactionDetails();
        
        System.out.println("Report Menu");
        System.out.println("Type 'TS' for a report on the total spent between two dates");
        System.out.println("Type 'TSC' for a report for the total spent on a particul category between two dates");
        System.out.println("Type 'LA' to list all transactions between two dates");
        System.out.println("Type 'LAR' to list all transactions for a particular recipient between two dates");
        System.out.println("Type 'Return' to go back to the main menu");
        
        
        switch (getReport.next()) {
            case "TS":
                System.out.println("");
                t1.reportTotalSpent();
                this.returnToReportMenu();
            case "TSC":
                System.out.println("");
                t1.reportTotalSpentCat();
                this.returnToReportMenu();
            case "LA":
                System.out.println("");
                t1.reportGetrecords();
                this.returnToReportMenu();
            case "LAR":
                System.out.println("");
                t1.reportGetRecordsRecipient();
                this.returnToReportMenu();
            case "Return":
                System.out.println("");
                this.mainMenu();
                
            default:
                System.out.println("Please enter a valid option\n");
                this.reportMenu();
        }
        
    }
    
    public void returnToReportMenu() throws ParseException, IOException
    {
        Scanner getReply = new Scanner(System.in);
        
        System.out.println("Return to Report Menu?");
        System.out.println("Type 'Y' to do so or 'N' to close the program");
        
        if("Y".equals(getReply.next()))
        {
            this.reportMenu();
        }else if("N".equals(getReply.next()))
        {
            System.exit(0);
        }
        
    }
    
    public void returnToMainMenu() throws ParseException, IOException
    {
        Scanner getReply = new Scanner(System.in);
        
        System.out.println("Return to Main Menu?");
        System.out.println("Type 'Y' to do so or 'N' to close the program");
        
        if("Y".equals(getReply.next()))
        {
            this.mainMenu();
        }else if("N".equals(getReply.next()))
        {
            System.exit(0);
        }
        
    }
    
}
