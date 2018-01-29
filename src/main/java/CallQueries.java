import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
class CallQueries {

    String signUpUser(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String appOSName, String appOSVersion) {

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

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;
    }

    String signUpDeveloper(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String resume, String appOSName, String appOSVersion) {
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

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

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

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }


    String signInUser(String userEmail, String userPass) {
        String query = "SELECT user_password FROM Users WHERE user_email =  ? AND user_password = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setString(1, userEmail);
            pst.setString(2, userPass);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorIncorrectUserPassMessage);
            } else {
                Main.userID = userEmail;
                Main.password = userPass;
                Main.isLoggedIn = true;
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    String signOutUser(String userEmail, String userPass) {
        if (Main.isLoggedIn && Main.connectionUserID.equals(userEmail) && Main.connectionPassword.equals(userPass)) {
            Main.isLoggedIn = false;
            Main.password = "";
            Main.userID = "";
        } else {
            System.out.println(MyConstants.errorLogOutMessage);
        }
        return null;
    }

    String newCompany(String coID, String coName, String address, String field) {
        String query = "INSERT INTO Company(co_id, name, address, field_of_work) VALUES(?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, coID);
            pst.setString(2, coName);
            pst.setString(3, address);
            pst.setString(4, field);

            pst.executeUpdate();

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    String newApp(String appID, String appCategory, String appName, String size, String price, String icon, String appLanguage, String description, String appOSName, String appOSVersion, String appVersion, String coID, Date releaseDate) {
        String query3 = "SELECT user_id FROM Developer_User WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query3)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            if (!rs.next()) {
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

                    try {
                        con1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

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

                    try {
                        con2.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

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

                    try {
                        con4.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


        return null;

    }

    String newReview(String appID, String heading, String context, String rating, Date date) {
        String query3 = "SELECT comment_number FROM APP WHERE app_id = ?";
        String reviewId = "default";


        try (Connection con4 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con4.prepareStatement(query3)
        ) {
            pst.setString(1, appID);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPP);
            } else {
                int commentNum = Integer.parseInt(rs.getString(MyConstants.commentNumber)) + 1;
                reviewId = appID + commentNum;
            }

            try {
                con4.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        String query1 = "INSERT INTO Review(review_id, heading, review_content, rating, review_date, app_id, user_id) VALUES(?, ?, ?, ?, ?, ?, ?)";

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
            pst.setString(6, appID);
            pst.setString(7, Main.userID);

            pst.executeUpdate();

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    String getReviews(String appID) {
        String query = "SELECT * FROM Review WHERE app_id = ?";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setString(1, appID);
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoReview);
            }
            {
                while (rs.next()) {
                    System.out.println("review #" + i++);
                    System.out.println(MyConstants.heading + ": " + rs.getString(MyConstants.heading));
                    System.out.println(MyConstants.content + ": " + rs.getString(MyConstants.content));
                    System.out.println(MyConstants.rating + ": " + rs.getString(MyConstants.rating));
                    System.out.println(MyConstants.date + ": " + rs.getString(MyConstants.date));
                    System.out.println();
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    String searchAppsByCategory(String category) {
        String query = "SELECT * FROM APP WHERE category = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setString(1, category);
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPPCategory);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    String searchAppsByName(String name) {

        String query = "SELECT * FROM APP WHERE name = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPPName);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    String topFreeApps() {
        String query = "SELECT * FROM APP WHERE price = 0 ORDER BY rate DESC;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPPFree);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    String topNotFreeApps() {
        String query = "SELECT * FROM APP WHERE price > 0 ORDER BY rate DESC;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPPNotFree);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;

    }

    String topApps() {
        String query = "SELECT * FROM APP ORDER BY rate DESC;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPPAtAll);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    String downloadApp(String appID, Date downloadDate) {
        String lastVersion;
        String query = "SELECT last_version FROM APP WHERE app_id = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setString(1, appID);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoAPP);
            } else {
                lastVersion = rs.getString(MyConstants.last_version);
                String query2 = "INSERT INTO Has_downloaded(user_id, app_id, date_of_download, version_no) VALUES(?, ?, ?, ?)";

                try (Connection con1 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst1 = con1.prepareStatement(query2)) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, downloadDate.getYear());
                    calendar.set(Calendar.DAY_OF_MONTH, downloadDate.getDay());
                    calendar.set(Calendar.MONTH, downloadDate.getMonth());
                    java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());

                    pst1.setString(1, Main.userID);
                    pst1.setString(2, appID);
                    pst1.setDate(3, date1);
                    pst1.setString(4, lastVersion);

                    pst1.executeUpdate();

                    try {
                        con1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    String updateAllApps(Date date) {

        String query = "SELECT app_id FROM APP WHERE APP.app_id IN (SELECT Has_Downloaded.app_id FROM Has_Downloaded WHERE version_no != ALL (SELECT last_version FROM APP WHERE APP.app_id = Has_Downloaded.app_id) AND Has_Downloaded.user_id = ?);";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoUpdatableApp);
            } else {
                System.out.println(updateSpecificApp(rs.getString(MyConstants.app_id), date));
                while (rs.next()) {
                    System.out.println(updateSpecificApp(rs.getString(MyConstants.app_id), date));
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    String updateSpecificApp(String appID, Date date) {

        String lastVersion;
        String query1 = "SELECT last_version FROM APP WHERE app_id = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query1)
        ) {
            pst1.setString(1, appID);
            ResultSet rs = pst1.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNotUpdatableApp);
            } else {
                lastVersion = rs.getString(MyConstants.last_version);
                String query2 = "Update Has_Downloaded SET version_no = ?, date_of_download = ? WHERE app_id = ?";

                try (Connection con1 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst = con1.prepareStatement(query2)) {


                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, date.getYear());
                    calendar.set(Calendar.DAY_OF_MONTH, date.getDay());
                    calendar.set(Calendar.MONTH, date.getMonth());
                    java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());

                    pst.setString(1, lastVersion);
                    pst.setDate(2, date1);
                    pst.setString(3, appID);

                    pst.executeUpdate();

                    try {
                        con1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    String viewUpdatable() {
        String query = "SELECT * FROM APP WHERE APP.app_id IN (SELECT Has_Downloaded.app_id FROM Has_Downloaded WHERE version_no != ALL (SELECT last_version FROM APP WHERE APP.app_id = Has_Downloaded.app_id) AND Has_Downloaded.user_id = ?);";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoUpdatableApp);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }

            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


        return null;
    }

    String viewDownloaded() {
        String query = "SELECT * FROM APP WHERE EXISTS(SELECT app_id FROM Has_Downloaded WHERE APP.app_id = Has_Downloaded.app_id AND user_id = ?);";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoDownloadedApp);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }

            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return null;
    }

    String viewCompanyApps(String coID) {
        String query = "SELECT * FROM APP WHERE EXISTS(SELECT * FROM Developes WHERE APP.app_id = Developes.app_id AND EXISTS(SELECT * FROM Employment WHERE Developes.user_id = Employment.user_id AND Employment.co_id = ?));";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query)
        ) {
            pst1.setString(1, coID);
            ResultSet rs = pst1.executeQuery();
            int i = 1;
            if (!rs.next()) {
                System.out.println(MyConstants.errorNoCompanyApp);
            } else {
                System.out.println("application #" + i++);
                System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                System.out.println();
                while (rs.next()) {
                    System.out.println("application #" + i++);
                    System.out.println(MyConstants.app_id + ": " + rs.getString(MyConstants.app_id));
                    System.out.println(MyConstants.name + ": " + rs.getString(MyConstants.name));
                    System.out.println(MyConstants.category + ": " + rs.getString(MyConstants.category));
                    System.out.println(MyConstants.size + ": " + rs.getString(MyConstants.size));
                    System.out.println(MyConstants.price + ": " + rs.getString(MyConstants.price));
                    System.out.println(MyConstants.icon + ": " + rs.getString(MyConstants.icon));
                    System.out.println(MyConstants.app_language + ": " + rs.getString(MyConstants.app_language));
                    System.out.println(MyConstants.rate + ": " + rs.getString(MyConstants.rate));
                    System.out.println(MyConstants.description + ": " + rs.getString(MyConstants.description));
                    System.out.println(MyConstants.co_id + ": " + rs.getString(MyConstants.co_id));
                    System.out.println(MyConstants.os_name + ": " + rs.getString(MyConstants.os_name));
                    System.out.println(MyConstants.os_version + ": " + rs.getString(MyConstants.os_version));
                    System.out.println(MyConstants.commentNumber + ": " + rs.getString(MyConstants.commentNumber));
                    System.out.println(MyConstants.last_version + ": " + rs.getString(MyConstants.last_version));
                    System.out.println();
                }

            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


        return null;
    }

    String addEmployer(String coID) {
        String query3 = "SELECT user_id FROM Developer_User WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query3)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNotDevMessage);
            } else {
                String query = "INSERT INTO Employment(co_id, user_id) VALUES(?, ?)";

                try (Connection con1 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst = con1.prepareStatement(query)) {

                    pst.setString(1, coID);
                    pst.setString(2, Main.userID);

                    pst.executeUpdate();

                    try {
                        con1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    String newVersion(String version, String appId, Date date) {
        String query3 = "SELECT user_id FROM Developer_User WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query3)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNotDevMessage);
            } else {
                String query = "INSERT INTO APP_Version(version_no, app_id, release_date) VALUES(?, ?, ?)";

                try (Connection con1 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                     PreparedStatement pst = con1.prepareStatement(query)) {


                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, date.getYear());
                    calendar.set(Calendar.DAY_OF_MONTH, date.getDay());
                    calendar.set(Calendar.MONTH, date.getMonth());
                    java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());

                    pst.setString(1, version);
                    pst.setString(2, appId);
                    pst.setDate(3, date1);

                    pst.executeUpdate();

                    try {
                        con1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } catch (SQLException ex) {

                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    String registerAccount(String bankAccount) {
        String query = "INSERT INTO User_Bank_Account (card_no, user_id) VALUES(?, ?)";

        try (Connection con1 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con1.prepareStatement(query)) {
            pst.setBigDecimal(1, new BigDecimal(bankAccount));
            pst.setString(2, Main.userID);

            pst.executeUpdate();

            try {
                con1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(CallQueries.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }


//    String similarApps(String appId) {
//        return null;
//        //TODO implement
//    }

}


