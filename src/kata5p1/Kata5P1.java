package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        String UrlConnection ="jdbc:sqlite:KATA5.DB";
        Connection connection = DriverManager.getConnection(UrlConnection);
        
        Statement st = connection.createStatement();
        
        BufferedReader reader = new BufferedReader(new FileReader(new File ("emails.txt")));
        String mail = "";
        String query = "";
        
        while ((mail=reader.readLine()) !=null) {
            if(!mail.contains("@")) continue;
                query ="INSERT INTO MAIL (mail) VALUES ('" + mail + "')";
                 st.executeUpdate(query);
        }
        
    }
    
}
