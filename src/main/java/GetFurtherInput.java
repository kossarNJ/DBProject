import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class GetFurtherInput {
    private static final String userEmail = "Please enter your email address.";
    private static final String userPass = "Please enter your connectionPassword.";
    private static final String fname = "Please enter your first name.";
    private static final String lname = "Please enter your last name.";
    private static final String postalCode = "Please enter your postal code.";
    private static final String date = "Please enter your date of birth in the following format: yyyy/mm/dd.";
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
    private static final String appOSVersion = "Please enter the version of the operating system the application is compatible with.\n" +
            "The version may only be one of the followings:\n" +
            "1. Kodiak\n" +
            "2. Cheetah\n" +
            "3. Puma\n" +
            "4. Jaguar\n" +
            "5. Panther\n" +
            "6. Tiger\n" +
            "7. Leopard\n" +
            "8. Snow Leopard\n" +
            "9. Lion\n" +
            "10. Mountain Lion\n" +
            "11. Mavericks\n" +
            "12. Yosemite\n" +
            "13. El Capitan\n" +
            "14. Sierra\n" +
            "15. High Sierra";
    private static final String appVersion = "Please enter the version of the application.";
    private static final String appReleaseDate = "Please enter the release date of the application in the following format: yyyy-mm-dd.";

    private static final String heading = "Please enter the heading of the review.";
    private static final String context = "Please enter the text of the review.";
    private static final String reviewRating = "Please enter the text of the review.";
    private static final String reviewDate = "Please enter the date of the review in the following format: yyyy/mm/dd.";

    private static final String updateDate = "Please enter the date of the update in the following format: yyyy/mm/dd.";
    private static final String versionDate = "Please enter the date of the version in the following format: yyyy/mm/dd.";
    private static final String downloadDate = "Please enter the date of the download in the following format: yyyy/mm/dd.";

    private static final String bankAccount = "Please enter your card number. (must be a 16 digit number)";


//    private static final String rate = "Please enter the language of the application.";


    public HashMap<String, Object> signUpUser(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
//        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, scanner.nextLine());

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, scanner.nextLine());

        System.out.println(fname);
        parameters.put(MyConstants.fNameKey, scanner.nextLine());

        System.out.println(lname);
        parameters.put(MyConstants.lNameKey, scanner.nextLine());

        System.out.println(postalCode);
        parameters.put(MyConstants.postalCodeKey, scanner.nextLine());

        System.out.println(date);
        Date date = Date.getDateFromString(scanner.nextLine());
        parameters.put(MyConstants.dateOfBirthKey, date);

        System.out.println(backupEmail);
        parameters.put(MyConstants.backupEmailKey, scanner.nextLine());

        System.out.println(imageURL);
        parameters.put(MyConstants.imageURLKey, scanner.nextLine());

        System.out.println(telephone);
        parameters.put(MyConstants.telKey, scanner.nextLine());

        System.out.println(appOSName);
        parameters.put(MyConstants.appOSNameKey, scanner.nextLine());

        System.out.println(appOSVersion);
        parameters.put(MyConstants.appOSVersionKey, scanner.nextLine());

        return parameters;
    }

    public HashMap<String, Object> signInUser(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, scanner.nextLine());

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, scanner.nextLine());

        return parameters;
    }


    public HashMap<String, Object> signOutUser(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
//        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, scanner.nextLine());

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, scanner.nextLine());

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

        System.out.println(appReleaseDate);
        Date date = Date.getDateFromString(scanner.nextLine());
        parameters.put(MyConstants.appReleaseDateKey, date);


        return parameters;
    }


    public HashMap<String, Object> signUpDeveloper(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(userEmail);
        String input = scanner.nextLine();
        //do we check to see if it's a valid email address?
        parameters.put(MyConstants.userEmailKey, input);

        System.out.println(userPass);
        parameters.put(MyConstants.userPassKey, scanner.nextLine());

        System.out.println(fname);
        parameters.put(MyConstants.fNameKey, scanner.nextLine());

        System.out.println(lname);
        parameters.put(MyConstants.lNameKey, scanner.nextLine());

        System.out.println(postalCode);
        parameters.put(MyConstants.postalCodeKey, scanner.nextLine());

        System.out.println(date);
        Date date = Date.getDateFromString(scanner.nextLine());
        parameters.put(MyConstants.dateOfBirthKey, date);

        System.out.println(backupEmail);
        parameters.put(MyConstants.backupEmailKey, scanner.nextLine());

        System.out.println(imageURL);
        parameters.put(MyConstants.imageURLKey, scanner.nextLine());

        System.out.println(telephone);
        parameters.put(MyConstants.telKey, scanner.nextLine());

        System.out.println(resume);
        parameters.put(MyConstants.resumeKey, scanner.nextLine());

        System.out.println(appOSName);
        parameters.put(MyConstants.appOSNameKey, scanner.nextLine());

        System.out.println(appOSVersion);
        parameters.put(MyConstants.appOSVersionKey, scanner.nextLine());


        return parameters;
    }

    public HashMap<String, Object> newReview(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();

        System.out.println(appID);
        parameters.put(MyConstants.appIDKey, scanner.nextLine());

        System.out.println(heading);
        parameters.put(MyConstants.headingKey, scanner.nextLine());

        System.out.println(context);
        parameters.put(MyConstants.contextKey, scanner.nextLine());

        System.out.println(reviewRating);
        parameters.put(MyConstants.reviewRatingKey, scanner.nextLine());

        System.out.println(reviewDate);
        Date date = Date.getDateFromString(scanner.nextLine());
        parameters.put(MyConstants.reviewDateKey, date);

//        String reviewID = parameters.get(MyConstants.appIDKey) +

//        parameters.put(MyConstants.reviewIDKey, )
        //review id is the app id + app.commentNum
        //TODO ye fekri be hale review ID bokon.
        return parameters;
    }

    public HashMap<String, Object> getReviews(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(appID);
        parameters.put(MyConstants.appIDKey, scanner.nextLine());
        return parameters;
    }

    public HashMap<String, Object> searchApps(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(MyConstants.searchTypeMessage);
        System.out.println(MyConstants.byCategory);
        System.out.println(MyConstants.byName);
        boolean valid = false;
        String type = "";
        while (!valid) {
            type = scanner.nextLine();
            switch (type) {
                case MyConstants.byCategory:
                    System.out.println(appCategory);
                    parameters.put(MyConstants.appCategoryKey, scanner.nextLine());
                    valid = true;
                    break;
                case MyConstants.byName:
                    System.out.println(appName);
                    parameters.put(MyConstants.appNameKey, scanner.nextLine());
                    valid = true;
                    break;
                default:
                    System.out.println(MyConstants.errorSearchTypeMessage);
            }
        }
        return parameters;
    }

    public HashMap<String, Object> topApps(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(MyConstants.topAppsTypeMessage);
        System.out.println(MyConstants.free);
        System.out.println(MyConstants.notFree);
        System.out.println(MyConstants.any);
        boolean valid = false;
        String type = "";
        while (!valid) {
            type = scanner.nextLine();
            switch (type) {
                case MyConstants.free:
//                    System.out.println(appCategory);
                    parameters.put(MyConstants.filterTypeKey, MyConstants.free);
                    valid = true;
                    break;
                case MyConstants.byName:
//                    System.out.println(appName);
                    parameters.put(MyConstants.filterTypeKey, MyConstants.notFree);
                    valid = true;
                    break;
                case MyConstants.any:
                    parameters.put(MyConstants.filterTypeKey, MyConstants.any);
                    valid = true;
                    break;
                default:
                    System.out.println(MyConstants.errorTopAppTypeMessage);
            }
        }

        return parameters;
    }

    public HashMap<String, Object> similarApps(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(appID);
        parameters.put(MyConstants.appIDKey, scanner.nextLine());
        return parameters;
    }

    public HashMap<String, Object> downloadApp (Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(appID);
        parameters.put(MyConstants.appIDKey, scanner.nextLine());

        System.out.println(downloadDate);
        Date date = Date.getDateFromString(scanner.nextLine());
        parameters.put(MyConstants.downloadDateKey, date);
        return parameters;
    }

    public HashMap<String, Object> updateApp(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(MyConstants.updateAppsTypeMessage);
        System.out.println(MyConstants.all);
        System.out.println(MyConstants.specific);
        boolean valid = false;
        String type = "";
        while (!valid) {
            type = scanner.nextLine();
            switch (type) {
                case MyConstants.all:
                    System.out.println(updateDate);
                    Date date1 = Date.getDateFromString(scanner.nextLine());
                    parameters.put(MyConstants.updateDateKey, date1);
                    parameters.put(MyConstants.updateTypeKey, MyConstants.all);
                    valid = true;
                    break;
                case MyConstants.specific:
                    System.out.println(appID);
                    parameters.put(MyConstants.appIDKey, scanner.nextLine());
                    System.out.println(updateDate);
                    Date date = Date.getDateFromString(scanner.nextLine());
                    parameters.put(MyConstants.updateDateKey, date);
                    parameters.put(MyConstants.updateTypeKey, MyConstants.specific);
                    valid = true;
                    break;
                default:
                    System.out.println(MyConstants.errorUpdateTypeMessage);
            }
        }

        return parameters;
    }

    public HashMap<String, Object> viewCompanyApps(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(coID);
        parameters.put(MyConstants.coIDKey, scanner.nextLine());
        return parameters;
    }

    public HashMap<String, Object> addEmployer(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(coID);
        parameters.put(MyConstants.coIDKey, scanner.nextLine());
        return parameters;
    }

    public HashMap<String, Object> newVersion(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(appID);
        parameters.put(MyConstants.appIDKey, scanner.nextLine());

        System.out.println(versionDate);
        Date date = Date.getDateFromString(scanner.nextLine());
        parameters.put(MyConstants.versionDateKey, date);

        System.out.println(appVersion);
        parameters.put(MyConstants.appVersionKey, scanner.nextLine());
        return parameters;
    }

    public HashMap<String, Object> registerAccount(Scanner scanner) {
        HashMap<String, Object> parameters = new HashMap<>();
        System.out.println(bankAccount);
        parameters.put(MyConstants.bankAccountKey, scanner.nextLine());
        return parameters;
    }

}
