import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
public class MySQLAccess
{
      private Connection connect = null;
      private Statement statement = null;
      private PreparedStatement preparedStatement = null;
      private ResultSet resultSet = null;
      public void readDataBase() throws Exception
      {
            try
            {
                  // This will load the MySQL driver, each DB has its own driver
                  Class.forName("com.mysql.jdbc.Driver");
                  // Setup the connection with the DB
                  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6q2","root","UICZVT");
                  Statement stmt = connect.createStatement();  
                  ResultSet rs = stmt.executeQuery("select * from Department");  
                  while(rs.next())  
                        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                  connect.close();
            }
            catch(Exception e)
            {
                  System.out.println(e);
            }
      }
}