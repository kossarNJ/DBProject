/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class CallQueries {
    public String signUpUser(String userEmail, String userPass, String fName, String lName, int postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel) {
        return null;
        //TODO implement
    }

    public String signUpDeveloper(String userEmail, String userPass, String fName, String lName, int postalCode, Date dateOfBirth, String backupEmail, String imageURL, String tel, String resume) {
        return null;
        //TODO implement
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
        return null;
        //TODO implement
    }

    public String newApp(String appID, String appCategory, String appName, Double size, Double price, String icon, String appLanguge, String description, String appOSName, String appOSVersion, String appVersion) {
        return null;
        //TODO implement
        //must be one insert into APP and another in APP_VERSION
        //set comment num to 0 and last version accordingly
    }
}

