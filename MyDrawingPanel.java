import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.text.SimpleDateFormat;

public class MyDrawingPanel extends JPanel
{
private Timer timer;
    
    public MyDrawingPanel()
    {
    JTextField deposit = new JTextField(10);
    JTextField withdraw = new JTextField(10);
    JButton button1 = new JButton("Deposit");
    JButton button2 = new JButton("Withdraw");
    JTextField balance = new JTextField(10);
    JLabel lbltime = new JLabel();


    JButton simulate = new JButton("Start Simulation");
    this.add(simulate);
    simulate.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Timer timer = new Timer(1000, new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lbltime.setText(sdf.format(new java.util.Date()));
                }
            });
            timer.start();          
        }
    });



    JButton stopSim = new JButton("Stop Simulation");
    this.add(stopSim);
    stopSim.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*MyFrame frame = new MyFrame();
            frame.setVisible(true);
            frame.setSize(600,400);*/
        Timer timer = new Timer(1000, new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lbltime.setText(sdf.format(new java.util.Date()));
                }
            });
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        timer.stop();   
        lbltime.setText(sdf.format(new java.util.Date()));
        }
    });

    JButton showBal = new JButton("Balance");

    Dimension size = deposit.getPreferredSize();

    stopSim.setBounds(50,140,175,size.height);
    simulate.setBounds(50,100, 175,size.height);
    lbltime.setBounds(200,150,175, size.height);
    deposit.setBounds(50, 20, size.width, size.height);
    button1.setBounds(200, 20, size.width, size.height);

    withdraw.setBounds(50, 50, size.width, size.height);
    button2.setBounds(200, 50, size.width, size.height);

    showBal.setBounds(350, 20, size.width,size.height);
    balance.setBounds(350, 50, size.width, size.height);

    this.add(showBal);
    this.add(balance);
    this.add(deposit);
    this.add(withdraw);
    this.add(button1) ;
    this.add(button2) ;
    this.add(lbltime);
    }  
}
