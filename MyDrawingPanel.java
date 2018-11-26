import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

public class MyDrawingPanel extends JPanel
{
    JPanel leftPanel;
    JPanel centerPanel;
    JPanel rightPanel;
    JLabel upBal;
    JLabel transList;
    JLabel errors;
    public static JTextField upBalance;
    public static JTextArea trans;
    public static JScrollPane scrollPane;
    JTextArea error;
    
    public static Savings s1;
    
    public MyDrawingPanel()
    {
    setLayout(new BorderLayout());
    //this.add(getHeader(), BorderLayout.PAGE_START);
    this.add(getLeft(), BorderLayout.LINE_START);
    //this.add(getCenter(), BorderLayout.CENTER);
    //this.add(getRight(), BorderLayout.LINE_END);
    this.setBackground(Color.YELLOW);
    }
    
    protected JComponent getLeft()
    {
    
    leftPanel = new JPanel();
    //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    
    upBal = new JLabel("Updated Account Balance");
    upBalance = new JTextField(10);
    upBalance.setMaximumSize(upBalance.getPreferredSize());
    leftPanel.add(upBal);
    leftPanel.add(upBalance);
    
    transList = new JLabel("List of Transactions");
    trans = new JTextArea(10,30);
    trans.setLineWrap(true);
    trans.setWrapStyleWord(true);
    scrollPane = new JScrollPane(trans);
    leftPanel.add(transList);
    leftPanel.add(scrollPane);
    
    errors = new JLabel("Error Messages Produced");
    error = new JTextArea(10,30);
    error.setLineWrap(true);
    error.setWrapStyleWord(true);
    JScrollPane scrollPane2 = new JScrollPane(error);
    leftPanel.add(errors);
    leftPanel.add(scrollPane2);
    
    leftPanel.setBackground(Color.YELLOW);
    return leftPanel;
    }
    
    /*protected JComponent getCenter()
    {
        centerPanel = new JPanel();
        leftPanel.setBackground(Color.YELLOW);
        return centerPanel;
    }
    
    protected JComponent getRight()
    {
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.YELLOW);
        return rightPanel;
    }*/
    
}
