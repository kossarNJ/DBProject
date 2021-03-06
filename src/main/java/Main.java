import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class Main {
    static boolean isLoggedIn = false;
    static String connectionUserID = "postgres";
    static String connectionPassword = "123";
    static String url = "jdbc:postgresql://localhost:5432/App_Store_DB";

    static String userID = "";
    static String password = "";



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isOver = false;
        CallQueries callQueries = new CallQueries();
        GetFurtherInput getFurtherInput = new GetFurtherInput();
        System.out.println(MyConstants.welcomeMessage);
        while (!isOver) {
            while (!isLoggedIn) {
                String input = scanner.nextLine();
                switch (input) {
                    case MyConstants.help:
                        System.out.println(MyConstants.helpList);
                        break;
                    case MyConstants.commandDeveloperSignUp:
                        HashMap<String, Object> result = getFurtherInput.signUpDeveloper(scanner);
                        String response = callQueries.signUpDeveloper((String) result.get(MyConstants.userEmailKey), (String) result.get(MyConstants.userPassKey), (String) result.get(MyConstants.fNameKey), (String) result.get(MyConstants.lNameKey), (String) result.get(MyConstants.postalCodeKey), (Date) result.get(MyConstants.dateOfBirthKey), (String) result.get(MyConstants.backupEmailKey), (String) result.get(MyConstants.imageURLKey), (String) result.get(MyConstants.telKey), (String) result.get(MyConstants.resumeKey), (String) result.get(MyConstants.appOSNameKey), (String) result.get(MyConstants.appOSVersionKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandUserSignUp:
                        result = getFurtherInput.signUpUser(scanner);
                        response = callQueries.signUpUser((String) result.get(MyConstants.userEmailKey), (String) result.get(MyConstants.userPassKey), (String) result.get(MyConstants.fNameKey), (String) result.get(MyConstants.lNameKey), (String) result.get(MyConstants.postalCodeKey), (Date) result.get(MyConstants.dateOfBirthKey), (String) result.get(MyConstants.backupEmailKey), (String) result.get(MyConstants.imageURLKey), (String) result.get(MyConstants.telKey), (String) result.get(MyConstants.appOSNameKey), (String) result.get(MyConstants.appOSVersionKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandUserSignIn:
                        result = getFurtherInput.signInUser(scanner);
                        response = callQueries.signInUser((String) result.get(MyConstants.userEmailKey), (String) result.get(MyConstants.userPassKey));
                        System.out.println(response);
                        break;
                    case MyConstants.endProgram:
                        isOver = true;
                        break;
                    default:
                        System.out.println(MyConstants.enterPassword);
                }
                if (isOver) {
                    break;
                }
            }

            while (isLoggedIn) {
                String input = scanner.nextLine();
                switch (input) {
                    case MyConstants.commandUserSignOut:
                        HashMap<String, Object> result = getFurtherInput.signOutUser(scanner);
                        String response = callQueries.signOutUser((String) result.get(MyConstants.userEmailKey), (String) result.get(MyConstants.userPassKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandNewCompany:
                        result = getFurtherInput.newCompany(scanner);
                        response = callQueries.newCompany((String) result.get(MyConstants.coIDKey), (String) result.get(MyConstants.coNameKey), (String) result.get(MyConstants.coAddressKey), (String) result.get(MyConstants.coFieldKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandNewAPP:
                        result = getFurtherInput.newAPP(scanner);
                        response = callQueries.newApp((String) result.get(MyConstants.appIDKey), (String) result.get(MyConstants.appCategoryKey), (String) result.get(MyConstants.appNameKey), (String) result.get(MyConstants.sizeKey), (String) result.get(MyConstants.priceKey), (String) result.get(MyConstants.iconKey), (String) result.get(MyConstants.appLanguageKey), (String) result.get(MyConstants.descriptionKey), (String) result.get(MyConstants.appOSNameKey), (String) result.get(MyConstants.appOSVersionKey), (String) result.get(MyConstants.appVersionKey), (String) result.get(MyConstants.coIDKey), (Date) result.get(MyConstants.appReleaseDateKey), (ArrayList<String>) result.get(MyConstants.permissionKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandNewReview:
                        result = getFurtherInput.newReview(scanner);
                        response = callQueries.newReview((String) result.get(MyConstants.appIDKey), (String) result.get(MyConstants.headingKey), (String) result.get(MyConstants.contextKey), (String) result.get(MyConstants.reviewRatingKey), (Date) result.get(MyConstants.reviewDateKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandGetReviews:
                        result = getFurtherInput.getReviews(scanner);
                        response = callQueries.getReviews((String) result.get(MyConstants.appIDKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandSearchAPPs:
                        result = getFurtherInput.searchApps(scanner);
                        if (result.keySet().contains(MyConstants.appNameKey)) {
                            response = callQueries.searchAppsByName((String) result.get(MyConstants.appNameKey));
                        } else {
                            response = callQueries.searchAppsByCategory((String) result.get(MyConstants.appCategoryKey));
                        }
                        System.out.println(response);
                        break;
                    case MyConstants.commandTopApps:
                        result = getFurtherInput.topApps(scanner);
                        if (result.get(MyConstants.filterTypeKey).equals(MyConstants.free)) {
                            response = callQueries.topFreeApps();
                        } else if (result.get(MyConstants.filterTypeKey).equals(MyConstants.notFree)) {
                            response = callQueries.topNotFreeApps();
                        } else {
                            response = callQueries.topApps();
                        }
                        System.out.println(response);
                        break;
//                    case MyConstants.commandSimilarAPPs:
//                        result = getFurtherInput.similarApps(scanner);
//                        response = callQueries.similarApps((String) result.get(MyConstants.appIDKey));
//                        System.out.println(response);
//                        break;
                    case MyConstants.commandDownloadAPP:
                        result = getFurtherInput.downloadApp(scanner);
                        response = callQueries.downloadApp((String) result.get(MyConstants.appIDKey), (Date) result.get(MyConstants.downloadDateKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandUpdateAPP:
                        result = getFurtherInput.updateApp(scanner);
                        if (result.get(MyConstants.updateTypeKey).equals(MyConstants.all)) {
                            response = callQueries.updateAllApps((Date) result.get(MyConstants.updateDateKey));
                        } else {
                            response = callQueries.updateSpecificApp((String) result.get(MyConstants.appIDKey), (Date) result.get(MyConstants.updateDateKey));
                        }
                        System.out.println(response);
                        break;
                    case MyConstants.commandViewUpdatable:
                        response = callQueries.viewUpdatable();
                        System.out.println(response);
                        break;
                    case MyConstants.commandViewDownloaded:
                        response = callQueries.viewDownloaded();
                        System.out.println(response);
                        break;
                    case MyConstants.commandViewCompanyAPPS:
                        result = getFurtherInput.viewCompanyApps(scanner);
                        response = callQueries.viewCompanyApps((String) result.get(MyConstants.coIDKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandAddEmployer:
                        result = getFurtherInput.addEmployer(scanner);
                        response = callQueries.addEmployer((String) result.get(MyConstants.coIDKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandNewVersion:
                        result = getFurtherInput.newVersion(scanner);
                        response = callQueries.newVersion((String) result.get(MyConstants.appVersionKey), (String) result.get(MyConstants.appIDKey), (Date) result.get(MyConstants.versionDateKey), (ArrayList<String>) result.get(MyConstants.addedFeaturesKey), (ArrayList<String>) result.get(MyConstants.resolvedBugsKey));
                        System.out.println(response);
                        break;
                    case MyConstants.commandRegisterBankAccount:
                        result = getFurtherInput.registerAccount(scanner);
                        response = callQueries.registerAccount((String) result.get(MyConstants.bankAccountKey));
                        System.out.println(response);
                        break;
                    case MyConstants.help:
                        System.out.println(MyConstants.helpList);
                        break;
                    case MyConstants.endProgram:
                        isOver = true;
                        break;
                    default:
                        System.out.println(MyConstants.errorInCommandMessage);
                }
                if (isOver) {
                    break;
                }
            }
        }

        System.out.println(MyConstants.goodbyeMessage);
    }
}
