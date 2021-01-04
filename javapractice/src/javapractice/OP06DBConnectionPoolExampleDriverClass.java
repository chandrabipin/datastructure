package javapractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OP06DBConnectionPoolExampleDriverClass {
    public static void main(String... arg) throws SQLException, ClassNotFoundException, InterruptedException {
    	 
    	//int initPoolSize, int maxPoolSize, String dbURL, String dbUserName,String dbPassword, String dbDriverClassName, boolean waitIfBusy
        OP06DBConnectionPoolExample OP06DBConnectionPoolExample = new OP06DBConnectionPoolExample(
        		5,
        		10,
                "jdbc:oracle:thin:@localhost:1521:orcl", 
                "bipin", 
                "password",
                "oracle.jdbc.driver.OracleDriver",
                true);

        Connection con = OP06DBConnectionPoolExample.getConnection();
        System.out.println("We have got connection from OP06DBConnectionPoolExample class");
        
        PreparedStatement prepStmt = con
                     .prepareStatement("select ID, NAME from EMPLOYEE");
        
        ResultSet rs = prepStmt.executeQuery();
        while (rs.next()) {
               System.out.print(rs.getInt("ID") + " ");
               System.out.println(rs.getString("NAME"));
        }

        if (rs != null)
               rs.close(); // close resultSet
        if (prepStmt != null)
               prepStmt.close(); // close PreparedStatement

        OP06DBConnectionPoolExample.freeConnection(con);
        System.out.println("We have free/released connection to OP06DBConnectionPoolExample class");
 }}
