package com.vilyever.unitconversion;

/**
 * TimeConverter
 * AndroidUnitConversion <com.vilyever.vdunitconversion>
 * Created by vilyever on 2015/9/15.
 * Feature:
 */
public class TimeConverter {
    private final TimeConverter self = this;

    /* Public Methods */
    public static long convertMillisecondsToSeconds(long milliseconds) {
        return convertUnit(milliseconds, TimeUnits.Millisecond, TimeUnits.Second);
    }
    public static long convertMillisecondsToMinutes(long milliseconds) {
        return convertUnit(milliseconds, TimeUnits.Millisecond, TimeUnits.Minute);
    }
    public static long convertMillisecondsToHours(long milliseconds) {
        return convertUnit(milliseconds, TimeUnits.Millisecond, TimeUnits.Hour);
    }

    public static long convertSecondsToMilliseconds(long seconds) {
        return convertUnit(seconds, TimeUnits.Second, TimeUnits.Millisecond);
    }
    public static long convertSecondsToMinutes(long seconds) {
        return convertUnit(seconds, TimeUnits.Second, TimeUnits.Minute);
    }
    public static long convertSecondsToHours(long seconds) {
        return convertUnit(seconds, TimeUnits.Second, TimeUnits.Hour);
    }

    public static long convertMinutesToMilliseconds(long minutes) {
        return convertUnit(minutes, TimeUnits.Minute, TimeUnits.Millisecond);
    }
    public static long convertMinutesToSeconds(long minutes) {
        return convertUnit(minutes, TimeUnits.Minute, TimeUnits.Second);
    }
    public static long convertMinutesToHours(long minutes) {
        return convertUnit(minutes, TimeUnits.Minute, TimeUnits.Hour);
    }

    public static long convertHoursToMilliseconds(long hours) {
        return convertUnit(hours, TimeUnits.Hour, TimeUnits.Millisecond);
    }
    public static long convertHoursToSeconds(long hours) {
        return convertUnit(hours, TimeUnits.Hour, TimeUnits.Second);
    }
    public static long convertHoursToMinutes(long hours) {
        return convertUnit(hours, TimeUnits.Hour, TimeUnits.Minute);
    }

    public static long convertUnit(long fromValue, TimeUnits fromUnit, TimeUnits toUnit) {
        long toValue = fromValue;

        if (fromUnit.ordinal() < toUnit.ordinal()) {
            for (int ordinal = 0; ordinal < TimeUnits.values().length; ordinal++) {
                if (ordinal >= fromUnit.ordinal() && ordinal < toUnit.ordinal()) {
                    toValue /= TimeUnits.values()[ordinal].upwardFactor();
                }
            }
        }
        else if (fromUnit.ordinal() > toUnit.ordinal()) {
            for (int ordinal = TimeUnits.values().length - 1; ordinal >= 0; ordinal--) {
                if (ordinal <= fromUnit.ordinal() && ordinal > toUnit.ordinal()) {
                    toValue *= TimeUnits.values()[ordinal].downwardFactor();
                }
            }
        }

        return toValue;
    }

    public static String convertMillisecondsToString(long milliseconds, TimeUnits stringBeginUnit, TimeUnits stringEndUnit) {
        return convertToString(milliseconds, TimeUnits.Millisecond, stringBeginUnit, stringEndUnit);
    }

    public static String convertSecondsToString(long seconds, TimeUnits stringBeginUnit, TimeUnits stringEndUnit) {
        return convertToString(seconds, TimeUnits.Second, stringBeginUnit, stringEndUnit);
    }

    public static String convertMinutesToString(long minutes, TimeUnits stringBeginUnit, TimeUnits stringEndUnit) {
        return convertToString(minutes, TimeUnits.Minute, stringBeginUnit, stringEndUnit);
    }

    public static String convertHoursToString(long hours, TimeUnits stringBeginUnit, TimeUnits stringEndUnit) {
        return convertToString(hours, TimeUnits.Hour, stringBeginUnit, stringEndUnit);
    }

    public static String convertToString(long fromValue, TimeUnits fromUnit, TimeUnits stringBeginUnit, TimeUnits stringEndUnit) {
        long milliseconds = convertUnit(fromValue, fromUnit, TimeUnits.Millisecond);

        StringBuilder builder = new StringBuilder("");

        for (int ordinal = TimeUnits.values().length - 1; ordinal >= 0; ordinal--) {
            if ((ordinal >= stringBeginUnit.ordinal() && ordinal <= stringEndUnit.ordinal())
                || (ordinal <= stringBeginUnit.ordinal() && ordinal >= stringEndUnit.ordinal())) {
                TimeUnits category = TimeUnits.values()[ordinal];
                switch (category) {
                    case Hour:
                        builder.append(String.format(category.formatParam(), milliseconds / 1000 / 60 / 60));
                        break;
                    case Minute:
                        if (builder.length() > 0) {
                            builder.append(":");
                        }
                        builder.append(String.format(category.formatParam(), milliseconds / 1000 / 60 % 60));
                        break;
                    case Second:
                        if (builder.length() > 0) {
                            builder.append(":");
                        }
                        builder.append(String.format(category.formatParam(), milliseconds / 1000 % 60));
                        break;
                    case Millisecond:
                        if (builder.length() > 0) {
                            builder.append(".");
                        }
                        builder.append(String.format(category.formatParam(), milliseconds % 1000));
                        break;
                }
            }
        }

        return builder.toString();
    }


    /* Enums */
    public enum TimeUnits {
        Millisecond, Second, Minute, Hour;

        public long downwardFactor() {
            switch (this) {
                case Millisecond:
                    return 1l;
                case Second:
                    return 1000l;
                case Minute:
                    return 60l;
                case Hour:
                    return 60l;
            }

            return 1l;
        }

        public long upwardFactor() {
            switch (this) {
                case Millisecond:
                    return 1000l;
                case Second:
                    return 60l;
                case Minute:
                    return 60l;
                case Hour:
                    return 1l;
            }

            return 1l;
        }

        public String formatParam() {
            switch (this) {
                case Millisecond:
                    return "%03d";
                case Second:
                    return "%02d";
                case Minute:
                    return "%02d";
                case Hour:
                    return "%02d";
            }

            return "%02d";
        }
    }
}