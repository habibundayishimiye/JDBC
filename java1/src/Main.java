package SwingApp;
import java.sql.*;
 class JDBCDemo{
    public static void main(String args[]){
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/cs2";
        String username="root";
        String pass="";
        try{
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,username,pass);
            if(con!=null) {
                Statement st=con.createStatement();
                String query="create table if not exists contact(id int not null primary key auto_increment,name text,username text,password varchar(15),email text)";
                st.executeUpdate(query);
                String insert="insert into contact(name,username,password,email) values('kamikazi','kamikazi01','kamikazi12345','kamikazi@ur.ac.rw')";
                String delete="delete from contact where id = 3";
                st.executeUpdate(insert);
                st.executeUpdate(delete);
                ResultSet rs=st.executeQuery("select * from contact");
                while(rs.next()){
                    System.out.println(rs.getString("name")+" "+rs.getString("email"));
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
}