import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class FrenchPublicHolidays {

    /**
     * Returns the number of working days between two dates, i.e. all the days except weekends and public holidays.
     * Start date at midnight inclusive, end date at midnight exclusive
     */
    public static int getWorkingDays(LocalDate fromDate, LocalDate toDate) {
        int workingDays = 0;
        while (!fromDate.isEqual(toDate)) {
            DayOfWeek day = fromDate.getDayOfWeek();
            if ((day != DayOfWeek.SATURDAY) && (day != DayOfWeek.SUNDAY) && !isHoliday(fromDate)) workingDays++;
            fromDate = fromDate.plusDays(1);
        }
        return workingDays;
    }

    /**
     *
     * @return true if the given date is a french public holiday
     */
    public static boolean isHoliday(LocalDate date) {
        return getHolidays(date.getYear()).keySet() .stream()
                                                    .anyMatch(holiday -> holiday.equals(date));
    }

    /**
     * Returns a map of (date:public holiday name) of all the french public holidays for the given year
     */
    public static Map<LocalDate, String> getHolidays(int year) {

        Map<LocalDate, String> holidays = new HashMap<>();

        holidays.put(LocalDate.of(year, 1, 1), "Jour de l'an");
        holidays.put(LocalDate.of(year, 5, 1), "Fête du travail");
        holidays.put(LocalDate.of(year, 5, 8), "Victoire 1945");
        holidays.put(LocalDate.of(year, 7, 14), "Fête nationale");
        holidays.put(LocalDate.of(year, 8, 15), "Assomption");
        holidays.put(LocalDate.of(year, 11, 1), "Toussaint");
        holidays.put(LocalDate.of(year, 11, 11), "Armistice 1918");
        holidays.put(LocalDate.of(year, 12, 25), "Noël");

        LocalDate easter = getEasterSundayDate(year);
        LocalDate easterMondayHoliday = getEasterMondayHoliday(year);

        holidays.put(easterMondayHoliday, "Lundi de Pâques");
        holidays.put(getAscensionHoliday(easter), "Jeudi de l'Ascension");
        holidays.put(getPentecostMondayHoliday(easter), "Lundi de Pentecôte");

        return holidays;
    }

    private static LocalDate getEasterMondayHoliday(int year) {
        return getEasterSundayDate(year).plusDays(1);
    }

    private static LocalDate getEasterSundayDate(int year) {
        int a, b, c, d, e, f, g, h, i, j, k, l;
        int x, month, day;
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        j = c % 4;
        k = (32 + 2 * e + 2 * i - h - j) % 7;
        l = (a + 11 * h + 22 * k) / 451;
        x = h + k - 7 * l + 114;
        month = x / 31;
        day = (x % 31) + 1;

        return LocalDate.of(year, month, day);
    }

    private static LocalDate getPentecostMondayHoliday(LocalDate easter) {
        return getPentecostSunday(easter).plusDays(1);
    }

    private static LocalDate getPentecostSunday(LocalDate easter) {
        int pentecostDay = 1;
        int pentecostMonth = 1;

        if (easter.getMonth() == Month.MARCH) {
            pentecostDay = 49 - (31 - easter.getDayOfMonth() + 30);
            pentecostMonth = 5;
        }

        if (easter.getMonth() == Month.APRIL && easter.getDayOfMonth() <= 12) {
            pentecostDay = 49 - (30 - easter.getDayOfMonth());
            pentecostMonth = 5;
        }

        if (easter.getMonth() == Month.APRIL && easter.getDayOfMonth() > 12) {
            pentecostDay = 49 - (30 - easter.getDayOfMonth() + 31);
            pentecostMonth = 6;
        }

        return LocalDate.of(easter.getYear(), pentecostMonth, pentecostDay);
    }

    private static LocalDate getAscensionHoliday(LocalDate easter) {
        int ascensionDay = 1;
        int ascensionMonth = 1;
        if (easter.getDayOfMonth() == 22 && easter.getMonth() == Month.MARCH) {
            ascensionDay = 30;
            ascensionMonth = 4;
        }

        if (easter.getDayOfMonth() > 22 && easter.getMonth() == Month.MARCH) {
            ascensionDay = 39 - (31 - easter.getDayOfMonth() + 30);
            ascensionMonth = 5;
        }

        if (easter.getDayOfMonth() <= 22 && easter.getMonth() == Month.APRIL) {
            ascensionDay = 39 - (30 - easter.getDayOfMonth());
            ascensionMonth = 5;
        }

        if (easter.getDayOfMonth() > 22 && easter.getMonth() == Month.APRIL) {
            ascensionDay = 39 - (30 - easter.getDayOfMonth() + 31);
            ascensionMonth = 6;
        }

        return LocalDate.of(easter.getYear(), ascensionMonth, ascensionDay);
    }

}
