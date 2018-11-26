
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Timers extends MyControlPanel
{
    
    double a;
    int month = 11;
    int year = 2018;
    int secondsPassed = 0;
    Timer currTimer = new Timer();
    Timer saveTimer = new Timer();
    public Current[]currTrans;
    ArrayList<Object> listOfObjects = new ArrayList<Object>();
    
    
    TimerTask currTask = new TimerTask() 
    {
        public void run()
        {
            if(secondsPassed != 0 && secondsPassed % 5 == 0)
            {
                Current[]currTrans = null;
                int size = 0;
                month++;

                if(month > 12)
                {
                    year++;
                    month=1;
                }
                if(this.decideTransType() % 2 == 0)
                {
                System.out.println("Even");
                double add = this.decideRandomAmount();
                System.out.println(add);
                
                c1.balance = c1.balance + add;
                System.out.println(c1.balance);
                //a = c1.balance;

                    try {
                        currTrans[size] = new Current(c1.balance, "", 0);
                    } catch (ParseException ex) {
                        Logger.getLogger(Timers.class.getName()).log(Level.SEVERE, null, ex);
                    }
               size++;
               for (int i=0; i<currTrans.length ; i++)
                {
                    System.out.println(currTrans[i]);
                }
                }else
                {
                System.out.println("Odd");
                double minus = this.decideRandomAmount();
                System.out.println(minus);
                c1.balance = c1.balance - minus;
                System.out.println(c1.balance);
                
                }
                
                
                
                
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
            if(secondsPassed != 0 && secondsPassed % 5 == 0)
            {
                month++;

                if(month > 12)
                {
                    year++;
                    month=1;
                }
                if(this.decideTransType() % 2 == 0)
                {
                System.out.println("Even");
                double add = this.decideRandomAmount();
                System.out.println(add);
                
                s1.balance = s1.balance + add;
                System.out.println(s1.balance);
                }else
                {
                System.out.println("Odd");
                double minus = this.decideRandomAmount();
                System.out.println(minus);
                s1.balance = s1.balance - minus;
                System.out.println(s1.balance);
                }
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
