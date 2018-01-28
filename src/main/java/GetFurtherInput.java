import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class GetFurtherInput {
    private static final String userEmail = "Please enter your email address.";
    private static final String userPass = "Please enter your password.";
    private static final String fname = "Please enter your first name.";
    private static final String lname = "Please enter your last name.";
    private static final String postalCode = "Please enter your postal code.";
    private static final String date = "Please enter your date of birth in the following format yyyy/mm/dd.";
    private static final String backupEmail = "Please enter your backup email.";
    private static final String imageURL = "Please enter the URL of your image.";
    private static final String telephone = "Please enter your telephone number.";

    private static final String resume = "Please enter your resume.";

    private static final String coID = "Please enter the user ID of the company.";
    private static final String coName = "Please enter the name of the company.";
    private static final String address = "Please enter the address of the company.";
    private static final String fieldOfWork = "Please enter the company's field of work.";

    private static final String appID = "Please enter the ID of the application.";
    private static final String appCategory = "Please enter the category of the application.";
    private static final String appName = "Please enter the name of the application.";
    private static final String size = "Please enter the size of the application (in megabytes).";
    private static final String price = "Please enter the price of the application (in USD).";
    private static final String icon = "Please enter the URL for the icon of the application.";
    private static final String appLanguage = "Please enter the language of the application.";
    private static final String description = "Please enter the description of the application.";
    private static final String appOSName = "Please enter the name of the operating system the application is compatible with.";
    private static final String appOSVersion = "Please enter the version of the operating system the application is compatible with.";
    private static final String appVersion = "Please enter the version of the application.";
//    private static final String rate = "Please enter the language of the application.";


    public HashMap<String, Object> signUpUser(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, input);

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, input);

        System.out.println(fname);
        parameters.put(MyConstants.fNameKey, input);

        System.out.println(lname);
        parameters.put(MyConstants.lNameKey, input);

        System.out.println(postalCode);
        parameters.put(MyConstants.postalCodeKey, input);

        System.out.println(date);
        parameters.put(MyConstants.dateOfBirthKey, input);

        System.out.println(backupEmail);
        parameters.put(MyConstants.backupEmailKey, input);

        System.out.println(imageURL);
        parameters.put(MyConstants.imageURLKey, input);

        System.out.println(telephone);
        parameters.put(MyConstants.telKey, input);

        return parameters;
    }

    public HashMap<String, Object> signInUser(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, input);

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, input);

        return parameters;
    }


    public HashMap<String, Object> signOutUser(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, input);

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, input);

        return parameters;
    }


    public HashMap<String, Object> newCompany(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();

        System.out.println(coID);
        parameters.put(MyConstants.coIDKey, scanner.nextLine());

        System.out.println(coName);
        parameters.put(MyConstants.coNameKey, scanner.nextLine());

        System.out.println(address);
        parameters.put(MyConstants.coAddressKey, scanner.nextLine());

        System.out.println(fieldOfWork);
        parameters.put(MyConstants.coFieldKey, scanner.nextLine());
        return parameters;
    }


    public HashMap<String, Object> newAPP(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();

        System.out.println(appID);
        parameters.put(MyConstants.appIDKey, scanner.nextLine());

        System.out.println(appCategory);
        parameters.put(MyConstants.appCategoryKey, scanner.nextLine());

        System.out.println(size);
        parameters.put(MyConstants.sizeKey, scanner.nextLine());

        System.out.println(price);
        parameters.put(MyConstants.priceKey, scanner.nextLine());

        System.out.println(icon);
        parameters.put(MyConstants.iconKey, scanner.nextLine());

        System.out.println(appName);
        parameters.put(MyConstants.appNameKey, scanner.nextLine());

        System.out.println(appLanguage);
        parameters.put(MyConstants.appLanguageKey, scanner.nextLine());

//        System.out.println(rate);
//        parameters.put(MyConstants.rateKey, scanner.nextLine());

        System.out.println(description);
        parameters.put(MyConstants.descriptionKey, scanner.nextLine());

        System.out.println(coID); //??
        parameters.put(MyConstants.coIDKey, scanner.nextLine()); //??

        System.out.println(appOSName);
        parameters.put(MyConstants.appOSNameKey, scanner.nextLine());

        System.out.println(appOSVersion);
        parameters.put(MyConstants.appOSVersionKey, scanner.nextLine());

//        System.out.println(commentNum);
//        parameters.put(MyConstants.commentNum, scanner.nextLine());

        System.out.println(appVersion);
        parameters.put(MyConstants.appVersionKey, scanner.nextLine());

        return parameters;
    }


    public HashMap<String, Object> signUpDeveloper(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, input);

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, input);

        System.out.println(fname);
        parameters.put(MyConstants.fNameKey, input);

        System.out.println(lname);
        parameters.put(MyConstants.lNameKey, input);

        System.out.println(postalCode);
        parameters.put(MyConstants.postalCodeKey, input);

        System.out.println(date);
        parameters.put(MyConstants.dateOfBirthKey, input);

        System.out.println(backupEmail);
        parameters.put(MyConstants.backupEmailKey, input);

        System.out.println(imageURL);
        parameters.put(MyConstants.imageURLKey, input);

        System.out.println(telephone);
        parameters.put(MyConstants.telKey, input);

        System.out.println(resume);
        parameters.put(MyConstants.resumeKey, input);

        return parameters;
    }

//    public HashMap<String, Object> newReview(Scanner scanner) {
//        HashMap<String, Object> parameters = new HashMap<>();
//
//        parameters.put(MyConstants.headingKey, scanner.nextLine());
//        parameters.put(MyConstants.context, scanner.nextLine());
//        parameters.put(MyConstants.context, scanner.nextLine());
//
//        //review id is the app id + app.commentNum
//        return parameters;
//    }

}
