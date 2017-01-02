import javax.swing.*;
import java.awt.*;//NEW STUFF!
import java.awt.event.*;

public class TempConverter extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;
    private JTextField t2;


    public static String CtoF(double t){
	return (t * 9) / 5 + 32 + "";
    }

    public static String FtoC(double t){
	return (t - 32) * 5 / 9 + "";
    }

    
   public TempConverter() {
    this.setTitle("My first GUI");
    this.setSize(350,300);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();

       pane.setLayout(new BorderLayout());

      JButton b = new JButton("Celsius to Farenheit");
      b.addActionListener(this);
      b.setActionCommand("CtoF");
      JButton b2 = new JButton("Farenheit to Celsius");
      b2.addActionListener(this);
      b2.setActionCommand("FtoC");
      t = new JTextField(10);
      t2 = new JTextField(10);
     pane.add(t, BorderLayout.PAGE_START);
     pane.add(b, BorderLayout.LINE_START);
     pane.add(b2, BorderLayout.LINE_END);
     pane.add(t2, BorderLayout.PAGE_END);
  }

  public void actionPerformed(ActionEvent e){
   String event = e.getActionCommand();
   if(event.equals("CtoF")){
       double s = Double.parseDouble(t.getText());
       t2.setText(CtoF(s));
   }
   if(event.equals("FtoC")){
       double s = Double.parseDouble(t.getText());
       t2.setText(FtoC(s));
   }
  }

    
    public static void main(String[] args) {
     TempConverter g = new TempConverter();
     g.setVisible(true);
  }
}



