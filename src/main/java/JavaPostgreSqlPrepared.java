/**
 * Created by saharzargarzadeh on 1/27/18.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSqlPrepared {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/App_Store_DB";
        String user = "postgres";
        String password = "123";

        String co_id = "1";
        String name = "bazaar";
        String address = "borje negar, TEhran, Iran";
        String field = "mobile app development";

        String query = "INSERT INTO Company(co_id, name, address, field_of_work) VALUES(?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, co_id);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, field);
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}