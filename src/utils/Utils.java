package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final Pattern ORDER_UUID_PATTERN = Pattern.compile("orderUUID=[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}");
    private static final Pattern USER_EMAIL_PATTERN = Pattern.compile("\\b[\\w._%+-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}\\b");
    private static final Pattern ORDER_TIMES_PATTERN = Pattern.compile("total number of orders successfully processed:\\s*\\[\\d+\\]",
            Pattern.CASE_INSENSITIVE);

    public static String findAndReturnOrderUUID(final String information) {
        final String orderUUID;
        final Matcher matcher = ORDER_UUID_PATTERN.matcher(information);
        if (matcher.find()) {
            orderUUID = matcher.group();
        } else {
            orderUUID = "\nThere is no order ID in this message";
        }
        return orderUUID;
    }

    public static String findAndReturnUserEmail(final String information) {
        final String userEmail;
        final Matcher matcher = USER_EMAIL_PATTERN.matcher(information);
        if (matcher.find()) {
            userEmail = matcher.group();
        } else {
            userEmail = "There is no user email in this message";
        }
        return userEmail;
    }

    public static String findAndReturnOrderTimesInfo(final String information) {
        final String orderTimes;
        final Matcher matcher = ORDER_TIMES_PATTERN.matcher(information);
        if (matcher.find()) {
            orderTimes = matcher.group();
        } else {
            orderTimes = "There is not written how many times you ordered this item";
        }
        return orderTimes;
    }
}
