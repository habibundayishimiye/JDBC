// package SwingApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class swingDemo extends JFrame implements ActionListener {
    JFrame f;
    JLabel L1, L2,L3;
    JTextField T1, T2;
    JButton B1, B2;
    public swingDemo(){
        f = new JFrame("simple Calculator");
        L1 = new JLabel("Type Number 1");
        L2 = new JLabel("Type Number 2");
        L3 = new JLabel("Result => ");
        T1 = new JTextField(10);
        T2 = new JTextField(10);
        B1 = new JButton("Add");
        B2 = new JButton("Reset");
        B1.addActionListener(this);
        B2.addActionListener(this);
        f.add(L1); f.add(T1);
        f.add(L2); f.add(T2);
        f.add(B1); f.add(B2);
        f.add(L3);
        f.setVisible(true);
        f.setSize(300, 200);
        f.setLayout(new GridLayout(4, 2));
    }
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource() == B1) {
            int a = Integer.parseInt(T1.getText());
            int b = Integer.parseInt(T2.getText());
            int c = a+b;
            L3.setText("Sum= "+c);
        }
        else{
            T1.setText("");
            T2.setText("");
            L3.setText("");
        }
    }
    public static void main(String args[]) {
        swingDemo sd = new swingDemo();
    }
}