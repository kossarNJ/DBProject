/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class MyConstants {

    public static final String userEmailKey = "userEmail";
    public static final String userPassKey = "userPass";
    public static final String fNameKey = "fName";
    public static final String lNameKey = "lName";
    public static final String postalCodeKey = "postalCode";
    public static final String dateOfBirthKey = "dateOfBirth";
    public static final String backupEmailKey = "backupEmail";
    public static final String imageURLKey = "imageURL";
    public static final String telKey = "telephone";
    public static final String resumeKey = "resume";
    public static final String coIDKey = "coID";
    public static final String coNameKey = "coName";
    public static final String coAddressKey = "coAddress";
    public static final String coFieldKey = "coField";
    public static final String appIDKey = "appIDKey";
    public static final String appVersionKey = "appIDKey";
    public static final String appOSVersionKey = "appIDKey";
    public static final String appOSNameKey = "appIDKey";
    public static final String descriptionKey = "appIDKey";
    public static final String rateKey = "appIDKey";
    public static final String appLanguageKey = "appIDKey";
    public static final String appNameKey = "appIDKey";
    public static final String iconKey = "appIDKey";
    public static final String priceKey = "appIDKey";
    public static final String sizeKey = "appIDKey";
    public static final String appCategoryKey = "appIDKey";


    public static final String commandUserSignUp = "sign up a new user account";
    public static final String commandUserSignIn = "sign in to user account";
    public static final String commandDeveloperSignUp = "sign up a new developer account";
    public static final String commandNewCompany = "add new company";
    public static final String commandNewAPP = "add new application";
    public static final String commandNewReview = "add a review";
    public static final String commandGetReviews = "get reviews";
    public static final String commandSearchAPPs = "search apps";
    public static final String byCategory = "by category";
    public static final String byName = "by name";
    public static final String commandTopApps = "top apps";
    public static final String free = "free";
    public static final String notFree = "not free";
    public static final String any = "any";
    public static final String commandSimilarAPPs = "similar applications";
    public static final String commandDownloadAPP = "download an application";
    public static final String commandUpdateAPP = "update application";
    public static final String specific = "specific application";
    public static final String all = "all applications";
    public static final String commandViewUpdatable = "view updatable applications";
    public static final String commandViewDownloaded = "view downloaded applications";
    public static final String commandAddEmployer = "add employer company";
    public static final String commandViewCompanyAPPS = "view applications of a certain company";
    public static final String commandUserSignOut = "sign out of user account";
    public static final String newVersion = "release a new update for an application";

    public static final String endProgram = "end";
    public static final String help = "help";


    public static final String helpList =
            "You may only enter one of the following commands:\n" +
                    "1. \"sign up a new user account\"  -> creating a new user account\n" +
                    "2. \"sign in to user account\"  -> sign in to your account\n" +
                    "3. \"create developer account\"  -> creating a new developer account\n" +
                    "4. \"add new company\"  -> adding a new company to the database\n" +
                    "5. \"add new application\"  -> adding a new application to the database (only for developer accounts)\n" +
                    "6. \"add a review\"  -> posting a review for an application\n" +
                    "7. \"get reviews\"  -> viewing all the reviews posted for an application\n" +
                    "8. \"search apps\"  -> performing a search on the existing applications by either category or name\n" +
                    "9. \"top apps\"  -> viewing the applications with the highest rating, filtered by price or unfiltered\n" +
                    "10. \"similar applications\"  -> viewing the applications that are similar to a certain applications\n" +
                    "11. \"download an application\"  -> download an application onto your device\n" +
                    "12. \"update application\"  -> update one of the existing applications on your device\n" +
                    "13. \"view updatable applications\"  -> view a list of applications that can be updated\n" +
                    "14. \"view downloaded applications\"  -> view a list of the applications you have downloaded\n" +
                    "15. \"add employer company\"  -> adding a new connection to a company (only for developer accounts)\n" +
                    "16. \"view applications of a certain company\"  -> view all the applications provided by a certain company\n" +
                    "17. \"sign out of user account\"  -> sign out of the current user account\n" +
                    "18. \"release a new update for an application\"  -> release a new version of an existing application (only for developer accounts)";

    public static final String welcomeMessage = "Hello!\n" +
            "Welcome to the APP Store database.\n" +
            "If at any point you wish to see the available commands, type \"help\"\n" +
            "Once you're done, type \"end\" to terminate the program";

    public static final String enterPassword = "You must login before performing queries.\n" +
            "If you don't have an account, type \"sign up a new user account\" or \"sign up a new developer account\" to create your account";
    public static final String goodbyeMessage = "Thank you for your time.";
    public static final String errorInCommandMessage = "The query you entered does not match any of the valid commands.\n" +
            "If you don't know what command to enter, type \"help\".";
}

//1. sign up a new user account
//        2. sign in to user account
//        3. create developer account
//        4. add new company
//        5. add new application (only for developer accounts)
//        6. add a review
//        7. get reviews (only for developer accounts)
//        8. search apps
//        - by category
//        - by name
//        9. top apps
//        - free
//        - not free
//        - any
//        10. similar applications
//        11. download an application
//        12. update application
//        - specific application
//        - all applications
//        13. view updatable applications
//        14. view downloaded applications
//        15. add employer company (only for developer accounts)
//        16. view applications of a certain company
