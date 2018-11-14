import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

public class MyControlPanel extends JPanel
{
    
    public MyControlPanel()
    {
    
    
    JTextField tf1= new JTextField(10);
    JTextField tf2 = new JTextField(10);
    JTextField tf3 = new JTextField(10);
    JLabel label1 = new JLabel("Updated Account Balance");
    JLabel label2 = new JLabel("List of Transactions");
    JLabel label3 = new JLabel("Error Messages Produced");
    JButton b1 = new JButton("Generate report");
    
    Dimension size = label1.getPreferredSize();
   
    label1.setBounds(50, 100,size.width, size.height);
    tf1.setBounds(300, 100, size.width,size.height);
   
    label2.setBounds(50, 150, size.width, size.height);
    tf2.setBounds(300, 150, size.width,size.height);
   
    label3.setBounds(50, 200, 150, size.height);
    tf3.setBounds(300, 200, size.width,size.height);
   
    b1.setBounds(50, 300, size.width,size.height);

   
    this.add(label1) ;
    this.add(label2) ;
    this.add(label3);
    this.add(tf1);
    this.add(tf2);
    this.add(tf3);
    this.add(b1);
    
}
    
}
