/**
 * Created by saharzargarzadeh on 1/28/18.
 */
public class testQeries {

    public static void main(String[] args) {
        Main.connectionUserID = "postgres";
        Main.connectionPassword = "123";
        Main.url = "jdbc:postgresql://localhost:5432/App_Store_DB";

        Main.userID = "kosa@gmail.com";
        Main.password = "123";

        CallQueries callQueries = new CallQueries();
        System.out.println("before query call.");
//        callQueries.signUpUser("sahar@gmail.com", "123", "kossar", "najafi", "234567", Date.getDateFromString("1997-05-15"), "najafiaghdam@ce.sharif.edu", "https://www.google.com", "0914789", "macOS", "El Capitan");
//        callQueries.newApp("myApp6", "Entertainment", "game", "4.5", "0", "https://www.google.com", "english", "who cares?", "macOS", "El Capitan", "1.0", "myCompany", Date.getDateFromString("1997-05-15"));
//        callQueries.signInUser("kossarna@gmail.com", "12");
//        callQueries.signUpDeveloper()
//        callQueries.newApp("")
//        callQueries.newReview("myApp2", "great app!", "I enjoyed your app a lot.", "4.6", Date.getDateFromString("1396-11-9"));
//        callQueries.getReviews("myApp2");
//        callQueries.searchAppsByCategory("Entertainment");
//        callQueries.searchAppsByName("kosar");
//        callQueries.topFreeApps();
//        callQueries.topNotFreeApps();
        callQueries.topApps();
    }
}


//﻿update app set comment_number = 0;