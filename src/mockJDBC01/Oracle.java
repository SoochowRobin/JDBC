package mockJDBC01;

/**
 * Oracle company will implement JDBC interface: Oracle driver
 */

public class Oracle implements JDBC{
    @Override
    public void getConnection() {
        System.out.println("Oracle has implemented JDBC interface!");
    }
}
