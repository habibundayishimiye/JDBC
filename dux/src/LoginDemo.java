
package SwingApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginDemo extends JFrame implements ActionListener {
    JLabel L1, L2, L3, L4;
    JTextField T;
    JPasswordField P;
    JButton B1, B2, B3;
    JFrame F1, F2;
    public LoginDemo(){
        F1 = new JFrame("::Login Form::");
        F2 = new JFrame("Welcome Message");
        L1 = new JLabel("Username");
        L2 = new JLabel("Password");
        L3 = new JLabel("Label 3");
        L4 = new JLabel("Label 4");
        T = new JTextField(15);
        P = new JPasswordField(15);
        B1 = new JButton("Login");
        B2 = new JButton("Reset");
        B3 = new JButton("Close");
        L1.setBounds(75, 15, 175, 25);
        L2.setBounds(75, 50, 175, 25);
        L3.setBounds(100, 150, 100, 25);
        T.setBounds(205, 15, 150, 25);
        P.setBounds(205, 50, 150, 25);
        B1.setBounds(75, 100, 100, 25);
        B2.setBounds(205, 100, 100, 25);
        F1.add(L1); F1.add(T); F1.add(L2);
        F1.add(P);F1.add(B1);F1.add(B2);
        F1.add(L3);
        F1.setSize(600, 400);
        F2.setSize(400, 200);
        F1.setVisible(true);
        F1.setLayout(null);
        F1.setResizable(false);
        F2.add(L4);
        F2.add(B3);
        F2.setLayout(new FlowLayout());
        F2.setVisible(false);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == B1) {
            String user = T.getText();
            String password = P.getText();
            if (user.equals("Habibu") && password.equals("522")) {
                L4.setText("Welcome "+user);
                F2.setVisible(true);
                F1.setVisible(false);
            }
            else{
                L3.setText("Wrong Username or password !");
            }
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/cs2";
            String username="root";
            String pass="";
            try{
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,username,pass);
                if(con!=null) {
                    Statement st=con.createStatement();
                    String query="create table if not exists duxx(id int not null primary key auto_increment,name text,password varchar(15))";
                    st.executeUpdate(query);
//                    String insert="insert into duxx(name,password) values('Kim','kim01')";
                    String delete="delete from users where id = 2";
//                    st.executeUpdate(insert);
                    st.executeUpdate(delete);
                    ResultSet rs=st.executeQuery("select * from duxx");
                    while(rs.next()){
                        System.out.println(rs.getString("name")+" "+rs.getString("password"));
                    }
                }
                else {
                    System.out.println("Connection failed!");
                }
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ev.getActionCommand().equals("Reset")) {
            T.setText("");
            P.setText("");
            L3.setText("");
        }
        else {
            System.exit(0);
        }
    }
    public static void main(String args[]) {
        LoginDemo log = new LoginDemo();
    }
}

