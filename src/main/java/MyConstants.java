/**
 * Created by saharzargarzadeh on 1/27/18.
 */
class MyConstants {

    static final String userEmailKey = "userEmail";
    static final String userPassKey = "userPass";
    static final String fNameKey = "fName";
    static final String lNameKey = "lName";
    static final String postalCodeKey = "postalCode";
    static final String dateOfBirthKey = "dateOfBirth";
    static final String backupEmailKey = "backupEmail";
    static final String imageURLKey = "imageURL";
    static final String telKey = "telephone";

    static final String resumeKey = "resume";

    static final String coIDKey = "coID";
    static final String coNameKey = "coName";
    static final String coAddressKey = "coAddress";
    static final String coFieldKey = "coField";

    static final String appIDKey = "appIDKey";
    static final String appVersionKey = "appIDKey";
    static final String appOSVersionKey = "appIDKey";
    static final String appOSNameKey = "appIDKey";
    static final String descriptionKey = "appIDKey";
    public static final String rateKey = "appIDKey";
    static final String appLanguageKey = "appIDKey";
    static final String appNameKey = "appIDKey";
    static final String iconKey = "appIDKey";
    static final String priceKey = "appIDKey";
    static final String sizeKey = "appIDKey";
    static final String appCategoryKey = "appIDKey";
    static final String appReleaseDateKey = "appReleaseDateKey";

    static final String headingKey = "headingKey";
    static final String contextKey = "contextKey";
    static final String reviewRatingKey = "reviewRatingKey";
    static final String reviewDateKey = "reviewDateKey";
    public static final String reviewIDKey = "reviewIDKey";


    static final String updateDateKey = "updateDateKey";

    static final String versionDateKey = "versionDateKey";

    static final String bankAccountKey = "bankAccountKey";

    static final String permissionKey = "permissionKey";

    static final String addedFeaturesKey = "addedFeaturesKey";

    static final String resolvedBugsKey = "resolvedBugsKey";

    static final String commentNumber = "comment_number";
    static final String heading = "heading";
    static final String content = "review_content";
    static final String rating = "rating";
    static final String date = "review_date";

    static final String name = "name";
    static final String size = "size";
    static final String price = "price";
    static final String icon = "icon";
    static final String app_language = "app_language";
    static final String rate = "rate";
    static final String description = "description";
    static final String os_name = "os_name";
    static final String os_version = "os_version";
    static final String co_id = "co_id";
    static final String last_version = "last_version";
    static final String app_id = "app_id";
    static final String category = "category";






    static final String commandUserSignUp = "sign up a new user account";
    static final String commandUserSignIn = "sign in to user account";
    static final String commandDeveloperSignUp = "sign up a new developer account";
    static final String commandNewCompany = "add new company";
    static final String commandNewAPP = "add new application";
    static final String commandNewReview = "add a review";
    static final String commandGetReviews = "get reviews";
    static final String commandSearchAPPs = "search apps";
    static final String byCategory = "by category";
    static final String byName = "by name";
    static final String commandTopApps = "top apps";
    static final String free = "free";
    static final String notFree = "not free";
    static final String any = "any";
    static final String commandSimilarAPPs = "similar applications";
    static final String commandDownloadAPP = "download an application";
    static final String commandUpdateAPP = "update application";
    static final String specific = "specific application";
    static final String all = "all applications";
    static final String commandViewUpdatable = "view updatable applications";
    static final String commandViewDownloaded = "view downloaded applications";
    static final String commandAddEmployer = "add employer company";
    static final String commandViewCompanyAPPS = "view applications of a certain company";
    static final String commandUserSignOut = "sign out of user account";
    static final String commandNewVersion = "release a new update for an application";
    static final String commandRegisterBankAccount = "register bank account";

    static final String endProgram = "end";
    static final String help = "help";
    static final String filterTypeKey = "filterTypeKey";
    static final String updateTypeKey = "updateTypeKey";

    static final String downloadDateKey = "downloadDateKey";





    static final String helpList =
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
                    "18. \"release a new update for an application\"  -> release a new version of an existing application (only for developer accounts)\n" +
                    "19. \"register bank account\"  -> register your bank account in the database.";

    static final String welcomeMessage = "Hello!\n" +
            "Welcome to the APP Store database.\n" +
            "If at any point you wish to see the available commands, type \"help\"\n" +
            "Once you're done, type \"end\" to terminate the program";

    static final String enterPassword = "You must login before performing queries.\n" +
            "If you don't have an account, type \"sign up a new user account\" or \"sign up a new developer account\" to create your account";
    static final String goodbyeMessage = "Thank you for your time.";
    static final String searchTypeMessage = "How do you wish to search the apps?";
    static final String topAppsTypeMessage = "Which kind of applications do you wish to filter?";
    static final String updateAppsTypeMessage = "Which applications do you wish to update?";
    static final String errorIncorrectUserPassMessage = "The username or connectionPassword you entered is incorrect.";
    static final String errorLogOutMessage = "Your are not logged in or you have entered the wrong username or connectionPassword.";
    static final String errorNotDevMessage = "Your account is not a developer account, therefore you may not perform this query.";
    static final String errorSearchTypeMessage = "You may only search:\n" +
            "- by category\n" +
            "- by name";
    static final String errorTopAppTypeMessage = "You may only filter applications that are:\n" +
            "- free\n" +
            "- not free\n" +
            "- any";
    static final String errorUpdateTypeMessage = "You may only update:\n" +
            "- all\n" +
            "- specific";
    static final String errorInCommandMessage = "The query you entered does not match any of the valid commands.\n" +
            "If you don't know what command to enter, type \"help\".";
    static final String errorNoAPP = "There is no such application in the database.";
    static final String errorNoAPPFree = "There are no free applications in the database.";
    static final String errorNoAPPAtAll = "There are no applications in the database.";
    static final String errorNoAPPNotFree = "There are no not free applications in the database.";
    static final String errorNoAPPCategory = "There are no applications in this category.";
    static final String errorNoAPPName = "There are no applications with this name.";
    static final String errorNoReview = "There are no reviews for this application.";
    static final String errorNoDownloadedApp = "You do not have any downloaded applications.";
    static final String errorNoCompanyApp = "There are no applications developed by this company.";
    static final String errorNoUpdatableApp = "You do not have any updatable applications.";
    static final String errorNotUpdatableApp = "The application may not be updated.";
}
