import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FrenchPublicHolidaysTest {

    @Test
    public void getBusinessDays_should_compute_days_between_two_dates_no_weekend(){
        // Given
        LocalDate startDate = LocalDate.of(2016, 1, 6);
        LocalDate endDate = LocalDate.of(2016, 1, 7);

        // When
        int result = FrenchPublicHolidays.getWorkingDays(startDate, endDate);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void getBusinessDays_should_compute_days_between_two_dates_with_weekend(){
        // Given
        LocalDate startDate = LocalDate.of(2016, 1, 6);
        LocalDate endDate = LocalDate.of(2016, 1, 12);

        // When
        int result = FrenchPublicHolidays.getWorkingDays(startDate, endDate);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void getBusinessDays_should_compute_days_between_two_dates(){
        // Given
        LocalDate startDate = LocalDate.of(2016, 1, 6);
        LocalDate endDate = LocalDate.of(2016, 2, 15);

        // When
        int result = FrenchPublicHolidays.getWorkingDays(startDate, endDate);

        // Then
        assertEquals(28, result);
    }

    @Test
    public void getBusinessDays_should_compute_days_between_two_dates_ends_on_weekend_day(){
        // Given
        LocalDate startDate = LocalDate.of(2016, 2, 26);
        LocalDate endDate = LocalDate.of(2016, 2, 27);

        // When
        int result = FrenchPublicHolidays.getWorkingDays(startDate, endDate);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void isHoliday_newYear(){
        // Given
        LocalDate date = LocalDate.of(2016, 1, 1);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_workday(){
        // Given
        LocalDate date = LocalDate.of(2016, 1, 2);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertFalse(result);
    }

    @Test
    public void isHoliday_feteTravail(){
        // Given
        LocalDate date = LocalDate.of(2016, 5, 1);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_victoire1945(){
        // Given
        LocalDate date = LocalDate.of(2016, 5, 8);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_bastilleDay(){
        // Given
        LocalDate date = LocalDate.of(2016, 7, 14);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_assomption(){
        // Given
        LocalDate date = LocalDate.of(2016, 8, 15);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_armistice1918(){
        // Given
        LocalDate date = LocalDate.of(2016, 11, 11);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_christmas(){
        // Given
        LocalDate date = LocalDate.of(2016, 12, 25);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_easter_2016(){
        // Given
        LocalDate date = LocalDate.of(2016, 3, 28);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_easter_2017(){
        // Given
        LocalDate date = LocalDate.of(2017, 4, 17);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_easter_2018(){
        // Given
        LocalDate date = LocalDate.of(2018, 4, 2);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_ascension_2015(){
        // Given
        LocalDate date = LocalDate.of(2015, 5, 14);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_ascension_2016(){
        // Given
        LocalDate date = LocalDate.of(2016, 5, 5);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_ascension_2011(){
        // Given
        LocalDate date = LocalDate.of(2011, 6, 2);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_ascension_2008(){
        // Given
        LocalDate date = LocalDate.of(2008, 5, 1);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_pentecost_2015(){
        // Given
        LocalDate date = LocalDate.of(2015, 5, 25);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_pentecost_2016(){
        // Given
        LocalDate date = LocalDate.of(2016, 5, 16);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void isHoliday_pentecost_2017(){
        // Given
        LocalDate date = LocalDate.of(2017, 6, 5);

        // When
        boolean result = FrenchPublicHolidays.isHoliday(date);

        // Then
        assertTrue(result);
    }

    @Test
    public void getHolidays_2019_with_lenient_days() {
        FrenchPublicHolidays.getHolidays(2019);
    }

}
