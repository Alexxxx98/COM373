import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

public class MyFrame2 extends JFrame
{
    public MyFrame2() 
    {
    MyDrawingPanel myPane1 = new MyDrawingPanel();
    this.add(myPane1);
    myPane1.setLayout(null);
    }
}
