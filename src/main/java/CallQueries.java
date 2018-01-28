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
            pst.setString(4, postalCode);
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
            pst.setString(4, postalCode);
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
        //TODO implement
        //check if correct

        String query = "SELECT user_password FROM Users WHERE user_email =  userEmail AND user_password = userPass;";

        return null;

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
            pst.setString(4, field);

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
            pst.setString(4, price);
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


        String query2 = "INSERT INTO APP_Version(appVersion, appID, releaseDate) VALUES(?, ?, ?)";

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
        //TODO Change review id
        //review id is app id+ app.comment num.

        String reviewId = "default";
        String query1 = "INSERT INTO Review(reviewId, heading, context) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query1)) {

            pst.setString(1, reviewId);
            pst.setString(2, heading);
            pst.setString(3, context);


            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        String query2 = "INSERT INTO Post_Review(Main.userID, appID, reviewId) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.userID, Main.password);
             PreparedStatement pst = con.prepareStatement(query2)) {

            pst.setString(1, Main.userID);
            pst.setString(2, appID);
            pst.setString(3, reviewId);


            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    public String getReviews(String appID) {
        //TODO implement

        String query = "SELECT * FROM Review WHERE review_id = (SELECT review_id FROM Post_Review WHERE Post_Review.app_id = appID);";


        return null;

    }

    public String searchAppsByCategory(String category) {
        //TODO implement

        String query = "SELECT * FROM APP WHERE category = category;";

        return null;

    }

    public String searchAppsByName(String name) {
        //TODO implement

        String query = "SELECT * FROM APP WHERE name = NULL;";

        return null;

    }

    public String topFreeApps() {
        //TODO implement

        String query = "SELECT * FROM APP WHERE price = 0 ORDER BY rate;";

        return null;

    }

    public String topNotFreeApps() {
        //TODO implement

        String query = "SELECT * FROM APP WHERE price > 0 ORDER BY rate;";

        return null;

    }

    public String topApps() {
        //TODO implement

        String query = "SELECT * FROM APP WHERE price > 0 ORDER BY rate;";

        return null;

    }

    public String similarApps(String appId) {
        return null;
        //TODO implement
    }

    public String downloadApp(String appId) {
        return null;
        //TODO implement
    }

    public String updateAllApps(String date) {
        return null;
        //TODO implement
    }

    public String updateSpecificApp(String appID, String date) {
        return null;
        //TODO implement
    }

    public String viewUpdatable() {
        return null;
        //TODO implement
    }

    public String viewDownloaded() {
        return null;
        //TODO implement
    }

    public String viewCompanyApps(String coID) {
        return null;
        //TODO implement
    }

    public String addEmployer(String coID) {
        return null;
        //TODO implement
    }

    public String newVersion(String version, String appId, String date) {
        return null;
        //TODO implement
    }
}


