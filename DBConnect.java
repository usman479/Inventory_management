
package MainFiles;

import java.sql.*;

public class DBConnect {


    static public void truncateBill(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "root");
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("TRUNCATE bill");
            stmt.executeUpdate("TRUNCATE cart");
        } catch (Exception e){

        }

    }
    static Connection ConnectDb() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "root");
    }

}
