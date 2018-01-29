
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
class CallQueries {

    String signUpUser(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String appOSName, String appOSVersion) {

        String query1 = "INSERT INTO Users(user_email, fName, lName, postal_code, date_of_birth, backup_email, user_password,image_url, tel_no, os_name, os_version) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pst.setString(10, appOSName);
            pst.setString(11, appOSVersion);

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "You were successfully signed up.";

        } catch (SQLException ex) {
            return "Something went wrong while signing up. Please try again and make sure to observe all mentioned constraints.";
//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    String signUpDeveloper(String userEmail, String userPass, String fName, String lName, String postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String resume, String appOSName, String appOSVersion) {
        String query1 = "INSERT INTO Users(user_email, fName, lName, postal_code, date_of_birth, backup_email, user_password,image_url, tel_no, os_name, os_version) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pst.setString(10, appOSName);
            pst.setString(11, appOSVersion);

            pst.executeUpdate();

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {

            return "Something went wrong while signing up. Please try again and make sure to observe all mentioned constraints.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
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

            return "You were successfully signed up.";

        } catch (SQLException ex) {
            return "Something went wrong while signing up. Please try again and make sure to observe all mentioned constraints.";


//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return "You were successfully signed in.";
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {

            return "Sign in unsuccessful. Please try again and make sure to be signed up and enter your email and password correctly.";
//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    String signOutUser(String userEmail, String userPass) {
        if (Main.isLoggedIn && Main.userID.equals(userEmail) && Main.password.equals(userPass)) {
            Main.isLoggedIn = false;
            Main.password = "";
            Main.userID = "";
            return "You were successfully signed out";
        } else {
            return MyConstants.errorLogOutMessage;
        }
    }

    //    koskd@kjsf.ckj
//            Koisnkjskjnskjnlan
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

            return "The company was successfully added.";

        } catch (SQLException ex) {

            return "Could not add the company. The company id may already be taken or maybe you did not observe one of the mentioned constraints. Please try again.";
//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    String newApp(String appID, String appCategory, String appName, String size, String price, String icon, String appLanguage, String description, String appOSName, String appOSVersion, String appVersion, String coID, Date releaseDate, ArrayList<String> permissions) {
        String query3 = "SELECT user_id FROM Developer_User WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query3)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            if (!rs.next()) {
                System.out.println(MyConstants.errorNotDevMessage);
            } else {
                boolean success = false;
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
                    success = true;

                } catch (SQLException ex) {
                    success = false;

//                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
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
                    success = false;

//                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }

                for (String p : permissions) {

                    String query5 = "INSERT INTO APP_Permission(permission, app_id) VALUES(?, ?)";

                    try (Connection con2 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                         PreparedStatement pst = con2.prepareStatement(query5)) {

                        pst.setString(1, p);
                        pst.setString(2, appID);

                        pst.executeUpdate();

                        try {
                            con2.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } catch (SQLException ex) {

                        success = false;
//                        Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
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

                    success = false;
//                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
                if (success) {
                    return "Your application was successfully added.";
                } else {
                    return "Could not add the application. The application id may already be taken or maybe you did not observe one of the mentioned constraints. Please try again.";
                }
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";

        } catch (SQLException ex) {
            return "Could not add the application. The application id may already be taken or maybe you did not observe one of the mentioned constraints. Please try again.";
//
//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    String newReview(String appID, String heading, String context, String rating, Date date) {
        String query3 = "SELECT comment_number FROM APP WHERE app_id = ?";
        String reviewId = "default";
        boolean success = false;


        try (Connection con4 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con4.prepareStatement(query3)
        ) {
            pst.setString(1, appID);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                return MyConstants.errorNoAPP;
            } else {
                int commentNum = Integer.parseInt(rs.getString(MyConstants.commentNumber)) + 1;
                reviewId = appID + commentNum;
                success = true;
            }

            try {
                con4.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {
            success = false;
//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
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
            if (success) {
                return "Your review was successfully posted.";
            } else {
                return "Could not post your review. The application may not be on the database or maybe you did not observe one of the mentioned constraints. Please try again.";
            }

//            success = true
        } catch (SQLException ex) {

            success = false;
            return "Could not post your review. The application may not be on the database or maybe you did not observe one of the mentioned constraints. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    String getReviews(String appID) {
        String query = "SELECT * FROM Review WHERE app_id = ?;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setString(1, appID);
            ResultSet rs = pst.executeQuery();
            int i = 1;
            if (!rs.next()) {
                return MyConstants.errorNoReview;
            } else {
                System.out.println("review #" + i++);
                System.out.println(MyConstants.heading + ": " + rs.getString(MyConstants.heading));
                System.out.println(MyConstants.content + ": " + rs.getString(MyConstants.content));
                System.out.println(MyConstants.rating + ": " + rs.getString(MyConstants.rating));
                System.out.println(MyConstants.date + ": " + rs.getString(MyConstants.date));
                System.out.println();
            }
            while (rs.next()) {
                System.out.println("review #" + i++);
                System.out.println(MyConstants.heading + ": " + rs.getString(MyConstants.heading));
                System.out.println(MyConstants.content + ": " + rs.getString(MyConstants.content));
                System.out.println(MyConstants.rating + ": " + rs.getString(MyConstants.rating));
                System.out.println(MyConstants.date + ": " + rs.getString(MyConstants.date));
                System.out.println();
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";

        } catch (SQLException ex) {
            return "Something went wrong while retrieving the reviews. There might not be any application with the ID you entered. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

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
                return MyConstants.errorNoAPPCategory;
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
            }
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

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";

        } catch (SQLException ex) {
            return "Something went wrong while retrieving the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";


//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
                return MyConstants.errorNoAPPName;
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
            }
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


            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";

        } catch (SQLException ex) {
            return "Something went wrong while retrieving the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    String topFreeApps() {
        String query = "SELECT * FROM APP WHERE price = 0 ORDER BY rate DESC;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            ResultSet rs = pst.executeQuery();
            int i = 1;

            if (!rs.next()) {
                return MyConstants.errorNoAPPFree;
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
            }
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


            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "";
        } catch (SQLException ex) {
            return "Something went wrong while retrieving the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    String topNotFreeApps() {
        String query = "SELECT * FROM APP WHERE price > 0 ORDER BY rate DESC;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            ResultSet rs = pst.executeQuery();
            int i = 1;

            if (!rs.next()) {
                return MyConstants.errorNoAPPNotFree;
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
            }
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


            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "";
        } catch (SQLException ex) {
            return "Something went wrong while retrieving the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";


//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    String topApps() {
        String query = "SELECT * FROM APP ORDER BY rate DESC;";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst = con.prepareStatement(query)
        ) {
            ResultSet rs = pst.executeQuery();
            int i = 1;

            if (!rs.next()) {
                return MyConstants.errorNoAPPAtAll;
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
            }
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


            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";

        } catch (SQLException ex) {
            return "Something went wrong while retrieving the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";


//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
                return MyConstants.errorNoAPP;
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
                    return "The application was successfully downloaded.";

                } catch (SQLException ex) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return "A problem occurred while downloading the application. One of the followings may have happened:\n" +
                            "The application you entered does not exist in the database.\n" +
                            "The application is not free and you have not registered a bank account. First register your bank account then retry downloading the application.\n" +
                            "You have not observed one of the mentioned constraints. Please try again.";

//                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }



        } catch (SQLException ex) {
            return "A problem occurred while downloading the application. One of the followings may have happened:\n" +
                    "The application you entered does not exist in the database.\n" +
                    "The application is not free and you have not registered a bank account. First register your bank account then retry downloading the application.\n" +
                    "You have not observed one of the mentioned constraints. Please try again.";


//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    String updateAllApps(Date date) {

        String query = "SELECT app_id FROM APP WHERE APP.app_id IN (SELECT Has_Downloaded.app_id FROM Has_Downloaded WHERE version_no != ALL (SELECT last_version FROM APP WHERE APP.app_id = Has_Downloaded.app_id) AND Has_Downloaded.user_id = ?);";
        String result = "";

        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();

            if (!rs.next()) {
                return MyConstants.errorNoUpdatableApp;
            } else {
                result += updateSpecificApp(rs.getString(MyConstants.app_id), date) + "\n";
            }
            while (rs.next()) {
                result += updateSpecificApp(rs.getString(MyConstants.app_id), date) + "\n";
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        } catch (SQLException ex) {
            return result;

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
                return MyConstants.errorNotUpdatableApp;
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
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    return "The application with the app_id \"" + appID + "\" " + "was successfully updated";

                } catch (SQLException ex) {
                    return "Something went wrong while updating the application with the app_id \"" + appID + "\". Maybe you did not observe one of the mentioned constraints or the application may already be up-to-date. Please try again.";

//                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        } catch (SQLException ex) {
            return "Something went wrong while updating the application with the app_id \"" + appID + "\". Maybe you did not observe one of the mentioned constraints or the application may already be up-to-date. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

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
                return MyConstants.errorNoUpdatableApp;
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
            }
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


            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";

        } catch (SQLException ex) {
            return "Something went wrong while retrieving the updatable applications. Maybe you did not observe one of the mentioned constraints. Please try again.";


//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

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
                return MyConstants.errorNoDownloadedApp;
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
            }
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


            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "";

        } catch (SQLException ex) {
            return "Something went wrong while retrieving the downloaded applications with the app_id. Maybe you did not observe one of the mentioned constraints. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
            }
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
                return MyConstants.errorNotDevMessage;
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

            return "The company was successfully added as your employer";

        } catch (SQLException ex) {

            return "Something went wrong while registering the company as your employer. Maybe you did not observe one of the mentioned constraints or the company may not exist in the database, in which case you need to add the company first and try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    String newVersion(String version, String appId, Date date, ArrayList<String> addedFeatures, ArrayList<String> resolvedBugs) {
        String query3 = "SELECT user_id FROM Developer_User WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
             PreparedStatement pst1 = con.prepareStatement(query3)
        ) {
            pst1.setString(1, Main.userID);
            ResultSet rs = pst1.executeQuery();
            boolean success = false;
            if (!rs.next()) {
                return MyConstants.errorNotDevMessage;
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
                    success = true;

                } catch (SQLException ex) {
                    success = false;

//                    Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }


                for (String r : resolvedBugs) {

                    String query5 = "INSERT INTO Resolved_Bugs(bug, version_no, app_id) VALUES(?, ?, ?)";

                    try (Connection con2 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                         PreparedStatement pst = con2.prepareStatement(query5)) {

                        pst.setString(1, r);
                        pst.setString(2, version);
                        pst.setString(3, appId);

                        pst.executeUpdate();

                        try {
                            con2.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } catch (SQLException ex) {
                        success = false;

//                        Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }

                for (String f : addedFeatures) {

                    String query5 = "INSERT INTO ADDED_FEATURE(feature, version_no, app_id) VALUES(?, ?, ?)";

                    try (Connection con2 = DriverManager.getConnection(Main.url, Main.connectionUserID, Main.connectionPassword);
                         PreparedStatement pst = con2.prepareStatement(query5)) {

                        pst.setString(1, f);
                        pst.setString(2, version);
                        pst.setString(3, appId);

                        pst.executeUpdate();

                        try {
                            con2.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } catch (SQLException ex) {
                        success = false;

//                        Logger lgr = Logger.getLogger(CallQueries.class.getName());
//                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }

                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (success) {

                    return "The new version of your application was successfully added.";
                } else {
                    return "Something went wrong while adding the new version of the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";
                }
            }



        } catch (SQLException ex) {
            return "Something went wrong while adding the new version of the applications. Maybe you did not observe one of the mentioned constraints. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
            return "Your bank account was successfully registered.";

        } catch (SQLException ex) {
            return "Something went wrong while registering your bank account. Maybe you did not observe one of the mentioned constraints. Please try again.";

//            Logger lgr = Logger.getLogger(CallQueries.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


}


