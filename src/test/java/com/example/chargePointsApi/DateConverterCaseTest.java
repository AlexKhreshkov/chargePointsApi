package com.example.chargePointsApi;

import com.example.chargePointsApi.dateConverter.DateConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)

@SpringBootTest
public class DateConverterCaseTest {
    @Test
    public void testParseValidFormatWithTime1() throws ParseException {
        String str = "2020/03/01 13:10";
        Date expected = createDate(2020, 2, 1, 13, 10);
        Date actual = DateConverter.convert(str);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseValidFormatWithTime2() throws ParseException {
        String str = "2020-03-01 13:10";
        Date expected = createDate(2020, 2, 1, 13, 10);
        Date actual = DateConverter.convert(str);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseValidFormatWithoutTime() throws ParseException {
        String str = "2020-03-01";
        Date expected = createDate(2020, 2, 1, 0, 0);
        Date actual = DateConverter.convert(str);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseValidFormatWithoutTime2() throws ParseException {
        String str = "2020/03/01";
        Date expected = createDate(2020, 2, 1, 0, 0);
        Date actual = DateConverter.convert(str);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseInvalidFormat1() {
        String str = "2020//03/01 13:10";
        assertThrows(ParseException.class, () -> DateConverter.convert(str));
    }

    @Test
    public void testParseInvalidFormat2() {
        String str = "2020/03 13:10";
        assertThrows(ParseException.class, () -> DateConverter.convert(str));
    }

    @Test
    public void testParseInvalidFormat3() {
        String str = "2020/03 13:10";
        assertThrows(ParseException.class, () -> DateConverter.convert(str));
    }

    @Test
    public void testParseInvalidFormat4() {
        String str = "/2020//03/01 13:10";
        assertThrows(ParseException.class, () -> DateConverter.convert(str));
    }

    @Test
    public void testParseInvalidFormat5() {
        String str = "/2020/03/01/ 13:10";
        assertThrows(ParseException.class, () -> DateConverter.convert(str));
    }

    @Test
    private Date createDate(int year, int month, int day, int hour, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minute, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
