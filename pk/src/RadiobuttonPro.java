import javax.swing.*;
//import javax.swing.ButtonGroup;
import java.awt.*;
import java.awt.event.*;
 class RadiobuttonProg extends JApplet implements  ActionListener{
    JRadioButton rb1,rb2,rb3,rb4;
    JTextField L;
    JButton b;
    JFrame f;
    ButtonGroup bg;
    public RadiobuttonProg(){
        bg=new ButtonGroup();
        rb1=new JRadioButton("Java");
        rb2=new JRadioButton("Python");
        rb3=new JRadioButton("PHP");
        rb4=new JRadioButton("C++");
        L=new JTextField();L.setBackground(Color.red);
        b=new JButton("Display");
        f=new JFrame("Radio Button Program");
        bg.add(rb1);bg.add(rb2);bg.add(rb3);bg.add(rb4);

        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);
        b.addActionListener(this);
        f.add(L);f.add(rb1);f.add(rb2);f.add(rb3);f.add(rb4);f.add(b);
        f.setLayout(new GridLayout(6,1));
        f.setSize(300,400); f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Display")){
            if(rb1.isSelected()){
                L.setText("I like "+rb1.getText()+"Programming");
            }
            else if(rb2.isSelected()){
                L.setText(rb2.getText()+" is the best Language");
            }
            else if(rb3.isSelected()){
                L.setText(rb3.getText()+" is Good");
            }
            else{
                L.setText(rb4.getText()+" is a Basic Language");
            }
        }
    }
    public static void main(String args[]){
        RadiobuttonProg rbp=new RadiobuttonProg();
    }
}
