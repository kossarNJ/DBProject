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
        callQueries.newApp("myApp5", "Entertainment", "game", "4.5", "31", "https://www.google.com", "english", "who cares?", "macOS", "El Capitan", "1.0", "myCompany", Date.getDateFromString("1997-05-15"));
//        callQueries.signInUser("kossarna@gmail.com", "12");
//        callQueries.signUpDeveloper()
//        callQueries.newApp("")
    }
}
