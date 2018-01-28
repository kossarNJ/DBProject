import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class CallQueries {

    public String signUpUser(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String appOSName, String appOSVersion) {

        System.out.println("just inside func.");
        String query1 = "INSERT INTO Users(user_email, fName, lName, postal_code, date_of_birth, backup_email, user_password,image_url, tel_no) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query1)) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, dateOfBirth.getYear());
            calendar.set(Calendar.DAY_OF_MONTH, dateOfBirth.getDay());
            calendar.set(Calendar.MONTH, dateOfBirth.getMonth());
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
            pst.setString(1, userEmail);
            pst.setString(2, fName);
            pst.setString(3, lName);
            pst.setInt(4, Integer.parseInt(postalCode));
            pst.setDate(5, date);
            System.out.println("after email");
            pst.setString(6, backupEmail);
            pst.setString(7, userPass);
            pst.setString(8, imageURL);
            pst.setInt(9, Integer.parseInt(tel));
//            pst.setQueryTimeout(10);
            System.out.println("metadata: " + pst.getParameterMetaData().getParameterCount());

            System.out.println(pst.executeUpdate());

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        String query2 = "INSERT INTO OS(name, version, user_id) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query2)) {

            pst.setString(1, appOSName);
            pst.setString(2, appOSVersion);
            pst.setString(3, userEmail);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;
    }

    public String signUpDeveloper(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String resume, String appOSName, String appOSVersion) {
        String query1 = "INSERT INTO Users(user_email, fName, lName, postal_code, date_of_birth, backup_email, user_password,image_url, tel_no) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query1)) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, dateOfBirth.getYear());
            calendar.set(Calendar.DAY_OF_MONTH, dateOfBirth.getDay());
            calendar.set(Calendar.MONTH, dateOfBirth.getMonth());
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

            pst.setString(1, userEmail);
            pst.setString(2, fName);
            pst.setString(3, lName);
            pst.setInt(4, Integer.parseInt(postalCode));
            pst.setDate(5, date);
            pst.setString(6, backupEmail);
            pst.setString(7, userPass);
            pst.setString(8, imageURL);
            pst.setInt(9, Integer.parseInt(tel));

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        String query2 = "INSERT INTO Developer_User(user_id, developer_resume) VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query2)) {

            pst.setString(1, userEmail);
            pst.setString(2, resume);


            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        String query3 = "INSERT INTO OS(name, version, user_id) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query3)) {

            pst.setString(1, appOSName);
            pst.setString(2, appOSVersion);
            pst.setString(3, userEmail);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }


    public String signInUser(String userEmail, String userPass) {
        String query = "SELECT user_password FROM Users WHERE user_email =  ? AND user_password = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
             ) {
            pst.setString(1, userEmail);
            pst.setString(2, userPass);
            ResultSet rs = pst.executeQuery();
            if(!rs.next()) {
                System.out.println(MyConstants.errorIncorrectUserPassMessage);
            } else {
                Main.userID = userEmail;
                Main.password = userPass;
                Main.isLoggedIn = true;
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    public String signOutUser(String userEmail, String userPass) {
        if (Main.isLoggedIn && Main.connectionUserID.equals(userEmail) && Main.connectionPassword.equals(userPass)) {
            Main.isLoggedIn = false;
            Main.password = "";
            Main.userID = "";
        } else {
            System.out.println(MyConstants.errorLogOutMessage);
        }
        return null;
    }

    public String newCompany(String coID, String coName, String address, String field) {
        String query = "INSERT INTO Company(co_id, name, address, field_of_work) VALUES(?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, coID);
            pst.setString(2, coName);
            pst.setString(3, address);
            pst.setString(4, field);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    public String newApp(String appID, String appCategory, String appName, String size, String price, String icon, String appLanguage, String description, String appOSName, String appOSVersion, String appVersion, String coID, Date releaseDate) {
        String query3 = "SELECT user_id FROM Developer_User WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query3)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            if(!rs.next()) {
                System.out.println(MyConstants.errorNotDevMessage);
            } else {
                String rate = "0";
                String commentNumber = "0";
                String query1 = "INSERT INTO APP(app_id, category, size, price, icon, name, app_language, rate, description, co_id, os_name, os_version, comment_number, last_version) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (Connection con1 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst = con1.prepareStatement(query1)) {

                    pst.setString(1, appID);
                    pst.setString(2, appCategory);
                    pst.setDouble(3, Double.parseDouble(size));
                    pst.setDouble(4, Double.parseDouble(price));
                    pst.setString(5, icon);
                    pst.setString(6, appName);
                    pst.setString(7, appLanguage);
                    pst.setDouble(8, Double.parseDouble(rate));
                    pst.setString(9, description);
                    pst.setString(10, coID);
                    pst.setString(11, appOSName);
                    pst.setString(12, appOSVersion);
                    pst.setInt(13, Integer.parseInt(commentNumber));
                    pst.setString(14, appVersion);

                    pst.executeUpdate();

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }


                String query2 = "INSERT INTO APP_Version(version_no, app_id, release_date) VALUES(?, ?, ?)";

                try (Connection con2 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst = con2.prepareStatement(query2)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, releaseDate.getYear());
                    calendar.set(Calendar.DAY_OF_MONTH, releaseDate.getDay());
                    calendar.set(Calendar.MONTH, releaseDate.getMonth());
                    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

                    pst.setString(1, appVersion);
                    pst.setString(2, appID);
                    pst.setDate(3, date);

                    pst.executeUpdate();

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }


                String query4 = "INSERT INTO developes(user_id, app_id) VALUES(?, ?)";

                try (Connection con4 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst = con4.prepareStatement(query4)) {

                    pst.setString(1, Main.userID);
                    pst.setString(2, appID);

                    pst.executeUpdate();

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


        return null;

    }

    public String newReview(String appID, String heading, String context, String rating, Date date) {
        //TODO Change review id
        //review id is app id+ app.comment num.

        String reviewId = "default";
        String query1 = "INSERT INTO Review(review_id, heading, review_content, rating, review_date) VALUES(?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query1)) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, date.getYear());
            calendar.set(Calendar.DAY_OF_MONTH, date.getDay());
            calendar.set(Calendar.MONTH, date.getMonth());
            java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());

            pst.setString(1, reviewId);
            pst.setString(2, heading);
            pst.setString(3, context);
            pst.setDouble(4, Double.parseDouble(rating));
            pst.setDate(5, date1);

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        String query2 = "INSERT INTO Post_Review(user_id, app_id, review_id) VALUES(?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query2)) {

            pst.setString(1, Main.userID);
            pst.setString(2, appID);
            pst.setString(3, reviewId);


            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
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


