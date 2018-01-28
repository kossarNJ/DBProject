import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class CallQueries {

    public String signUpUser(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel) {

        String query = "INSERT INTO Users(userEmail, fName, lName, postalCode, dateOfBirth, backupEmail, userPass,imageURL, tel) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, userEmail);
            pst.setString(2, fName);
            pst.setString(3, lName);
            pst.setString(4,  postalCode);
            pst.setString(5, dateOfBirth.toString());
            pst.setString(6, backupEmail);
            pst.setString(7, userPass);
            pst.setString(8, imageURL);
            pst.setString(9, tel);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    public String signUpDeveloper(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String resume) {
        String query1 = "INSERT INTO Users(userEmail, fName, lName, postalCode, dateOfBirth, backupEmail, userPass,imageURL, tel) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query1)) {

            pst.setString(1, userEmail);
            pst.setString(2, fName);
            pst.setString(3, lName);
            pst.setString(4,  postalCode);
            pst.setString(5, dateOfBirth.toString());
            pst.setString(6, backupEmail);
            pst.setString(7, userPass);
            pst.setString(8, imageURL);
            pst.setString(9, tel);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        String query2 = "INSERT INTO Developer_User(userEmail, resume) VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query2)) {

            pst.setString(1, userEmail);
            pst.setString(2, resume);


            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }


    public String signInUser(String userEmail, String userPass) {
        return null;
        //TODO implement
    }

    public String signOutUser(String userEmail, String userPass) {
        return null;
        //TODO implement
    }

    public String newCompany(String coID, String coName, String address, String field) {
        String query = "INSERT INTO Company(coID, coName, address, field) VALUES(?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, coID);
            pst.setString(2, coName);
            pst.setString(3, address);
            pst.setString(4,  field);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    public String newApp(String appID, String appCategory, String appName, String size, String price, String icon, String appLanguge, String description, String appOSName, String appOSVersion, String appVersion, String coID, String releaseDate) {
        //must be one insert into APP and another in APP_VERSION
        //set comment num to 0 and last version accordingly

        String rate = "0";
        String commentNumber = "0";
        String query1 = "INSERT INTO APP(appID, appCategory, size, price, icon, appName, appLanguge, rate, description, coID, appOSName, appOSVersion, commentNumber, appVersion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query1)) {

            pst.setString(1, appID);
            pst.setString(2, appCategory);
            pst.setString(3, size);
            pst.setString(4,  price);
            pst.setString(5, icon);
            pst.setString(6, appName);
            pst.setString(7, appLanguge);
            pst.setString(8, rate);
            pst.setString(9, description);
            pst.setString(10, coID);
            pst.setString(11, appOSName);
            pst.setString(12, appOSVersion);
            pst.setString(13, commentNumber);
            pst.setString(14, appVersion);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


        String query2 = "INSERT INTO APP(appVersion, appID, releaseDate) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query2)) {

            pst.setString(1, appVersion);
            pst.setString(2, appID);
            pst.setString(3, releaseDate);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    public String newReview(String appID, String heading, String context, String rating, String date) {
        return null;
        //TODO implement
        //review id is app id+ app.comment num.
    }

    public String getReviews(String appID) {
        return null;
        //TODO implement
    }

    public String searchAppsByCategory(String category) {
        return null;
        //TODO implement
    }

    public String searchAppsByName(String name) {
        return null;
        //TODO implement
    }

    public String topFreeApps() {
        return null;
        //TODO implement
    }

    public String topNotFreeApps() {
        return null;
        //TODO implement
    }

    public String topApps() {
        return null;
        //TODO implement
    }

}

