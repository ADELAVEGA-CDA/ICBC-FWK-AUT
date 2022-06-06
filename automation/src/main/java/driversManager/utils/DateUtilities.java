package driversManager.utils;

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

    public String getDateString() {
        Date date = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateNow = formatDate.format(date);
        String dateName = dateNow.replace("/", "").replace(":", "")
                .replace(" ", "_");
        return dateName;
    }

    public String getCurrentDateAndTime() {
        return getUniqueString();
    }

    public String getCurrentDateAndTimeFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return dtf.format(LocalDateTime.now());
    }

    public Long getTimestampCurrentTime() {
        Date currentDate = new Date();
        return currentDate.getTime();
    }

    public String getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        return String.valueOf(dayOfMonth);
    }

    public Long getTimestampTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        Date tomorrow = calendar.getTime();
        return tomorrow.getTime();
    }

    public Long getTimestampNextHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 1);

        Date currentTimeMoreHour = calendar.getTime();
        return currentTimeMoreHour.getTime();
    }

    public Long getTimestampYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        Date tomorrow = calendar.getTime();
        return tomorrow.getTime();
    }

    public String getActualDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
