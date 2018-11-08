import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
public class MyFrame extends JFrame {
    
    public MyFrame(){
       
       
        
        MyControlPanel myPane = new MyControlPanel();
        this.add(myPane);
        myPane.setLayout(null);
    }
    
}

