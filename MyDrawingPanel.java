import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

public class MyDrawingPanel extends JPanel
{
    JPanel leftPanel;
    JLabel upBal;
    JLabel transList;
    JLabel errors;
    JTextField upBalance;
    JTextField trans;
    JTextField error;
    
    public MyDrawingPanel()
    {
    setLayout(new BorderLayout());
    //this.add(getHeader(), BorderLayout.PAGE_START);
    this.add(getLeft(), BorderLayout.LINE_START);
    //this.add(getCenter(), BorderLayout.CENTER);
    //this.add(getRight(), BorderLayout.LINE_END);
    }
    
    protected JComponent getLeft()
    {
    
    leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    
    upBal = new JLabel("Updated Account Balance");
    upBalance = new JTextField(15);
    upBalance.setMaximumSize(upBalance.getPreferredSize());
    leftPanel.add(upBal);
    leftPanel.add(upBalance);
    
    transList = new JLabel("List of Transactions");
    trans = new JTextField(15);
    trans.setMaximumSize(trans.getPreferredSize());
    leftPanel.add(transList);
    leftPanel.add(trans);
    
    errors = new JLabel("Error Messages Produced");
    error = new JTextField(15);
    error.setMaximumSize(error.getPreferredSize());
    leftPanel.add(errors);
    leftPanel.add(error);
     
    return leftPanel;
    }
}
