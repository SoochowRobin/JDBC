package mockJDBC;
/**
 * MySQL company will implement JDBC interface: MySQL driver
 */


public class MySQL implements JDBC {


    @Override
    public void getConnection() {
        System.out.println("MySQL has implemented the JDBC interface!");
    }
}
