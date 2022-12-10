package mockJDBC;

import java.util.ResourceBundle;

/**
 * For Java Programmer, we do not care about which DB we use, we care about the interface
 */

public class JavaProgrammer {

    public static void main(String[] args) {

        // It depends on which one we new object: Oracle or MySQL
//        JDBC jdbc = new Oracle();
        JDBC jdbc = new MySQL();

        jdbc.getConnection();

        // we could use reflection,
        // use ResourceBundle to get resource
        // use ResourceBundle getString method to get properties from file
        ResourceBundle bundle = ResourceBundle.getBundle("mockJDBC/JDBC");
        String driverName = bundle.getString("db");

        // use reflection to create
        // We just need to modify JDBC.properties file in the future
        Class dbDriver = null;
        try {
            dbDriver = Class.forName(driverName);
            JDBC jdbc1 = (JDBC)dbDriver.newInstance();

            jdbc1.getConnection();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

}
