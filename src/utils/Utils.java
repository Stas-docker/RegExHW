package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final Pattern ORDER_UUID_PATTERN = Pattern.compile("orderUUID=[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
    private static final Pattern USER_EMAIL_PATTERN = Pattern.compile("\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b");
    private static final Pattern ORDER_TIMES_PATTERN = Pattern.compile("total number of orders successfully processed:\\s*\\[\\d+\\]",
            Pattern.CASE_INSENSITIVE);

    public static String findAndReturnOrderUUID(final String information) {
        String orderUUID;
        Matcher matcher = ORDER_UUID_PATTERN.matcher(information);
        if (matcher.find()) {
            orderUUID = matcher.group();
        } else {
            orderUUID = "\nThere is no order ID in this message";
        }
        return orderUUID;
    }

    public static String findAndReturnUserEmail(final String information) {
        String userEmail;
        Matcher matcher = USER_EMAIL_PATTERN.matcher(information);
        if (matcher.find()) {
            userEmail = matcher.group();
        } else {
            userEmail = "There is no user email in this message";
        }
        return userEmail;
    }

    public static String findAndReturnOrderTimesInfo(final String information) {
        String orderTimes;
        Matcher matcher = ORDER_TIMES_PATTERN.matcher(information);
        if (matcher.find()) {
            orderTimes = matcher.group();
        } else {
            orderTimes = "There is not written how many times you ordered this item";
        }
        return orderTimes;
    }
}
