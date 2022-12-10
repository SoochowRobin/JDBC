package JDBC02;

import DButil.DButil;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * This file demo the pipeline to use JDBC to connect DB and query, update data in DB
 * There are 6 steps to use JDBC:
 * 1. register DB driver (MySQL or Oracle?)
 * 2. get connection
 * 3. get object to execute sql
 * 4. execute sql(PreparedStatement or Statement?)
 * 5. handle with sql results(Query: ResultSet, Update/Delete/Insert: int count)
 * 6. close resources
 * JDBC index all starts from 1
 *
 * All properties are store in property files
 */

public class JDBC {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preStatement = null;


        // use bundle to get info in properties file
        ResourceBundle bundle = ResourceBundle.getBundle("JDBC02/JDBCInfo");
        String DBDriver = bundle.getString("DBDriver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        try {
            // step 1: use reflection to register driver: because code has been in static code
            Class.forName(DBDriver);

            // step 2: get connection
            connection = DriverManager.getConnection(url, user, password);

            // step 3: create statement
            statement = connection.createStatement();

            // step 4: executeQuery, executeUpdate
            String sql = "SELECT * FROM EMP";

            // step 5: handle sql results
            System.out.println("Here is the demo for Query: ");
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                // JDBC index all start from 1
                String no = resultSet.getString(1);
                String name = resultSet.getString(2);
                // end for here: just for demo
                System.out.println("No: " + no + " Name: " + name);
            }

            System.out.println("Demo for using prepared statement");
            // here use preparedStatement
            String sqlQuery = "select * from emp where job = ?";
            // compile sql first
            preStatement = connection.prepareStatement(sqlQuery);
            // set String value for ?
            preStatement.setString(1, "SALEsMAN");
            // executeQuery
            resultSet = preStatement.executeQuery();
            while(resultSet.next()){
                // JDBC index all start from 1
                String no = resultSet.getString(1);
                String name = resultSet.getString(2);
                // end for here: just for demo
                System.out.println("No: " + no + " Name: " + name);
            }



            // here is the demo for insert
            System.out.println("Here is the demo for insertion: ");
            String insertionSQL = "insert into dept values(50, 'CS', 'SpringFiled')";
            int changed = statement.executeUpdate(insertionSQL);
            if(changed == 1){
                System.out.println("insertion succeed! ");
            }else{
                System.out.println("insertion failed!");
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //step 6: close all resources
            /*if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }*/

            // use DButil
            DButil.close(resultSet, statement, connection);
        }






    }
}
