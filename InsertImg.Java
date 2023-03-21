

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {

    public static void main(String[] args){

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproject","userid","password");

            String file = System.getProperty("user.dir");
            file = file+"\\src\\teddy.jpg";

            PreparedStatement preparedStatement = con.prepareStatement("insert into imgtable values(?,?)");
            FileInputStream fin = new FileInputStream(file);
            preparedStatement.setString(1,"Teddy1");
            preparedStatement.setBinaryStream(2,fin,fin.available());
            int i = preparedStatement.executeUpdate();
            System.out.println(i +" Image is Stored");
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
