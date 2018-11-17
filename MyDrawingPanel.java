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
    JTextArea trans;
    JTextArea error;
    
    public MyDrawingPanel()
    {
    setLayout(new BorderLayout());
    //this.add(getHeader(), BorderLayout.PAGE_START);
    //this.add(getLeft(), BorderLayout.LINE_START);
    this.add(getCenter(), BorderLayout.CENTER);
    //this.add(getRight(), BorderLayout.LINE_END);
    }
    
    protected JComponent getCenter()
    {
    
    leftPanel = new JPanel();
    //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    
    upBal = new JLabel("Updated Account Balance");
    upBalance = new JTextField(10);
    upBalance.setMaximumSize(upBalance.getPreferredSize());
    leftPanel.add(upBal);
    leftPanel.add(upBalance);
    
    transList = new JLabel("List of Transactions");
    trans = new JTextArea(10,15);
    trans.setLineWrap(true);
    trans.setWrapStyleWord(true);
    JScrollPane scrollPane = new JScrollPane(trans);
    leftPanel.add(transList);
    leftPanel.add(scrollPane);
    
    errors = new JLabel("Error Messages Produced");
    error = new JTextArea(10,15);
    error.setLineWrap(true);
    error.setWrapStyleWord(true);
    JScrollPane scrollPane2 = new JScrollPane(error);
    leftPanel.add(errors);
    leftPanel.add(scrollPane2);
    
    leftPanel.setBackground(Color.YELLOW);
    return leftPanel;
    }
}
