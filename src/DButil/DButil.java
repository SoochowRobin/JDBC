package DButil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ecapsulate the DB util: common use methods like close(), getConnection()
 */
public class DButil {

    // util method use private constructor
    private DButil(){}


    public static void close(ResultSet rs, Statement st, Connection c){

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(c != null){
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
