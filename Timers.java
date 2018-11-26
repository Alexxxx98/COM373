
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Timers extends MyControlPanel
{
    int month = 11;
    int year = 2018;
    int secondsPassed = 0;
    Timer currTimer = new Timer();

    Timer saveTimer = new Timer();
    
    TimerTask currTask = new TimerTask()
    {
        public void run()
        {
            if(secondsPassed != 0 && secondsPassed % 5 == 0)
            {
                month++;
                double a = 15;
                System.out.println(c1.balance);
                
                if(month > 12)
                {
                    year++;
                    month=1;
                }
                if(this.decideTransType() % 2 == 0)
                {
                System.out.println("Even");
                System.out.println(this.decideRandomAmount());
                this.depositSavings();
                }else
                {
                System.out.println("Odd");
                System.out.println(this.decideRandomAmount());
                this.withdrawSavings();
                }
            }
            secondsPassed++;
            System.out.println("months : " + month); 
            System.out.println("year : " + year); 
            System.out.println("");

        }
                private int decideTransType() 
                {
                Random currSave = new Random();
                int tranMeth = currSave.nextInt(101);
                return tranMeth;
                }
        
                private int decideRandomAmount()
                {
                Random randAmount = new Random();
                int intAmount = randAmount.nextInt(1001);
                return intAmount;
                }
                private void withdrawSavings()
                {
                    if(100 - this.decideRandomAmount() < 100)
                    {
                    System.out.println("error");
                    }else
                    {
                    System.out.println("withdraw successful");
                    }
                }
                private void depositSavings()
                {
                System.out.println("Deposit successful");
                }
    };

    TimerTask saveTask = new TimerTask()
    {
        public void run()
        {
            if(secondsPassed != 0 && secondsPassed % 5 == 0)
            {
                month++;
                double a = 15;
                c1.balance = c1.balance + a;
                System.out.println(c1.balance);
                if(month > 12)
                {
                    year++;
                    month=1;
                }
                if(this.decideTransType() % 2 == 0)
                {
                System.out.println("Even");
                System.out.println(this.decideRandomAmount());
                this.depositSavings();
                }else
                {
                System.out.println("Odd");
                System.out.println(this.decideRandomAmount());
                this.withdrawSavings();
                }
            }
            secondsPassed++;
            System.out.println("months : " + month); 
            System.out.println("year : " + year); 
            System.out.println("");

        }
                private int decideTransType() 
                {
                Random currSave = new Random();
                int tranMeth = currSave.nextInt(101);
                return tranMeth;
                }
        
                private int decideRandomAmount()
                {
                Random randAmount = new Random();
                int intAmount = randAmount.nextInt(1001);
                return intAmount;
                }
                private void withdrawSavings()
                {
                    if(100 - this.decideRandomAmount() < 100)
                    {
                    System.out.println("error");
                    }else
                    {
                    System.out.println("withdraw successful");
                    }
                }
                private void depositSavings()
                {
                System.out.println("Deposit successful");
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
