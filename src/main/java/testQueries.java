import java.util.ArrayList;

/**
 * Created by saharzargarzadeh on 1/28/18.
 */
public class testQueries {

    public static void main(String[] args) {
        Main.connectionUserID = "postgres";
        Main.connectionPassword = "123";
        Main.url = "jdbc:postgresql://localhost:5432/App_Store_DB";

//        https://www.google.com

//    koskd@kjsf.ckj
//    Koisnkjskjnskjnlan

        Main.userID = "kosa@gmail.com";
        Main.password = "123";

        CallQueries callQueries = new CallQueries();
//        callQueries.signUpUser("sa@gmail.com", "123", "kossar", "najafi", "234567", Date.getDateFromString("1997-05-15"), "najafiaghdam@ce.sharif.edu", "https://www.google.com", "0914789", "macOS", "El Capitan");
//        ArrayList<String> p = new ArrayList<>();
//        p.add("phone");
//        p.add("contacts");
//        p.add("camera");
//        callQueries.newApp("myApp7", "Entertainment", "game", "4.5", "0", "https://www.google.com", "english", "who cares?", "macOS", "El Capitan", "1.0", "myCompany", Date.getDateFromString("1997-05-15"), p);
//        callQueries.signInUser("kossrana@gmail.com", "12");
//        callQueries.signUpDeveloper()
//        callQueries.newApp("")
//        callQueries.newReview("myApp2", "great app!", "I enjoyed your app a lot.", "4.6", Date.getDateFromString("1396-11-9"));
        callQueries.getReviews("newApp");
//        callQueries.searchAppsByCategory("Entertainment");
//        callQueries.searchAppsByName("kosar");
//        callQueries.topFreeApps();
//        callQueries.topNotFreeApps();
//        callQueries.topApps();
//        callQueries.newCompany("myCompany", "company", "tehran, iran", "app");
//        callQueries.addEmployer("myCompany");
//        ArrayList<String> f = new ArrayList<>();
//        f.add("robustness");
//        f.add("network");
//        ArrayList<String> r = new ArrayList<>();
//        r.add("lag");
//        r.add("crash");
//        callQueries.newVersion("8.0.0", "myApp2", Date.getDateFromString("1396-10-9"), f, r);
//        callQueries.downloadApp("myApp3", Date.getDateFromString("1396-11-9"));
//        callQueries.registerAccount("1000000000000200");
//        callQueries.viewDownloaded();
//        callQueries.viewCompanyApps("myCompany");
//        callQueries.viewUpdatable();
//        callQueries.updateSpecificApp("myApp3", Date.getDateFromString("1396-11-10"));
//        callQueries.updateAllApps(Date.getDateFromString("1396-11-10"));
    }
}


