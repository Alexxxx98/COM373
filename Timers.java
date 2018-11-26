
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Timers extends MyControlPanel
{
    
    double a;
    String strDateMonth;
    String strDateYear;
    String strDate;
    int month = 11;
    int year = 2018;
    int secondsPassed = 0;
    Timer currTimer = new Timer();
    Timer saveTimer = new Timer();
    private Accounts[]currTrans = new Accounts[10];
    private Accounts[]saveTrans = new Accounts[10];
    
    
    
    TimerTask currTask = new TimerTask() 
    {
        public void run()
        {
            if(secondsPassed != 0 && secondsPassed % 3 == 0)
            {
                int size = 0;
                month++;
                
                if(month > 12)
                {
                year++;
                month=1;
                }
                
                strDateMonth = Integer.toString(month);
                strDateYear = Integer.toString(year);
                strDate = strDateMonth + " / "  +  strDateYear;
                
                if(this.decideTransType() % 2 == 0)
                {
                System.out.println("Even");
                double add = this.decideRandomAmount();
                System.out.println(add);
                    if(add > 500)
                    {
                    c1.balance = c1.balance + add + 10.0;
                    }else
                    {
                    c1.balance = c1.balance + add;
                    }
                System.out.println(c1.balance);
                currTrans[size] = new Accounts(c1.balance, add, strDate, 0);
                //System.out.println(currTrans[size].balance + " +" + currTrans[size].balChange + " " + currTrans[size].date);
                MyDrawingPanel.trans.append("Balance: " + currTrans[size].balance + "   Change: +" + currTrans[size].balChange + "    Date: " + currTrans[size].date + "\r\n");
                size++;
                }else   
                {
                System.out.println("Odd");
                double minus = this.decideRandomAmount();
                System.out.println(minus);
                double a = c1.balance - minus;
                    if(a >= -1000)
                    {
                    c1.balance = c1.balance - minus;
                    System.out.println(c1.balance);
                    currTrans[size] = new Accounts(c1.balance, minus, strDate, 0);
                    MyDrawingPanel.trans.append("Balance: " + currTrans[size].balance + " Change: -" + currTrans[size].balChange + " Date: " + currTrans[size].date + "\r\n");
                    size++;
                    }else
                    {
                    JOptionPane.showMessageDialog(new JFrame(), "Error");    
                    }
                }
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    String curBal = formatter.format(c1.balance);
                MyDrawingPanel.upBalance.setText(curBal);
            }
            secondsPassed++;
            System.out.println("months : " + month); 
            System.out.println("year : " + year); 
            System.out.println("");  
        }  
        private double decideTransType() 
                {
                Random currSave = new Random();
                int tranMeth = currSave.nextInt(101);
                double d = (double)tranMeth;
                return d;
                }
        
                private double decideRandomAmount()
                {
                Random randAmount = new Random();
                double intAmount = randAmount.nextInt(1001);
                return intAmount;
                }      
    };

    TimerTask saveTask = new TimerTask()
    {
        public void run()
        {
            if(secondsPassed != 0 && secondsPassed % 3 == 0)
            {
                int size = 0;
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                month++;

                if(month > 12)
                {
                    year++;
                    month=1;
                }
                strDateMonth = Integer.toString(month);
                strDateYear = Integer.toString(year);
                strDate = strDateMonth + " "  +  strDateYear;
                if(this.decideTransType() % 2 == 0)
                {
                System.out.println("Even");
                double add = this.decideRandomAmount();
                System.out.println(add);
                s1.balance = s1.balance * 1.03;
                s1.balance = s1.balance + add;
                System.out.println(s1.balance);
                saveTrans[size] = new Accounts(s1.balance, add, strDate, 0);
                String formatBalance = formatter.format(saveTrans[size].balance);
                String formatChange = formatter.format(saveTrans[size].balChange);
                MyDrawingPanel.trans.append("Balance: " + formatBalance + "   Change: +" + formatChange + "    Date: " + saveTrans[size].date + "\r\n");
                size++;
                }else
                {
                    if(s1.numWithdrawals < 2)
                    {
                    System.out.println("Odd");
                    double minus = this.decideRandomAmount();
                    System.out.println(minus);
                    double a = s1.balance - minus;
                        if(a >= 100)
                        {
                        s1.balance = s1.balance * 1.03;
                        s1.balance = s1.balance - minus;
                        System.out.println(s1.balance);
                        saveTrans[size] = new Accounts(s1.balance, minus, strDate, s1.numWithdrawals);
                        String formatBalance = formatter.format(saveTrans[size].balance);
                        String formatChange = formatter.format(saveTrans[size].balChange);
                        MyDrawingPanel.trans.append("Balance: " + formatBalance + " Change: -" + formatChange + " Date: " + saveTrans[size].date + "\r\n");
                        s1.numWithdrawals ++;
                        size++;
                        }else
                        {
                        JOptionPane.showMessageDialog(new JFrame(), "Error");
                        }
                    }
                }
                
                String curBal = formatter.format(s1.balance);
                MyDrawingPanel.upBalance.setText(curBal);
            }
            secondsPassed++;
            System.out.println("months : " + month); 
            System.out.println("year : " + year); 
            System.out.println("");
            
        }
        private double decideTransType() 
                {
                Random currSave = new Random();
                int tranMeth = currSave.nextInt(101);
                double d = (double)tranMeth;
                return d;
                }
        
                private double decideRandomAmount()
                {
                Random randAmount = new Random();
                double intAmount = randAmount.nextInt(1001);
                return intAmount;
                }
    };
    
    public void currStart()
    {
        currTimer.scheduleAtFixedRate(currTask, 1000, 1000);
    }
    public void currEnd()
    {
        currTimer.cancel();
    }
    public void saveStart()
    {
        saveTimer.scheduleAtFixedRate(saveTask, 1000, 1000);
    }
    public void saveEnd()
    {
        saveTimer.cancel();
    }
    
}
