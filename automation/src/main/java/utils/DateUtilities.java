package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtilities {

    public String getUniqueString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    }

    public String getCurrentDateAndTime() {
        return getUniqueString();
    }

    public String getCurrentDateAndTimeFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return dtf.format(LocalDateTime.now());
    }

    public Long getTimestampCurrentTime() {
        // get current date
        Date currentDate = new Date();

        // return current time timestamp
        return currentDate.getTime();
    }

    public String getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        return String.valueOf(dayOfMonth);
    }

    public Long getTimestampTomorrow() {
        // get a calendar instance, which defaults to "now"
        Calendar calendar = Calendar.getInstance();

        // add one day to the date/calendar
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        // return tomorrow timestamp
        Date tomorrow = calendar.getTime();
        return tomorrow.getTime();
    }

    public Long getTimestampNextHour() {
        // get a calendar instance, which defaults to "now"
        Calendar calendar = Calendar.getInstance();

        // add one hour to the date/calendar
        calendar.add(Calendar.HOUR_OF_DAY, 1);

        // return timestamp
        Date currentTimeMoreHour = calendar.getTime();
        return currentTimeMoreHour.getTime();
    }

    public Long getTimestampYesterday() {
        // get a calendar instance, which defaults to "now"
        Calendar calendar = Calendar.getInstance();

        // remove one day to the date/calendar
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        // return tomorrow timestamp
        Date tomorrow = calendar.getTime();
        return tomorrow.getTime();
    }

    public String getActualDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
