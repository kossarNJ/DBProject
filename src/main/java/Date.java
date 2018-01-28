/**
 * Created by saharzargarzadeh on 1/27/18.
 */
public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static Date getDateFromString(String date) {
        try {
            String[] split = date.split("-");
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            return new Date(day, month, year);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        String dayS = String.valueOf(day);
        while (dayS.length() < 2) {
            dayS = "0" + dayS;
        }
        String yearS = String.valueOf(year);
        while (dayS.length() < 4) {
            yearS = "0" + yearS;
        }
        String monthS = String.valueOf(month);
        while (dayS.length() < 2) {
            monthS = "0" + monthS;
        }
        result = yearS + monthS + dayS;
        return result;
    }
}
