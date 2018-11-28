
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class Timers extends MyControlPanel
{
    
    double a;
    double minus;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    int size = 0;
    String strDateMonth;
    String strDateYear;
    String strDate;
    int month = 11;
    int year = 2018;
    int secondsPassed = 0;
    Timer currTimer = new Timer();
    Timer saveTimer = new Timer();
     Accounts[]currTrans = new Accounts[100];
    private Accounts[]saveTrans = new Accounts[100];
    //private int[] balances = new int[100];
    public static double[] balances = new double[10];
    
    
    
    TimerTask currTask = new TimerTask() 
    {
        public void run()
        {
            if(secondsPassed != 0 && secondsPassed % 3 == 0) 
            {
                
                
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
                balances[size] = c1.balance;
                currTrans[size] = new Accounts(c1.balance, add, strDate, 0);
                String formatBalance = formatter.format(currTrans[size].balance);
                String formatChange = formatter.format(currTrans[size].balChange);
                //System.out.println(currTrans[size].balance + " +" + currTrans[size].balChange + " " + currTrans[size].date);
                MyDrawingPanel.trans.append("Balance: " + formatBalance + "   Change: +" + formatChange + "    Date: " + currTrans[size].date + "\r\n");
             
                size++;
                //System.out.println(Arrays.toString(balances));
                
                }else   
                {
                System.out.println("Odd");
                minus = this.decideRandomAmount();
                System.out.println(minus);
                
                try
                {
                    this.accBal();
                    
                }catch(Errors.OverdraftException n)
                    {
                       MyDrawingPanel.error.append(n.getMessage());    
                    }
                }
                String curBal = formatter.format(c1.balance);
                MyDrawingPanel.upBalance.setText(curBal);
                //System.out.println(Arrays.toString(balances));
                
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
                private void accBal()throws Errors.OverdraftException
                {
                    a = c1.balance - minus;
                    if(a >= -1000)
                    {
                    c1.balance = c1.balance - minus;
                    System.out.println(c1.balance);
                    balances[size] = c1.balance;
                    currTrans[size] = new Accounts(c1.balance, minus, strDate, 0);
                    String formatBalance = formatter.format(currTrans[size].balance);
                    String formatChange = formatter.format(currTrans[size].balChange);
                    MyDrawingPanel.trans.append("Balance: " + formatBalance + " Change: -" + formatChange + " Date: " + currTrans[size].date + "\r\n");
                    size++;
                    }else
                    {
                        throw new Errors.OverdraftException();
                    }
                }
                public void insertionSort1(double[] balances)
                {
                int i, slot, size1;
                double current;
                size1 = balances.length ;
                    for(i=1; i < size1; i++)
                    {
                    current = balances[i];
                    slot = i; // Starts with 1st element
                        while((slot > 0)&&(balances[slot-1] > current))
                        {
                        balances[slot] = balances[slot-1] ;
                        slot--;
                        }
                    balances[slot] = current;
                    }
                    System.out.println(Arrays.toString(balances));
                }
                public void insertionSort(Accounts[] currTrans)
                {
                int i, slot, size1;
                double current;
                size1 = currTrans.length ;
                    for(i=1; i < size1; i++)
                    {
                    current = currTrans[i].balance;
                    slot = i; // Starts with 1st element
                        while((slot > 0)&&(currTrans[slot-1].balance > current))
                        {
                        currTrans[slot].balance = currTrans[slot-1].balance ;
                        slot--;
                        }
                    currTrans[slot].balance = current;
                    }
                    System.out.println(Arrays.toString(currTrans));
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
                    s1.numWithdrawals = 0;
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
                    
                    System.out.println("Odd");
                    minus = this.decideRandomAmount();
                    System.out.println(minus);
                    try
                    {
                        this.numWithdrawals();

                    }catch(Errors.NumOfWithdrawalsException n)
                    {
                    MyDrawingPanel.error.append(n.getMessage());    
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
                private void invalidBal() throws Errors.BalanceValueException
                {
                    try
                    {
                        a = s1.balance - minus;
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
                        throw new Errors.BalanceValueException();
                        }
                    }catch(Errors.BalanceValueException n)
                    {
                        MyDrawingPanel.error.append(n.getMessage());
                    }
                }
                private void numWithdrawals() throws Errors.NumOfWithdrawalsException
                {
                    if(s1.numWithdrawals < 2)
                    {
                        this.invalidBal();
                    }else
                    {
                        throw new Errors.NumOfWithdrawalsException();
                    }
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
    public boolean sequentialSearch(Comparable [] searchSave, Accounts target)
                {
                boolean found = false;
                int i = 0 ;
                while (!found && i < 20)
                {
                if (searchSave[i].compareTo(target) == 0)
                {
                found = true ;
                }
                i++ ;
                }
                return found ;
                }
                public void insertionSort(Accounts[] currTrans)
                {
                int i, slot, size1;
                double current;
                size1 = currTrans.length ;
                    for(i=1; i < size1; i++)
                    {
                    current = currTrans[i].balance;
                    slot = i; // Starts with 1st element
                        while((slot > 0)&&(currTrans[slot-1].balance > current))
                        {
                        currTrans[slot].balance = currTrans[slot-1].balance ;
                        slot--;
                        }
                    currTrans[slot].balance = current;
                    }
                    System.out.println(Arrays.toString(currTrans));
                    max.setText(Arrays.toString(currTrans));
                }
}
